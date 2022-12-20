package br.com.cbffutebol.campeonatobrasileiro.repository;

import br.com.cbffutebol.campeonatobrasileiro.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
}
