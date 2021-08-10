package com.example.CRUD.repository;

import com.example.CRUD.model.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Countries, Integer> {

    Optional<Countries> findById(int id);
}
