package com.example.demo.model.service;

import com.example.demo.model.entity.Produto;
import com.example.demo.model.repository.ProdutoIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoIF produtoRepository;

    public List<Produto> getAllProduto() { return produtoRepository.findAll(); }

    public Produto getProdutoPorId(Long idProduto) {
        return this.produtoRepository.findById(idProduto).orElse(null);
    }

    @Transactional
    public Produto inserirOuAtualizar(Produto produtoAInserir) {
        Produto produtoInserido = this.produtoRepository.save(produtoAInserir);

        return produtoInserido;
    }

    public void apagar(Long id) {
        this.produtoRepository.deleteById(id);
    }
}
