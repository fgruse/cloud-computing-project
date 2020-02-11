package com.github.cosmoem.dbservice.jpa.repository;

import com.github.cosmoem.dbservice.jpa.entity.Flugstatus;
import org.springframework.data.repository.CrudRepository;

public interface FlugstatusRepository extends CrudRepository<Flugstatus, Long> {

    public Flugstatus findByFlugnummer(String Flugnummer);

}
