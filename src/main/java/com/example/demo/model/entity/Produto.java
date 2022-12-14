package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_produto")
@Data
@EqualsAndHashCode
public class Produto {

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="titulo")
    private String titulo;

    @Column(name="valor")
    private double valor;

    @Column(name="foto")
    private String foto;

    @Column(name="informacao")
    private String informacao;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private Pessoa cliente;

}
