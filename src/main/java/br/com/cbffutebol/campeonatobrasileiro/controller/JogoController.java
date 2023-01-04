package br.com.cbffutebol.campeonatobrasileiro.controller;

import br.com.cbffutebol.campeonatobrasileiro.model.dto.ClassificacaoDTO;
import br.com.cbffutebol.campeonatobrasileiro.model.dto.JogoDTO;
import br.com.cbffutebol.campeonatobrasileiro.model.dto.JogoFinalizadoDTO;
import br.com.cbffutebol.campeonatobrasileiro.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import br.com.cbffutebol.campeonatobrasileiro.model.Jogo;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/jogo")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public ResponseEntity<List<JogoDTO>> findAll(){
        return ResponseEntity.ok().body(jogoService.findAll());
    }

    @PostMapping(value = "/gerar")
    public ResponseEntity<Void> gerarJogos(){
        jogoService.gerarJogos(LocalDateTime.now());
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/finalizar/{id}")
    public ResponseEntity<JogoDTO> finalizar(@PathVariable Long id, @RequestBody JogoFinalizadoDTO jogoDTO) throws Exception {
        return ResponseEntity.ok().body(jogoService.finalizar(id, jogoDTO));
    }

    @GetMapping(value = "/classificacao")
    public ResponseEntity<ClassificacaoDTO> classificacao(){
        return ResponseEntity.ok().body(jogoService.getClassificacao());
    }

    @GetMapping(value = "/jogo/{id}")
    public ResponseEntity<JogoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(jogoService.findById(id));
    }
}
