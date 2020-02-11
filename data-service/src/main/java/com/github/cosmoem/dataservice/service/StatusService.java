package com.github.cosmoem.dataservice.service;

import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    public enum status {ON_TIME, DELAYED, CANCELLED}

    public status getStatus() {
        Random r = new Random();
        int num = r.nextInt(3);
        System.out.println(num);
        if(num == 0) {
            return status.ON_TIME;
        }
        else if(num == 1) {
            return status.DELAYED;
        }
        else {
            return status.CANCELLED;
        }
    }

}
