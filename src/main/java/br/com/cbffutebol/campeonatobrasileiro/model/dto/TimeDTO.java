package br.com.cbffutebol.campeonatobrasileiro.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import br.com.cbffutebol.campeonatobrasileiro.model.Time;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeDTO {

    private Long id;
    private String nome;
    private String sigla;
    private String uf;
    private String estadio;

    public TimeDTO(Time entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.sigla = entity.getSigla();
        this.uf = entity.getUf();
        this.estadio = entity.getEstadio();
    }

}
