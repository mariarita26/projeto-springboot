package com.example.demo.model.repository;

import com.example.demo.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaIF extends JpaRepository<Pessoa,Long> {


}
