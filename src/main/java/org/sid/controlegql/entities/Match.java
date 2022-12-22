package org.sid.controlegql.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor @Builder
public class Match {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(length =50, nullable=false ,unique = true)
    private String ReferenceMatch;
    @Temporal(TemporalType.DATE)
    private Date dateMatch;
    @Column(length =50, nullable=false)
    private String Lieu;
    @Column(length =50, nullable=false)
    private String Equipe1;
    @Column(length =50, nullable=false)
    private String Equipe2;
    @OneToMany
    private List<Ticket> Tickets;

}
