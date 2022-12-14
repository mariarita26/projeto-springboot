package com.example.demo.controller;

import com.example.demo.model.entity.Pessoa;
import com.example.demo.model.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Pessoa>> getPessoas(){
        List<Pessoa> pessoas = pessoaService.getAllPessoa();
        if(pessoas.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pessoas,HttpStatus.OK);
    }

//    @GetMapping
//    public List<Pessoa> listarPessoa() {
//        return this.pessoaService.listarPessoa();
//    }

    @GetMapping("/{id}")
    public Pessoa getPessoaPorId(@PathVariable("id") Long idPessoa) {
        return this.pessoaService.getPessoaPorId(idPessoa);
    }

    @PostMapping
    public Pessoa inserir(@RequestBody Pessoa pessoaAInserir) {
        return this.pessoaService.inserirOuAtualizar(pessoaAInserir);
    }

    @PutMapping("/{id}")
    public Pessoa atualizar(@PathVariable("id") Long idPessoa,
                            @RequestBody Pessoa pessoaAAtualizar) {
        pessoaAAtualizar.setId(idPessoa);
        return this.pessoaService.inserirOuAtualizar(pessoaAAtualizar);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable("id") Long id) {
        this.pessoaService.apagar(id);
    }

}
