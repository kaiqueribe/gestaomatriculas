package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.entity.Telefone;

import com.imsjt.gestaomatriculas.exceptions.InvalidRequestException;
import com.imsjt.gestaomatriculas.repository.TelefoneRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TelefoneService {

    private TelefoneRepository telefoneRepository;

    //TODO: Implementar TelefoneService
    public Telefone cadastrarTelefone(Telefone telefone) {

        telefoneRepository.findByNumeroTelefone(telefone.getNumeroTelefone())
                .ifPresent(numeroTelefone -> {
            throw new InvalidRequestException("Telefone Já Cadastrado!"+ telefone.getNumeroTelefone());
        });

        var novoTelefone = telefoneRepository.save(telefone);
        return novoTelefone;

    }

//    public List<Telefone> listarTodosTelefones() {
//        return null;
//    }
//
//    public Telefone buscarTelefonePorId(Long id) {
//        return null;
//    }
//
//    public Telefone atualizarTelefone(Long id, Telefone telefone) {
//        return null;
//    }
//
//    public void deletarTelefone(Long id) {
//
//    }

}
