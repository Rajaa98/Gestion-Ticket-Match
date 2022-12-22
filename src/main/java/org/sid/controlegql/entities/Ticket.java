package org.sid.controlegql.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor @Builder
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(length =16, nullable=false,unique=true)
    private String Reference;
    private Double prix;
    @Column(nullable = true)
    private boolean Statut;
    @ManyToOne
    private Match match;

}
