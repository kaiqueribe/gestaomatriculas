package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.entity.Atendido;
import com.imsjt.gestaomatriculas.entity.Endereco;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EndereçoService {

    private EnderecoRepository enderecoRepository;

    //TODO Implementar todos os metodos com as regras de negocio
    public Endereco cadastrarEndereco(Endereco endereco) {

        var novoEndereco = enderecoRepository.save(endereco);
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
    //TODO Implementar atualizar EnderecoService
    public Atendido atualizarEndereco(Long id, Endereco endereco){
        return null;
    }


    public void deletarEndereco(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> new NotFoundException("Endereco com id: " + id + " não encontrado!"));
        enderecoRepository.delete(endereco);
    }


}
