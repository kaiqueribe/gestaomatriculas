package com.imsjt.gestaomatriculas.repository;

import com.imsjt.gestaomatriculas.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}