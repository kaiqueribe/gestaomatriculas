package com.imsjt.gestaomatriculas.repository;

import com.imsjt.gestaomatriculas.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MatriculaRepository extends JpaRepository<Matricula,Long> {
    Optional<Matricula> findByAtendidoCpf(String cpf);
}
