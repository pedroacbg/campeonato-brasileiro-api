package br.com.cbffutebol.campeonatobrasileiro.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Time implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String nome;

    @Column(length = 4)
    private String sigla;

    @Column(length = 2)
    private String uf;


}
