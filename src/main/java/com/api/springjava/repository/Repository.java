package com.api.springjava.repository;

import com.api.springjava.model.Pessoa;

import org.springframework.data.repository.CrudRepository;



public interface Repository extends CrudRepository<Pessoa, Integer> {
    
}
