package com.api.springjava.controller;

import com.api.springjava.model.Pessoa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController /* Define uma classe como responsável pelas rotas.
Cada métodos representa uma rota. */
public class Controller {

    @GetMapping("") // Marca o método como uma rota com requisição GET.
    public String mensagem() {
        return "Welcome to Spring!!!";
    }

    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome) {
        return "Bem vindo ao Spring Boot com Java, " + nome;
    }
    
    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa pessoa) {
        return pessoa;
    }
}