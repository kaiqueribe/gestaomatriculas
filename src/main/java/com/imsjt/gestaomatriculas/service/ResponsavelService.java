package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.dto.ResponsavelDTO;
import com.imsjt.gestaomatriculas.entity.Atendido;
import com.imsjt.gestaomatriculas.entity.Responsavel;
import com.imsjt.gestaomatriculas.exceptions.InvalidRequestException;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.mapper.ResponsavelMapper;
import com.imsjt.gestaomatriculas.repository.ResponsavelRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ResponsavelService {

    private ResponsavelRepository responsavelRepository;
    private final ResponsavelMapper responsavelMapper;

    @Transactional
    public ResponsavelDTO cadastrarResponsavel(ResponsavelDTO responsavelDTO, Atendido atendido) {
        Responsavel responsavel = responsavelMapper.toEntity(responsavelDTO);
        responsavelRepository.findByCpf(responsavel.getCpf()).ifPresent(responsavelCpf -> {
            throw new RuntimeException("CPF já Cadastrado!" + responsavel.getCpf());
        });
        responsavel.setAtendido(atendido);
        Responsavel novoResponsavel = responsavelRepository.save(responsavel);
        return responsavelMapper.toDTO(novoResponsavel);
    }

    public List<ResponsavelDTO> listarTodosResponsaveis() {
        List<Responsavel> responsavelList = responsavelRepository.findAll();
        return responsavelList.stream().map(responsavelMapper::toDTO).toList();
    }

    public ResponsavelDTO buscarPorId(Long id) {
        Responsavel responsavel = responsavelRepository.findById(id).orElseThrow(() -> new NotFoundException(" Responsável com o id: " + id + " não encontrado! "));
        return responsavelMapper.toDTO(responsavel);
    }

    public ResponsavelDTO atualizarResponsavel(Long id, ResponsavelDTO responsavelDTO) {
        Responsavel responsavel = responsavelMapper.toEntity(responsavelDTO);
        Responsavel responsavelAtualizado = responsavelRepository.findById(id).orElseThrow(() -> new NotFoundException(" Responsável com o id: " + id + " não encontrado! "));
        responsavelAtualizado.setNomeCompleto(responsavel.getNomeCompleto());
        responsavelAtualizado.setCpf(responsavel.getCpf());
        responsavelAtualizado.setEmail(responsavel.getEmail());
        responsavelRepository.save(responsavelAtualizado);
        return responsavelMapper.toDTO(responsavelAtualizado);
    }

    public String removerResponsavel(Long id) {
        Responsavel responsavel = responsavelRepository.findById(id).orElseThrow(() -> new NotFoundException(" Responsável com o id: " + id + " não encontrado! "));
        responsavelRepository.delete(responsavel);
        return "Responsável removido com sucesso!";
    }


}
