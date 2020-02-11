package com.github.cosmoem.uiservice.handlingformsubmission;

import java.net.ConnectException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import javax.annotation.PostConstruct;
import net.jodah.failsafe.CircuitBreaker;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class FlugController {

    private RestTemplate restTemplate = new RestTemplate();
    private final CircuitBreaker<Flug> circuitBreaker = new CircuitBreaker<>();
    private final RetryPolicy<Flug> retryPolicy = new RetryPolicy<>();
    private final CircuitBreaker<String> circuitBreakerString = new CircuitBreaker<>();
    private final RetryPolicy<String> retryPolicyString = new RetryPolicy<>();

    private void configureCircuit() {
        this.circuitBreaker
                .withFailureThreshold(3, 10)
                .withSuccessThreshold(5)
                .withDelay(Duration.ofMinutes(1))
                .handle(ConnectException.class);

        this.circuitBreakerString
                .withFailureThreshold(3, 10)
                .withSuccessThreshold(5)
                .withDelay(Duration.ofMinutes(1))
                .handle(Exception.class);
    }

    private void configureRetries() {
        this.retryPolicy
                .handle(ConnectException.class)
                .withBackoff(10, 50, ChronoUnit.MINUTES, 2)
                .withJitter(Duration.ofMillis(10))
                .withMaxRetries(3)
                .withMaxDuration(Duration.ofMinutes(100));

        this.retryPolicyString
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

    @GetMapping("/flug")
    public String flugForm(Model model) {
        model.addAttribute("flug", new Flug());
        return "flug";
    }

    @PostMapping("/flug")
    public String flugSubmit(@ModelAttribute Flug flug) {
        try {
            Flug res = Failsafe.with(retryPolicy, circuitBreaker).get(() -> restTemplate.getForObject("http://localhost:8083/api/flug/{flugnummer}", Flug.class, flug.getFlugnummer()));
            String status;
            try {
                status = Failsafe.with(retryPolicyString, circuitBreakerString).get(() -> restTemplate.getForObject("http://localhost:8989/api/status/{flugnummer}", String.class, flug.getFlugnummer()));
            }
            catch (Exception e) {
                status = "CURRENTLY NOT AVAILABLE";
            }
            if(res != null && status != null) {
                flug.setAirline(res.getAirline());
                flug.setFlugdatum(res.getFlugdatum());
                flug.setNach(res.getNach());
                flug.setVon(res.getVon());
                flug.setUhrzeit(res.getUhrzeit());
                flug.setFlugstatus(status.replaceAll("^\"|\"$", ""));
                return "result";
            }
            else {
                return "failure";
            }
        } catch (Exception e) {
            return "error";
        }
    }
}