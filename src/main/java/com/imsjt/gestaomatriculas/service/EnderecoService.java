package com.imsjt.gestaomatriculas.service;


import com.imsjt.gestaomatriculas.entity.Endereco;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.repository.EnderecoRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    //TODO Implementar todos os metodos com as regras de negocio
    public Endereco cadastrarEndereco(Endereco endereco) {
        Endereco novoEndereco = enderecoRepository.save(endereco);
        return novoEndereco;
    }

    public List<Endereco> listarTodosEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos.stream().toList();
    }

    public Endereco buscarEnderecoPorId(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> new NotFoundException("Endereco com id: " + id + " não encontrado!"));
        return endereco;
    }


    public Endereco atualizarEndereco(Long id, Endereco endereco) {
        Endereco enderecoAtualizado = enderecoRepository.findById(id).orElseThrow(() -> new NotFoundException("Endereco com id: " + id + " não encontrado!"));
        enderecoAtualizado.setRua(endereco.getRua());
        enderecoAtualizado.setNumero(endereco.getNumero());
        enderecoAtualizado.setComplemento(endereco.getComplemento());
        enderecoAtualizado.setBairro(endereco.getBairro());
        enderecoAtualizado.setCidade(endereco.getCidade());
        enderecoAtualizado.setEstado(endereco.getEstado());
        enderecoAtualizado.setCep(endereco.getCep());
        return enderecoRepository.save(enderecoAtualizado);
    }


    public void deletarEndereco(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> new NotFoundException("Endereco com id: " + id + " não encontrado!"));
        enderecoRepository.delete(endereco);
    }


}
