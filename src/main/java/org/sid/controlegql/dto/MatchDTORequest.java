package org.sid.controlegql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTORequest {
    String ReferenceMatch;
    String dateMatch;
    String Lieu;
    String Equipe1;
    String Equipe2;
}
