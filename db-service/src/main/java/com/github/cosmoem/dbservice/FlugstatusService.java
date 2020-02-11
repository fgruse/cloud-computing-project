package com.github.cosmoem.dbservice;

import com.github.cosmoem.dbservice.jpa.entity.Flugstatus;
import com.github.cosmoem.dbservice.jpa.repository.FlugstatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlugstatusService {

   @Autowired
   FlugstatusRepository flugstatusRepository;

   public Flugstatus getFlugstatus(String flugnummer) {
       return flugstatusRepository.findByFlugnummer(flugnummer);
   }
}
