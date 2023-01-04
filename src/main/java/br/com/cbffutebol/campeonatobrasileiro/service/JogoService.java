package br.com.cbffutebol.campeonatobrasileiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cbffutebol.campeonatobrasileiro.repository.JogoRepository;
import br.com.cbffutebol.campeonatobrasileiro.repository.TimeRepository;
import br.com.cbffutebol.campeonatobrasileiro.model.Time;
import br.com.cbffutebol.campeonatobrasileiro.model.Jogo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private TimeService timeService;

    public void gerarJogos(LocalDateTime primeiraRodada){
        final List<Time> times = timeService.findAll();
        List<Time> all1 = new ArrayList<>();
        List<Time> all2 = new ArrayList<>();
        all1.addAll(times);
        all2.addAll(times);

        jogoRepository.deleteAll();

        List<Jogo> jogos = new ArrayList<>();

        int t = times.size();
        int m = times.size() / 2;
        LocalDateTime dataJogo = primeiraRodada;
        Integer rodada = 0;

        for(int i = 0; i < t - 1; i++){
            rodada = i + 1;
            for(int j = 0; j < m; j++){
                //Teste para ajustar o mando de campo
                Time time1;
                Time time2;
                if(j % 2 == 1 || i % 2 == 1 && j == 0){
                    time1 = times.get(t - j - 1);
                    time2 = times.get(j);
                }else{
                    time1 = times.get(j);
                    time2 = times.get(t - j - 1);
                }
                if(time1 == null){
                    System.out.println("Time 1 null");
                }
                jogos.add(gerarJogo(dataJogo, rodada, time1, time2));
                dataJogo = dataJogo.plusDays(7);
            }
            //Gira os times no sentido horário, mantendo o primeiro no lugar
            times.add(1, times.remove(times.size() - 1));
        }
        jogos.forEach(jogo -> System.out.println(jogo));
        jogoRepository.saveAll(jogos);
        List<Jogo> jogos2 = new ArrayList<>();
        jogos.forEach(jogo -> {
            Time time1 = jogo.getTime2();
            Time time2 = jogo.getTime1();
            jogos2.add(gerarJogo(jogo.getData().plusDays(7 * jogos.size()), jogo.getRodada() + jogos.size(), time1, time2));
        });
        jogoRepository.saveAll(jogos2);
    }

    private Jogo gerarJogo(LocalDateTime dataJogo, Integer rodada, Time time1, Time time2) {
        Jogo jogo = new Jogo();
        jogo.setTime1(time1);
        jogo.setTime2(time2);
        jogo.setRodada(rodada);
        jogo.setData(dataJogo);
        jogo.setEncerrado(false);
        jogo.setGolsTime1(0);
        jogo.setGolsTime2(0);
        jogo.setPublicoPagante(0);
        return jogo;
    }

    public List<Jogo> findAll(){
        return jogoRepository.findAll();
    }

}
