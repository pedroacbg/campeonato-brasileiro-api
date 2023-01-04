package br.com.cbffutebol.campeonatobrasileiro.controller;

import br.com.cbffutebol.campeonatobrasileiro.model.dto.TimeDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.cbffutebol.campeonatobrasileiro.model.Time;
import org.springframework.http.ResponseEntity;
import br.com.cbffutebol.campeonatobrasileiro.service.TimeService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/time")
public class TimeController {

    @Autowired
    private TimeService service;

    @GetMapping
    public ResponseEntity<List<TimeDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Obtém os dados de um time")
    public ResponseEntity<TimeDTO> findOne(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findOne(id));
    }

    @PostMapping
    public ResponseEntity<TimeDTO> register(@RequestBody TimeDTO time){
        TimeDTO newEntity = service.register(time);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(newEntity);
    }

}
