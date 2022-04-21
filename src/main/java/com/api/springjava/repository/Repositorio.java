package com.api.springjava.repository;

import java.util.List;

import com.api.springjava.model.Pessoa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer> {
    
    List<Pessoa> findAll();

    Pessoa findByCodigo(int codigo);

    List<Pessoa> findByOrderByNome();

    List<Pessoa> findByNomeOrderByIdadeDesc(String nome);

    List<Pessoa> findByNomeContaining(String termo);

    List<Pessoa> findByNomeStartsWith(String termo);

    List<Pessoa> findByNomeEndsWith(String termo);

    @Query(value="SELECT SUM(idade) FROM pessoas", nativeQuery=true)
    int somaIdades();

    @Query(value="SELECT * FROM pessoas WHERE idade >=:idade", nativeQuery=true)
    List<Pessoa> idadeMaiorIgual(int idade);
}
