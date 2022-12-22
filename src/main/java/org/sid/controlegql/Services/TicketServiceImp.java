package org.sid.controlegql.Services;

import org.sid.controlegql.Repositories.MatchRepository;
import org.sid.controlegql.Repositories.TicketRepository;
import org.sid.controlegql.dto.MatchDTORequest;
import org.sid.controlegql.dto.TicketDTORequest;
import org.sid.controlegql.dto.TicketDTOResponse;
import org.sid.controlegql.entities.Match;
import org.sid.controlegql.entities.Ticket;
import org.sid.controlegql.mappers.Ticketmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class TicketServiceImp implements TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    Ticketmapper ticketmapper;
    @Autowired
    MatchRepository matchRepository;
    @Override
    public TicketDTOResponse ajouterTicket(TicketDTORequest ticketDTORequest) {
        System.out.println("into AJOUT");
        Match match = matchRepository.findById(ticketDTORequest.getMatchId()).orElse(null);
        Integer totalticketByMatch  = ticketRepository.countTicketByMatch_Id(match.getId());
        if( totalticketByMatch > 10) {
            throw new RuntimeException(" vous avez depassez le nombre de ticket par macth !");
        }
        Ticket ticket = new Ticket();
        ticket.setPrix(ticketDTORequest.getPrix());
        ticket.setReference(ticketDTORequest.getReference());
        ticket.setStatut(Boolean.FALSE);
        ticket.setMatch(match);
        Ticket ticketsaved = ticketRepository.save(ticket);
        System.out.println(ticketsaved.getPrix());
        return ticketmapper.fromTicket(ticketsaved);

    }

    @Override
    public TicketDTOResponse editTicket(Long id,TicketDTORequest ticketDTORequest) {
        System.out.println("bien modifier");
        Ticket ticketbyid= ticketRepository.findById(id).get();
        System.out.println(ticketbyid);
        if(ticketbyid != null)
        {   ticketbyid.setPrix(ticketDTORequest.getPrix());
            ticketbyid.setReference(ticketDTORequest.getReference());
            ticketbyid.setStatut(Boolean.TRUE);
        }

        return ticketmapper.fromTicket(ticketbyid);
    }
    @Override
    public Match ajoutermatch(MatchDTORequest match){
        Match match1=new Match();
        match1.setDateMatch(new Date());
        match1.setReferenceMatch(match.getReferenceMatch());
        match1 .setEquipe1(match1.getEquipe1());
        match1.setEquipe2(match.getEquipe2());
        match1.setLieu(match.getLieu());
        matchRepository.save(match1);
        return match1;
    }
}
