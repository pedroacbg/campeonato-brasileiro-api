package br.com.cbffutebol.campeonatobrasileiro.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogoFinalizadoDTO {

    private Integer golsTime1;
    private Integer golsTime2;
    private Integer publicoPagante;
}
