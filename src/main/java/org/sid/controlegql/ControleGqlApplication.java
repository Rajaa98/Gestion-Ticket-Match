package org.sid.controlegql;

import org.sid.controlegql.Repositories.MatchRepository;
import org.sid.controlegql.Repositories.TicketRepository;
import org.sid.controlegql.entities.Match;
import org.sid.controlegql.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ControleGqlApplication implements CommandLineRunner {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    MatchRepository matchRepository;

    public static void main(String[] args) {
        SpringApplication.run(ControleGqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for(long i=1; i<7; i++){
            Match match = Match.builder()
                    .Id(i)
                    .dateMatch(new Date())
                    .ReferenceMatch("111000"+i)
                    .Equipe1("Equipe"+i)
                    .Equipe2("Equipe"+(i+1))
                    .Lieu("Train"+1)
                    .build();
            matchRepository.save(match);
        }
          matchRepository.findAll().forEach(match -> {
              for(long i=1; i<=10; i++) {
                  Ticket ticket = Ticket.builder()
                          .Id(i)
                          .prix(3.00+ Math.random()*7)
                          .Statut((i%2 == 0) ? Boolean.FALSE : Boolean.TRUE)
                          .Reference("111000"+i)
                          .match(match)
                          .build();
            ticketRepository.save(ticket);

              } });
    }
}
