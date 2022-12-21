package br.com.cbffutebol.campeonatobrasileiro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public Time(Time entity){
        this.id = entity.id;
        this.nome = entity.nome;
        this.sigla = entity.sigla;
        this.uf = entity.uf;
    }


}
