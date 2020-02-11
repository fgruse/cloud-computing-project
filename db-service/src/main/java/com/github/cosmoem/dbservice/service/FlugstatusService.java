package com.github.cosmoem.dbservice.service;

import com.github.cosmoem.dbservice.jpa.entity.Flugstatus;
import com.github.cosmoem.dbservice.jpa.repository.FlugstatusRepository;
import java.net.ConnectException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import javax.annotation.PostConstruct;
import net.jodah.failsafe.CircuitBreaker;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlugstatusService {

   @Autowired
   FlugstatusRepository flugstatusRepository;

    private final CircuitBreaker<Flugstatus> circuitBreaker = new CircuitBreaker<>();
    private final RetryPolicy<Flugstatus> retryPolicy = new RetryPolicy<>();

    private void configureCircuit() {
        this.circuitBreaker
                .withFailureThreshold(3, 10)
                .withSuccessThreshold(5)
                .withDelay(Duration.ofMinutes(1))
                .handle(ConnectException.class);
    }

    private void configureRetries() {
        this.retryPolicy
                .handle(ConnectException.class)
                .withBackoff(10, 50, ChronoUnit.MILLIS, 2)
                .withJitter(Duration.ofMillis(10))
                .withMaxRetries(3)
                .withMaxDuration(Duration.ofSeconds(1));
    }

    @PostConstruct
    public void init() {
        configureCircuit();
        configureRetries();
    }

   public Flugstatus getFlugstatus(String flugnummer) {
       return Failsafe.with(retryPolicy, circuitBreaker).get(() -> flugstatusRepository.findByFlugnummer(flugnummer));
   }
}
