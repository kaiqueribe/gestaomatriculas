package com.imsjt.gestaomatriculas.repository;

import com.imsjt.gestaomatriculas.entity.DadosEscolares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DadosEscolaresRepository extends JpaRepository<DadosEscolares, Long> {
//    Optional<DadosEscolares> findAllById(Long id);
}
