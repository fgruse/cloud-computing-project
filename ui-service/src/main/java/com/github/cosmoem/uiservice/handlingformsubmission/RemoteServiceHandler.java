package com.github.cosmoem.uiservice.handlingformsubmission;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteServiceHandler {

    private final RestTemplate restTemplate;
    private final String urlFluginfo;
    private final String urlFlugstatus;

    public RemoteServiceHandler(
            @Value("${remote.service.db.url}") final String urlFluginfo,
            @Value("${remote.service.data.url}") final String getUrlFlugstatus) {
        this.urlFluginfo = urlFluginfo;
        this.urlFlugstatus = getUrlFlugstatus;
        restTemplate = new RestTemplate();
    }

    @HystrixCommand(fallbackMethod = "returnDefaultFlight")
    public Flug getFluginfo(String flugnummer) {
        String requestUrl = urlFluginfo + "api/flug/" + flugnummer;
        Flug result = restTemplate.getForObject(requestUrl, Flug.class);
        if(result != null) return result;
        else return new Flug(flugnummer);
    }

    private Flug returnDefaultFlight(String flugnummer) {
        return new Flug();
    }

    @HystrixCommand(fallbackMethod = "returnDefaultString")
    public String getFlugstatus(String flugnummer) {
        String requestUrl = urlFlugstatus + "api/status/" + flugnummer;
        return restTemplate.getForObject(requestUrl, String.class);
    }

    private String returnDefaultString(String flugnummer) {
        return "CURRENTLY NOT AVAILABLE";
    }
}
