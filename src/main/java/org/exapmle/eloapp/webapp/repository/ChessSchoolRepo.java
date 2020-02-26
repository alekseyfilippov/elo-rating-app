package org.exapmle.eloapp.webapp.repository;

import org.exapmle.eloapp.webapp.domain.ChessSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChessSchoolRepo extends CrudRepository<ChessSchool, Long> {

    Optional<ChessSchool> findByName(String name);
    Optional<ChessSchool> findById(int id);
}
