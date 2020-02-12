package com.github.cosmoem.dbservice.jpa.repository;

import com.github.cosmoem.dbservice.jpa.entity.Fluginfo;
import org.springframework.data.repository.CrudRepository;

public interface FluginfoRepository extends CrudRepository<Fluginfo, Long> {

    public Fluginfo findByFlugnummer(String Flugnummer);

}
