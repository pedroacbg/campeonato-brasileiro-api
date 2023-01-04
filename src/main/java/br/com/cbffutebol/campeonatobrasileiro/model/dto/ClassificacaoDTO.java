package br.com.cbffutebol.campeonatobrasileiro.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassificacaoDTO {

    private List<ClassificacaoTimeDTO> times = new ArrayList<>();
}
