package br.com.cbffutebol.campeonatobrasileiro.service;

import br.com.cbffutebol.campeonatobrasileiro.model.dto.TimeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cbffutebol.campeonatobrasileiro.model.Time;
import br.com.cbffutebol.campeonatobrasileiro.repository.TimeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repository;

    public List<Time> findAll(){
        return repository.findAll();
    }

    public TimeDTO register(TimeDTO time){
        Time entity = toEntity(time);
        repository.save(entity);
        return new TimeDTO(entity);
    }

    public List<TimeDTO> findAllDTO(){
        return repository.findAll().stream().map(x ->
            new TimeDTO(x)).collect(Collectors.toList());
    }

    public TimeDTO findOne(Long id){
        return new TimeDTO(repository.findById(id).get());
    }

    private Time toEntity(TimeDTO dto){
        Time time = new Time();
        time.setId(dto.getId());
        time.setNome(dto.getNome());
        time.setSigla(dto.getSigla());
        time.setUf(dto.getUf());
        time.setEstadio(dto.getEstadio());
        return time;
    }

}
