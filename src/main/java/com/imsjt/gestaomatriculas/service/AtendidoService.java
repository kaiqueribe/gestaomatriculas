package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.dto.AtendidoDTO;
import com.imsjt.gestaomatriculas.entity.Atendido;
import com.imsjt.gestaomatriculas.exceptions.InvalidRequestException;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.mapper.AtendidoMapper;
import com.imsjt.gestaomatriculas.repository.AtendidoRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

//TODO:criar DTOS e verificar metodo Post e Put com DTO implementado
//TODO: Criar Enum Sexo e Fazer idade ser calculada a partir da data de nascimento


@Service
@AllArgsConstructor
public class AtendidoService {

    //TODO Tratar Exceptions

    private AtendidoRepository atendidoRepository;
    private final AtendidoMapper atendidoMapper;

    public AtendidoDTO cadastrarAtendido(AtendidoDTO atendidoDTO) {
        Atendido atendido = atendidoMapper.toEntity(atendidoDTO);
        atendidoRepository.findByCpf(atendido.getCpf()).ifPresent(atendidoCpf -> {
            throw new InvalidRequestException("CPF já Cadastrado! " + atendido.getCpf());
        });
        Atendido novoAtendido = atendidoRepository.save(atendido);
        return atendidoMapper.toDTO(atendido);

    }

    public List<AtendidoDTO> listarTodosAtendidos() {
        List<Atendido> atendidos = atendidoRepository.findAll();
        return atendidos.stream().map(atendidoMapper::toDTO).toList();
    }

    public AtendidoDTO buscarAtendidoPorId(Long id) {
        Atendido atendido = atendidoRepository.findById(id).orElseThrow(() -> new NotFoundException("Atendido com id: " + id + " não encontrado!"));
        return atendidoMapper.toDTO(atendido);
    }

    public AtendidoDTO atualizarAtendido(Long id, AtendidoDTO atendidoDTO) {
        Atendido atendido = atendidoMapper.toEntity(atendidoDTO);
        Atendido atendidoAtualizado = atendidoRepository.findById(id).orElseThrow(() -> new NotFoundException("Atendido com id: " + id + " não encontrado!"));
        atendidoAtualizado.setNomeCompleto(atendido.getNomeCompleto());
        atendidoAtualizado.setRg(atendido.getRg());
        atendidoAtualizado.setCpf(atendido.getCpf());
        atendidoAtualizado.setDataNascimento(atendido.getDataNascimento());
        atendidoAtualizado.setMunicipioNascimento(atendido.getMunicipioNascimento());
        atendidoAtualizado.setIdade(atendido.getIdade());
        atendidoAtualizado.setSexo(atendido.getSexo());
        atendidoRepository.save(atendidoAtualizado);
        return atendidoMapper.toDTO(atendidoAtualizado);
    }

    public void deletarAtendido(Long id) {
        Atendido atendido = atendidoRepository.findById(id).orElseThrow(() -> new NotFoundException("Atendido com id: " + id + " não encontrado!"));
        atendidoRepository.delete(atendido);

    }


}
