package br.com.cbffutebol.campeonatobrasileiro.repository;

import br.com.cbffutebol.campeonatobrasileiro.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.cbffutebol.campeonatobrasileiro.model.Time;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

    List<Jogo> findByTime1AndEncerrado(Time time1, Boolean Encerrado);
    List<Jogo> findByTime2AndEncerrado(Time time2, Boolean Encerrado);

}
