package com.github.nkolytschew.userservicems.a2.mysql.jpa.repository;


import com.github.nkolytschew.userservicems.jpa.entity.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("mysql")
public interface UserRepository extends CrudRepository<User, Long> {
}
