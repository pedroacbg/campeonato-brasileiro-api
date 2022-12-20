package br.com.cbffutebol.campeonatobrasileiro.repository;

import br.com.cbffutebol.campeonatobrasileiro.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

}
