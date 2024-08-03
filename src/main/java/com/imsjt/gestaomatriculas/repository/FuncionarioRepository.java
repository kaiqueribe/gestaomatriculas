package com.imsjt.gestaomatriculas.repository;

import com.imsjt.gestaomatriculas.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
}
