package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_cliente")
@Data
@EqualsAndHashCode
public class Pessoa {

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="email")
    private String email;

    @Column(name="senha")
    private String senha;

//    @Column(name="telefone")
//    private String telefone;
//
//    @Column(name="cpf")
//    private String cpf;
//
//    @Column(name="data_de_nascimento")
//    private LocalDate dataDeNascimento;
//
//    @Column(name="imagem")
//    private String imagem;

    @ManyToMany
    private List<Role> roles;



//    @OneToMany(fetch = FetchType.LAZY,mappedBy = "cliente",cascade = CascadeType.REMOVE,orphanRemoval=true)
//    private List<Produto> produtos = new ArrayList<>();
}

