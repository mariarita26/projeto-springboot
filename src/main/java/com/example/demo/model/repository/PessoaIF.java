package com.example.demo.model.repository;

import com.example.demo.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PessoaIF extends JpaRepository<Pessoa,Long> {

    Pessoa findByNome(String nome);

    Optional<Pessoa> findById(UUID idUser);
}
