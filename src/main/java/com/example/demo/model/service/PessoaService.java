package com.example.demo.model.service;

import com.example.demo.model.entity.Pessoa;
import com.example.demo.model.repository.PessoaIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaIF pessoaRepository;

    public List<Pessoa> listarPessoa() {
        return this.pessoaRepository.findAll();
    }
    public List<Pessoa> getAllPessoa() {
        return pessoaRepository.findAll();
    }

    public Pessoa getPessoaPorId(Long idPessoa) {
        return this.pessoaRepository.findById(idPessoa).orElse(null);
    }
    @Transactional
    public Pessoa inserirOuAtualizar(Pessoa pessoaAInserir) {
        Pessoa pessoaInserida = this.pessoaRepository.save(pessoaAInserir);

        return pessoaInserida;
    }

    public void apagar(Long id) {
        this.pessoaRepository.deleteById(id);
    }

    private BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public Pessoa execute(Pessoa user) {

        Pessoa existsUser = pessoaRepository.findByNome(user.getNome());

        if (existsUser != null) {
            throw new Error("User already exists!");
        }

        user.setSenha(passwordEncoder().encode(user.getSenha()));

        Pessoa createdUser = pessoaRepository.save(user);

        return createdUser;
    }
}

