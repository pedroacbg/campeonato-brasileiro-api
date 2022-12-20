package br.com.cbffutebol.campeonatobrasileiro.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Jogo implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer golsTime1;
    private Integer golsTime2;
    private Integer publicoPagante;

    @ManyToOne
    @JoinColumn(name = "time1")
    private Time time1;

    @ManyToOne
    @JoinColumn(name = "time2")
    private Time time2;

}
