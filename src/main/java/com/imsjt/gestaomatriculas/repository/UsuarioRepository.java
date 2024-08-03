package com.imsjt.gestaomatriculas.repository;

import com.imsjt.gestaomatriculas.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
