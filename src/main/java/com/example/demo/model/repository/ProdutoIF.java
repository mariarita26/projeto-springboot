package com.example.demo.model.repository;

import com.example.demo.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoIF extends JpaRepository<Produto, Long> {
}
