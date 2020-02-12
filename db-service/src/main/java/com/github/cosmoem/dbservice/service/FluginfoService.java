package com.github.cosmoem.dbservice.service;

import com.github.cosmoem.dbservice.jpa.entity.Fluginfo;
import com.github.cosmoem.dbservice.jpa.repository.FluginfoRepository;
import java.net.ConnectException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class FluginfoService {

    private final FluginfoRepository fluginfoRepository;

    public FluginfoService(final FluginfoRepository fluginfoRepository) {
        this.fluginfoRepository = fluginfoRepository;
    }

    public Fluginfo getFluginfo(String flugnummer) {
       return this.fluginfoRepository.findByFlugnummer(flugnummer);
    }
}
