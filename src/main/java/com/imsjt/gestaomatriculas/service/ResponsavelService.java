package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.entity.Responsavel;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.repository.ResponsavelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ResponsavelService {

    private ResponsavelRepository responsavelRepository;

    public Responsavel cadastrarResponsavel(Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }

    public List<Responsavel> listarTodosResponsaveis() {
        List<Responsavel> responsavelList = responsavelRepository.findAll();
        return responsavelList.stream().toList();
    }

    public Responsavel buscarPorId(Long id) {
        Responsavel responsavel = responsavelRepository.findById(id).orElseThrow(() -> new NotFoundException(" Responsável com o id: " + id + " não encontrado! "));
        return responsavel;
    }

    public Responsavel atualizarResponsavel(Long id, Responsavel responsavel) {
        Responsavel responsavelAtualizado = responsavelRepository.findById(id).orElseThrow(() -> new NotFoundException(" Responsável com o id: " + id + " não encontrado! "));
        responsavelAtualizado.setNomeCompleto(responsavel.getNomeCompleto());
        responsavelAtualizado.setCpf(responsavel.getCpf());
        responsavelAtualizado.setEmail(responsavel.getEmail());
        responsavelAtualizado.setTelefones(responsavel.getTelefones());
        responsavelAtualizado.setEndereco(responsavel.getEndereco());
        return responsavelRepository.save(responsavelAtualizado);
    }

    public String removerResponsavel(Long id) {
        Responsavel responsavel = responsavelRepository.findById(id).orElseThrow(() -> new NotFoundException(" Responsável com o id: " + id + " não encontrado! "));
        responsavelRepository.delete(responsavel);
        return "Responsável removido com sucesso!";
    }


}
