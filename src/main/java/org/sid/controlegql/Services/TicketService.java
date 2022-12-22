package org.sid.controlegql.Services;

import org.sid.controlegql.dto.MatchDTORequest;
import org.sid.controlegql.dto.TicketDTORequest;
import org.sid.controlegql.dto.TicketDTOResponse;
import org.sid.controlegql.entities.Match;

public interface TicketService {
     TicketDTOResponse ajouterTicket(TicketDTORequest ticketDTORequest);
     TicketDTOResponse editTicket(Long id,TicketDTORequest ticketDTORequest);
     Match ajoutermatch(MatchDTORequest match);
}
