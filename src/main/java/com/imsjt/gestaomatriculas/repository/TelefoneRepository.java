package com.imsjt.gestaomatriculas.repository;

import com.imsjt.gestaomatriculas.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone,Long> {
    Optional<Telefone> findByNumeroTelefone(String numeroTelefone);
}
