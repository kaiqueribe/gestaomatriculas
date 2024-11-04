package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.entity.DadosEscolares;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.repository.DadosEscolaresRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//TODO implementar metodos

@Service
@AllArgsConstructor
public class DadosEscolaresService {

    private DadosEscolaresRepository dadosEscolaresRepository;

    @Transactional
    public DadosEscolares cadastrarDadosEscolares(DadosEscolares dadosEscolares) {
        DadosEscolares novosDadosEscolares = dadosEscolaresRepository.save(dadosEscolares);
        return novosDadosEscolares;
    }

    public List<DadosEscolares> listarTodosDadosEscolares() {
        List<DadosEscolares> dadosEscolares = dadosEscolaresRepository.findAll();
        return dadosEscolares.stream().toList();
    }

    public DadosEscolares buscarDadosEscolaresPorId(Long id) {
        DadosEscolares dadosEscolares = dadosEscolaresRepository.findById(id).orElseThrow(() -> new NotFoundException("Dados escolares com id: " + id + " não encontrado!"));
        return dadosEscolares;
    }

    public DadosEscolares atualizarDadosEscolares(Long id, DadosEscolares dadosEscolares) {
        DadosEscolares dadosEscolaresAtualizado = dadosEscolaresRepository.findById(id).orElseThrow(() -> new NotFoundException("Dados escolares com id: " + id + " não encontrado!"));
        dadosEscolaresAtualizado.setNomeEscola(dadosEscolares.getNomeEscola());
        dadosEscolaresAtualizado.setPeriodoEscolar(dadosEscolares.getPeriodoEscolar());
        dadosEscolaresAtualizado.setSerie(dadosEscolares.getSerie());
        dadosEscolaresAtualizado.setTurno(dadosEscolares.getTurno());

        return dadosEscolaresRepository.save(dadosEscolaresAtualizado);
    }

    public void removerDadosEscolares(Long id) {
        DadosEscolares dadosEscolares = dadosEscolaresRepository.findById(id).orElseThrow(() -> new NotFoundException("Dados escolares com id: " + id + " não encontrado!"));
        dadosEscolaresRepository.delete(dadosEscolares);
    }


}
