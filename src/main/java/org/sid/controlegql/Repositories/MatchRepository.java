package org.sid.controlegql.Repositories;

import org.sid.controlegql.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
