package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.entity.DadosEscolares;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.repository.DadosEscolaresRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//TODO implementar metodos

@Service
@AllArgsConstructor
public class DadosEscolaresService {

    private DadosEscolaresRepository dadosEscolaresRepository;

    private DadosEscolares cadastrarDadosEscolares(DadosEscolares dadosEscolares){
        DadosEscolares novosDadosEscolares = dadosEscolaresRepository.save(dadosEscolares);
        return novosDadosEscolares;
    }

    private List<DadosEscolares > listarTodosDadosEscolares(){
        List<DadosEscolares> dadosEscolares = dadosEscolaresRepository.findAll();
        return dadosEscolares.stream().toList();
    }

    private DadosEscolares buscarDadosEscolaresPorId(Long id){
        DadosEscolares dadosEscolares = dadosEscolaresRepository.findAllById(id).orElseThrow(() -> new NotFoundException("Dados escolares com id: " + id + " não encontrado!"));
        return dadosEscolares;
    }

    private DadosEscolares atualizarDadosEscolares(Long id, DadosEscolares dadosEscolares){
        return null;
    }

    private DadosEscolares removerDadosEscolares(Long id){
        return null;
    }



}
