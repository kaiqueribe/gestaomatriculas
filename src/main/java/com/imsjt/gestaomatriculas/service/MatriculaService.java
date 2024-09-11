package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.entity.Matricula;
import com.imsjt.gestaomatriculas.entity.Responsavel;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.repository.AtendidoRepository;
import com.imsjt.gestaomatriculas.repository.MatriculaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MatriculaService {

    //TODO Unificar Logica de matricula de atendido nessa service matricula

    private AtendidoRepository atendidoRepository;
    private MatriculaRepository matriculaRepository;

    public Matricula matricularAtendido(Matricula matricula) {

        Matricula novaMatricula = matriculaRepository.save(matricula);
        return novaMatricula;
    }

    public Matricula atualizarMatricula(Long id, Matricula matricula) {
        Matricula matriculaAtualizada = matriculaRepository.findById(id).orElseThrow(() -> new NotFoundException("Matricula com id: " + id + " não encontrada!"));
        matriculaAtualizada.setDataMatricula(matricula.getDataMatricula());
        matriculaAtualizada.setDataFimMatricula(matricula.getDataFimMatricula());
        matriculaAtualizada.setSituacao(matricula.isSituacao());
        return matriculaRepository.save(matriculaAtualizada);
    }

    public Matricula buscarPorId(Long id) {
        Matricula matricula = matriculaRepository.findById(id).orElseThrow(() -> new NotFoundException("Matricula com id: " + id + " não encontrada!"));
        return matricula;
    }

    //tentar chamar service de responsavel
    public void adicionarResponsavel(Long id) {

    }

    //tentar chamar service de telefone
    public void adicionarTelefone(Long id) {

    }

    //precisa ter uma logica que mude o status da matricula para inativo
    public void calcelarMatricula(Long id) {

    }


}
