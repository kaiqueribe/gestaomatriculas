package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.entity.Matricula;
import com.imsjt.gestaomatriculas.repository.MatriculaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MatriculaService {

    private MatriculaRepository matriculaRepository;

    public Matricula cadastrar (Matricula matricula){
        return null;
    }

    public List<Matricula> listarTodasMatriculas(){
        return null;
    }

    public Matricula buscarPorId(Long id){
        return null;
    }

//    public Matricula atualizarMatricula(Long id, Matricula matricula){
//        return null;
//    }

    //Criar remoção de matricula ou permitir somente atualização da situação ?
//    public String removerMatricula(Long id){
//        return null;
//    }


}
