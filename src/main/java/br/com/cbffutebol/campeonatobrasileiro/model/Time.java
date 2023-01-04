package br.com.cbffutebol.campeonatobrasileiro.model;

import br.com.cbffutebol.campeonatobrasileiro.model.dto.TimeDTO;
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

    private String estadio;

    public Time(Time entity){
        this.id = entity.id;
        this.nome = entity.nome;
        this.sigla = entity.sigla;
        this.uf = entity.uf;
        this.estadio = entity.estadio;
    }

    public Time(TimeDTO entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.sigla = entity.getSigla();
        this.uf = entity.getUf();
        this.estadio = entity.getEstadio();
    }


}
