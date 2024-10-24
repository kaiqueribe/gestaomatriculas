package com.imsjt.gestaomatriculas.repository;

import com.imsjt.gestaomatriculas.entity.Atendido;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtendidoRepository extends JpaRepository<Atendido, Long> {
    Optional<Atendido> findByCpf(String cpf);
    Optional<Atendido> findByNumeroMatricula(String matricula);
}
