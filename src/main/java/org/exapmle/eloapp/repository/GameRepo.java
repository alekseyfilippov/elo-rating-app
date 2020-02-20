package org.exapmle.eloapp.repository;

import org.exapmle.eloapp.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface GameRepo extends JpaRepository<Game, Long> {
    List<Game> findAll();

    List<Game> findByGameTimeAfter(Date date);
}
