package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.entity.Matricula;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.repository.MatriculaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MatriculaService {

    private MatriculaRepository matriculaRepository;

    public Matricula cadastrarMatricula(Matricula matricula) {
        Matricula novaMatricula = matriculaRepository.save(matricula);
        return novaMatricula;
    }

    public List<Matricula> listarTodasMatriculas() {
        List<Matricula> matriculaList = matriculaRepository.findAll();
        return matriculaList.stream().toList();
    }

    public Matricula buscarPorId(Long id) {
        Matricula matricula = matriculaRepository.findById(id).orElseThrow(() -> new NotFoundException("Matricula com id: " + id + " não encontrada!"));
        return matricula;
    }

    public Matricula atualizarMatricula(Long id, Matricula matricula) {
        Matricula matriculaAtualizada = matriculaRepository.findById(id).orElseThrow(() -> new NotFoundException("Matricula com id: " + id + " não encontrada!"));
        matriculaAtualizada.setDataMatricula(matricula.getDataMatricula());
        matriculaAtualizada.setDataFimMatricula(matricula.getDataFimMatricula());
        matriculaAtualizada.setSituacao(matricula.isSituacao());
        return matriculaRepository.save(matriculaAtualizada);
    }

    //Criar remoção de matricula ou permitir somente atualização da situação ?
//    public String removerMatricula(Long id){
//        return null;
//    }


}
