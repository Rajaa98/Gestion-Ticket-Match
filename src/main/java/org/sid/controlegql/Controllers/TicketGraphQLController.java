package org.sid.controlegql.Controllers;

import org.sid.controlegql.Repositories.MatchRepository;
import org.sid.controlegql.Repositories.TicketRepository;
import org.sid.controlegql.Services.TicketService;
import org.sid.controlegql.dto.MatchDTORequest;
import org.sid.controlegql.dto.TicketDTORequest;
import org.sid.controlegql.dto.TicketDTOResponse;
import org.sid.controlegql.entities.Match;
import org.sid.controlegql.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketGraphQLController {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
   private MatchRepository matchRepository;
    @Autowired
    private TicketService ticketService;
    @QueryMapping
    private List<Ticket> Tickets(){
        return ticketRepository.findAll();
    }

    @MutationMapping
    private TicketDTOResponse addticket( @Argument TicketDTORequest ticketDTORequest){
        System.out.println("controller");
        return ticketService.ajouterTicket(ticketDTORequest);
}
    @MutationMapping
    public TicketDTOResponse editTicket(Long id,TicketDTORequest ticketDTORequest) {
        return ticketService.editTicket(id,ticketDTORequest);

    }
   @QueryMapping
    public List<Match> matchs(){
        return matchRepository.findAll();
}
    @MutationMapping
    private Match addmatch( @Argument MatchDTORequest match){
        return ticketService.ajoutermatch(match);
    }
}
