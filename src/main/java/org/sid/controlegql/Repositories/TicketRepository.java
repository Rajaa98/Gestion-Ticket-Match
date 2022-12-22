package org.sid.controlegql.Repositories;

import org.sid.controlegql.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    public Integer countTicketByMatch_Id(  Long id);
}
