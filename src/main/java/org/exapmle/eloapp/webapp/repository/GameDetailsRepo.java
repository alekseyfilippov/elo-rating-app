package org.exapmle.eloapp.webapp.repository;

import org.exapmle.eloapp.webapp.domain.GameDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameDetailsRepo extends CrudRepository<GameDetails, Long> {
    List<GameDetails> findAll();
}
