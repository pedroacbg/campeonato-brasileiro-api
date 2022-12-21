package br.com.cbffutebol.campeonatobrasileiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cbffutebol.campeonatobrasileiro.model.Time;
import br.com.cbffutebol.campeonatobrasileiro.repository.TimeRepository;

import java.util.List;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repository;

    public Time register(Time time){
        Time entity = new Time();
        entity = repository.save(time);
        return new Time(entity);
    }

    public List<Time> findAll(){
        return repository.findAll();
    }

    public Time findOne(Long id){
        return repository.findById(id).get();
    }

}
