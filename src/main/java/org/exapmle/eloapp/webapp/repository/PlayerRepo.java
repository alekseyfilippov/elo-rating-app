package org.exapmle.eloapp.webapp.repository;

import org.exapmle.eloapp.webapp.domain.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepo extends CrudRepository<Player, Long> {
    List<Player> findAll();
    Optional<Player> findById(int id);
}
