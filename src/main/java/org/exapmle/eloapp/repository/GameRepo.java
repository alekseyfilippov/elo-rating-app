package org.exapmle.eloapp.repository;

import org.exapmle.eloapp.domain.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepo extends CrudRepository<Game, Long> {
}
