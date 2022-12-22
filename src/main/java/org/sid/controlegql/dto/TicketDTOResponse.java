package org.sid.controlegql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.controlegql.entities.Match;
@Data
@AllArgsConstructor
@NoArgsConstructor @Builder
public class TicketDTOResponse {

    private String Reference;
    private Double prix;
    private boolean Statut;
      private Match match;
}
