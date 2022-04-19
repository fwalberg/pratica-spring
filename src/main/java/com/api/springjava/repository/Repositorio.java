package com.api.springjava.repository;

import com.api.springjava.model.Pessoa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer> {
    
}
