package com.example.alpha.repository;

import com.example.alpha.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
    PersonEntity findByName(String personName);
}
