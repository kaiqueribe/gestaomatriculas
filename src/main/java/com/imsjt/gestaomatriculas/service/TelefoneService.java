package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.dto.TelefoneDTO;
import com.imsjt.gestaomatriculas.entity.Telefone;

import com.imsjt.gestaomatriculas.exceptions.InvalidRequestException;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.mapper.TelefoneMapper;
import com.imsjt.gestaomatriculas.repository.AtendidoRepository;
import com.imsjt.gestaomatriculas.repository.TelefoneRepository;


import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class TelefoneService {

//atendidorepository vai ser utilizado na implementação do atrelamento telefone ao atendido
    private AtendidoRepository atendidoRepository;
    private TelefoneRepository telefoneRepository;
    private final TelefoneMapper telefoneMapper;


    //TODO implementar logica que atrela telefone a Atendido

    public TelefoneDTO cadastrarTelefone(TelefoneDTO telefoneDTO) {
        Telefone telefone = telefoneMapper.toEntity(telefoneDTO);

        telefoneRepository.findByNumeroTelefone(telefone.getNumeroTelefone())
                .ifPresent(numeroTelefone -> {
                    throw new InvalidRequestException("Telefone Já Cadastrado! " + telefone.getNumeroTelefone());
                });

        Telefone novoTelefone = telefoneRepository.save(telefone);
        return telefoneMapper.toDTO(novoTelefone);

    }

    public List<TelefoneDTO> listarTodosTelefones() {
        List<Telefone> telefones = telefoneRepository.findAll();
        return telefones.stream().map(telefoneMapper::toDTO).toList();
    }

    public TelefoneDTO buscarTelefonePorId(Long id) {
        Telefone telefone = telefoneRepository.findById(id).orElseThrow(() -> new NotFoundException(" Telefone com id: " + id + " não encontrado!"));

        return telefoneMapper.toDTO(telefone);
    }

    public TelefoneDTO atualizarTelefone(Long id, TelefoneDTO telefoneDTO) {
        Telefone telefone = telefoneMapper.toEntity(telefoneDTO);
        Telefone telefoneAtualizado = telefoneRepository.findById(id).orElseThrow(() -> new NotFoundException("Telefone com id: " + id + " não encontrado!"));
        telefoneAtualizado.setTituloTelefone(telefone.getTituloTelefone());
        telefoneAtualizado.setNumeroTelefone(telefone.getNumeroTelefone());
        telefoneAtualizado.setTipoTelefone(telefone.getTipoTelefone());
        telefoneRepository.save(telefoneAtualizado);
        return telefoneMapper.toDTO(telefoneAtualizado);
    }

    public String removerTelefone(Long id) {
        Telefone telefone = telefoneRepository.findById(id).orElseThrow(() -> new NotFoundException("Atendido com id:  " + id + " não encontrado!"));
        telefoneRepository.delete(telefone);
        return "Telefone removido com sucesso!";
    }

}
