package com.api.springjava.controller;

import java.util.List;

import com.api.springjava.model.Pessoa;
import com.api.springjava.repository.Repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController /* Define uma classe como responsável pelas rotas.
Cada métodos representa uma rota. */
public class Controller {

    @Autowired
    private Repositorio acao;

    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa obj) {
        return acao.save(obj);
    }

    @GetMapping("/api")
    public List<Pessoa> selecionar() {
        return acao.findAll();
    }

    @GetMapping("/api/{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable int codigo) {
        return acao.findByCodigo(codigo);
    }

    @PutMapping("/api")
    public Pessoa editar(@RequestBody Pessoa obj) {
        return acao.save(obj);
    }

    @DeleteMapping("/api/{codigo}")
    public void remover(@PathVariable int codigo) {
        Pessoa obj = selecionarPeloCodigo(codigo);
        acao.delete(obj);
    }

    @GetMapping("api/contador")
    public long contador() {
        return acao.count();
    }

    @GetMapping("api/ordenarNomes")
    public List<Pessoa> ordenarNomes() {
        return acao.findByOrderByNome();
    }

    @GetMapping("api/ordenarNomes2")
    public List<Pessoa> ordenarNomes2() {
        return acao.findByNomeOrderByIdadeDesc("Davi Barros dos Santos");
    }

    @GetMapping("api/filtro")
    public List<Pessoa> selecionarPorTermo() {
        return acao.findByNomeContaining("Maria");
    }

    @GetMapping("api/iniciaCom")
    public List<Pessoa> iniciaCom() {
        return acao.findByNomeStartsWith("D");
    }

    @GetMapping("api/terminaCom")
    public List<Pessoa> terminaCom() {
        return acao.findByNomeEndsWith("s");
    }

    @GetMapping("/api/somaIdades")
    public int somarIdades() {
        return acao.somaIdades();
    }

    @GetMapping("/api/idadeMaiorIgual")
    public List<Pessoa> idadeMariorIgual() {
        return acao.idadeMaiorIgual(18);
    }
    
    //##############################################################################

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