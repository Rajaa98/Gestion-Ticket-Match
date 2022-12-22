package org.sid.controlegql.mappers;


import org.sid.controlegql.dto.TicketDTOResponse;
import org.sid.controlegql.entities.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class Ticketmapper {

    public TicketDTOResponse fromTicket(Ticket ticket){
        TicketDTOResponse ticketDTOResponse=new TicketDTOResponse();
        BeanUtils.copyProperties(ticket,ticketDTOResponse);
        return ticketDTOResponse;
    }
}
