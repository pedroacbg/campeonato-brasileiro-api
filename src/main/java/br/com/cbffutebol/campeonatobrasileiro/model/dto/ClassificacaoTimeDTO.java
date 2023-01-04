package br.com.cbffutebol.campeonatobrasileiro.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassificacaoTimeDTO implements Comparable<ClassificacaoTimeDTO>{

    private String time;
    private Long idTime;
    private Integer posicao;
    private Integer pontos;
    private Integer jogos;
    private Integer vitorias;
    private Integer empates;
    private Integer derrotas;
    private Integer golsMarcados;
    private Integer golsSofridos;

    @Override
    public int compareTo(ClassificacaoTimeDTO o) {
        return this.getPontos().compareTo(o.getPontos());
    }
}
