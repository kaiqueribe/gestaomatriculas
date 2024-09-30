package com.imsjt.gestaomatriculas.service;


import com.imsjt.gestaomatriculas.dto.EnderecoDTO;
import com.imsjt.gestaomatriculas.entity.Endereco;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.mapper.EnderecoMapper;
import com.imsjt.gestaomatriculas.repository.EnderecoRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnderecoService {

    private EnderecoRepository enderecoRepository;
    private final EnderecoMapper enderecoMapper;

    public EnderecoDTO cadastrarEndereco(EnderecoDTO enderecoDTO) {

        Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
        Endereco novoEndereco = enderecoRepository.save(endereco);

        return enderecoMapper.toDTO(novoEndereco);
    }

    public List<EnderecoDTO> listarTodosEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos.stream().map(enderecoMapper::toDTO).toList();
    }

    public EnderecoDTO buscarEnderecoPorId(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> new NotFoundException("Endereco com id: " + id + " não encontrado!"));
        return enderecoMapper.toDTO(endereco);
    }

    public EnderecoDTO atualizarEndereco(Long id, EnderecoDTO enderecoDTO) {
        Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
        Endereco enderecoAtualizado = enderecoRepository.findById(id).orElseThrow(() -> new NotFoundException("Endereco com id: " + id + " não encontrado!"));
        enderecoAtualizado.setRua(endereco.getRua());
        enderecoAtualizado.setNumero(endereco.getNumero());
        enderecoAtualizado.setComplemento(endereco.getComplemento());
        enderecoAtualizado.setBairro(endereco.getBairro());
        enderecoAtualizado.setCidade(endereco.getCidade());
        enderecoAtualizado.setEstado(endereco.getEstado());
        enderecoAtualizado.setCep(endereco.getCep());
        enderecoRepository.save(enderecoAtualizado);
        return enderecoMapper.toDTO(enderecoAtualizado);
    }


    public void deletarEndereco(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> new NotFoundException("Endereco com id: " + id + " não encontrado!"));
        enderecoRepository.delete(endereco);
    }


}
