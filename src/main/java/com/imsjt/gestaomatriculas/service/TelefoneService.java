package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.entity.Telefone;

import com.imsjt.gestaomatriculas.repository.TelefoneRepository;
import com.sun.jdi.request.InvalidRequestStateException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneService {

    private TelefoneRepository telefoneRepository;

    //TODO: Implementar TelefoneService

    public Telefone cadastrarTelefone(Telefone telefone) {
        telefoneRepository.findByNumeroTelefone(telefone.getNumeroTelefone()).ifPresent(numeroTelefone -> {
            throw new InvalidRequestStateException("Telefone Já Cadastrado!"+ telefone.getNumeroTelefone());
        });
        Telefone novoTelefone = telefoneRepository.save(telefone);
        return telefone;
    }

    public List<Telefone> listarTodosTelefones() {
        return null;
    }

    public Telefone buscarTelefonePorId(Long id) {
        return null;
    }

    public Telefone atualizarTelefone(Long id, Telefone telefone) {
        return null;
    }

    public void deletarTelefone(Long id) {

    }

}
