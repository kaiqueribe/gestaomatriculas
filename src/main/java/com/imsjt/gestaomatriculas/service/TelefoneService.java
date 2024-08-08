package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.entity.Telefone;

import com.imsjt.gestaomatriculas.exceptions.InvalidRequestException;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.repository.TelefoneRepository;


import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class TelefoneService {

    private TelefoneRepository telefoneRepository;


    public Telefone cadastrarTelefone(Telefone telefone) {

        telefoneRepository.findByNumeroTelefone(telefone.getNumeroTelefone())
                .ifPresent(numeroTelefone -> {
                    throw new InvalidRequestException("Telefone Já Cadastrado!" + telefone.getNumeroTelefone());
                });

        var novoTelefone = telefoneRepository.save(telefone);
        return novoTelefone;

    }

    public List<Telefone> listarTodosTelefones() {
        List<Telefone> telefones = telefoneRepository.findAll();
        return telefones.stream().toList();
    }

    public Telefone buscarTelefonePorId(Long id) {
        Telefone telefone = telefoneRepository.findById(id).orElseThrow(() -> new NotFoundException(" Telefone com id:" + id + " não encontrado!"));

        return telefone;
    }

    public Telefone atualizarTelefone(Long id, Telefone telefone) {
        Telefone telefoneAtualizado = telefoneRepository.findById(id).orElseThrow(() -> new NotFoundException("Telefone com id: " + id + " não encontrado!"));
        telefoneAtualizado.setNumeroTelefone(telefone.getNumeroTelefone());
        telefoneAtualizado.setCategoriaTelefone(telefone.getCategoriaTelefone());

        return telefoneRepository.save(telefoneAtualizado);
    }

    public String removerTelefone(Long id) {
        Telefone telefone = telefoneRepository.findById(id).orElseThrow(() -> new NotFoundException("Atendido com id:  " + id + " não encontrado!"));
        telefoneRepository.delete(telefone);
        return "Telefone removido com sucesso!";
    }

}
