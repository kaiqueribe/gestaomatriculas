package com.imsjt.gestaomatriculas.repository;

import com.imsjt.gestaomatriculas.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula,Long> {
}
