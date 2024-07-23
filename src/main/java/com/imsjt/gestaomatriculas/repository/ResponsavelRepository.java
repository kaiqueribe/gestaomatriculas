package com.imsjt.gestaomatriculas.repository;

import com.imsjt.gestaomatriculas.entity.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel,Long> {

}
