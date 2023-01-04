package br.com.cbffutebol.campeonatobrasileiro.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import br.com.cbffutebol.campeonatobrasileiro.model.Jogo;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogoDTO {

    private Long id;
    private LocalDateTime data;
    private Integer golsTime1;
    private Integer golsTime2;
    private Integer publicoPagante;
    private Boolean encerrado;
    private Integer rodada;
    private TimeDTO time1;
    private TimeDTO time2;

    public JogoDTO(Jogo entity){
        this.id = entity.getId();
        this.data = entity.getData();
        this.golsTime1 = entity.getGolsTime1();
        this.golsTime2 = entity.getGolsTime2();
        this.publicoPagante = entity.getPublicoPagante();
        this.encerrado = entity.getEncerrado();
        this.rodada = entity.getRodada();
        this.time1 = new TimeDTO(entity.getTime1());
        this.time2 = new TimeDTO(entity.getTime2());
    }

}
