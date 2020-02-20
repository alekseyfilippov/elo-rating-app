package org.exapmle.eloapp.repository;

import org.exapmle.eloapp.domain.GameDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameDetailsRepo extends JpaRepository<GameDetails, Long> {
    List<GameDetails> findAll();
}
