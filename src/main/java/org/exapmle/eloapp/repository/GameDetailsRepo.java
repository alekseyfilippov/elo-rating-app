package org.exapmle.eloapp.repository;

import org.exapmle.eloapp.domain.GameDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameDetailsRepo extends JpaRepository {
    List<GameDetails> findAll();
}
