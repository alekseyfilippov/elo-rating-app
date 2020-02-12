package org.exapmle.eloapp.repository;

import org.exapmle.eloapp.domain.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepo extends CrudRepository<Player, Long> {
}
