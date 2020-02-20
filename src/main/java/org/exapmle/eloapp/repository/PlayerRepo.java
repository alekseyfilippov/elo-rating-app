package org.exapmle.eloapp.repository;

import org.exapmle.eloapp.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {
    List<Player> findAll();
    Optional<Player> findById(int id);
}
