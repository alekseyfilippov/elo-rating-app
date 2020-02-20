package org.exapmle.eloapp.repository;

import org.exapmle.eloapp.domain.ChessSchool;
import org.exapmle.eloapp.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChessSchoolRepo extends JpaRepository<ChessSchool, Long> {
    Optional<ChessSchool> findByName(String name);
    Optional<ChessSchool> findById(Long id);
}
