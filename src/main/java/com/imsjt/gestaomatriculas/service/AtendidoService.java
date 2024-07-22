package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.entity.Atendido;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.repository.AtendidoRepository;
import com.sun.jdi.request.InvalidRequestStateException;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AtendidoService {

    //TODO Tratar Exceptions

    private AtendidoRepository atendidoRepository;

    public Atendido cadastrarAtendido(Atendido atendido) {
        ;
        atendidoRepository.findByCpf(atendido.getCpf()).ifPresent(atendidoCpf -> {
            throw new InvalidRequestStateException("CPF já Cadastrado!" + atendido.getCpf());
        });
        Atendido novoAtendido = atendidoRepository.save(atendido);
        return atendido;

    }

    public List<Atendido> listarTodosAtendidos() {
        List<Atendido> atendidos = atendidoRepository.findAll();
        return atendidos.stream().toList();
    }

    public Atendido buscarAtendidoPorId(Long id) {
        Atendido atendido = atendidoRepository.findById(id).orElseThrow(() -> new NotFoundException("Atendido com id: "+id+" não encontrado!"));
        return atendido;
    }

//    //TODO: Implementar o método de atualizar
//    public Atendido atualizarAtendido(Long id, Atendido atendido) {
//        return null;
//    }

    public void deletarAtendido(Long id) {
        Atendido atendido = atendidoRepository.findById(id).orElseThrow(() -> new NotFoundException("Atendido com id: "+id+" não encontrado!"));
        atendidoRepository.delete(atendido);

    }


}
