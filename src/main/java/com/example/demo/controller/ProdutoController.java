package com.example.demo.controller;

import com.example.demo.model.entity.Pessoa;
import com.example.demo.model.entity.Produto;
import com.example.demo.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

//    @GetMapping
//    public List<Produto> listarProduto() {
//        return this.produtoService.listarProduto();
//    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Produto>> getProdutos(){
        List<Produto> produtos = produtoService.getAllProduto();
        if(produtos.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(produtos,HttpStatus.OK);
    }

    @PostMapping
    public Produto inserir(@RequestBody Produto produtoAInserir) {
        return this.produtoService.inserirOuAtualizar(produtoAInserir);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable("id") Long idProduto,
                            @RequestBody Produto produtoAAtualizar) {
        produtoAAtualizar.setId(idProduto);
        return this.produtoService.inserirOuAtualizar(produtoAAtualizar);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable("id") Long id) {
        this.produtoService.apagar(id);
    }
}

