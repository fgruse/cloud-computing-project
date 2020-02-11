package com.github.cosmoem.dbservice;

import org.springframework.data.repository.CrudRepository;

public interface FlugstatusRepository extends CrudRepository<Flugstatus, Long> {

    public Flugstatus findByFlugnummer(String Flugnummer);

}
