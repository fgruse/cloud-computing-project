package com.github.cosmoem.dbservice.mysql.jpa.repository;


import com.github.cosmoem.dbservice.jpa.entity.Flugstatus;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("mysql")
public interface FlugstatusRepository extends CrudRepository<Flugstatus, Long> {
}
