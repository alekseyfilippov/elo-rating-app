package org.exapmle.eloapp.webapp.repository;

import org.exapmle.eloapp.webapp.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GameRepo extends CrudRepository<Game, Long> {
    List<Game> findAll();

    List<Game> findByGameTimeAfter(Date date);
}
