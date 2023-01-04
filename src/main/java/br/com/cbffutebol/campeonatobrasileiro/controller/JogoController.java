package br.com.cbffutebol.campeonatobrasileiro.controller;

import br.com.cbffutebol.campeonatobrasileiro.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<List<Jogo>> findAll(){
        return ResponseEntity.ok().body(jogoService.findAll());
    }

    @PostMapping(value = "/gerar")
    public ResponseEntity<Void> gerarJogos(){
        jogoService.gerarJogos(LocalDateTime.now());
        return ResponseEntity.ok().build();
    }

}
