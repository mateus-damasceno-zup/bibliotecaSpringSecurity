package com.catalisa.darksidebooks.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_LIVROS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String autor;

    @Column(length = 15, nullable = false)
    private String dataLancamento;

    @Column(length = 30, nullable = false)
    private String codigoLivro;

}