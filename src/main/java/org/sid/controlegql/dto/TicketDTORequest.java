package org.sid.controlegql.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.controlegql.entities.Match;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTORequest {

    private String Reference;
    private Double prix;
    private boolean Statut;
    private Long matchId;
    ;
}
