package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.dto.AtendidoDTO;
import com.imsjt.gestaomatriculas.dto.MatriculaDTO;
import com.imsjt.gestaomatriculas.entity.Atendido;
import com.imsjt.gestaomatriculas.entity.Matricula;
import com.imsjt.gestaomatriculas.entity.Responsavel;
import com.imsjt.gestaomatriculas.exceptions.InvalidRequestException;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.mapper.MatriculaMapper;
import com.imsjt.gestaomatriculas.repository.AtendidoRepository;
import com.imsjt.gestaomatriculas.repository.MatriculaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class MatriculaService {

    //TODO Unificar Logica de matricula de atendido nessa service matricula

    private AtendidoRepository atendidoRepository;
    private MatriculaRepository matriculaRepository;
    private final MatriculaMapper matriculaMapper;

    public MatriculaDTO matricularAtendido(MatriculaDTO matriculaDTO) {
//
        Matricula matricula = matriculaMapper.toEntity(matriculaDTO);
//        matriculaRepository.findByAtendidoCpf(matricula.getAtendido().getCpf()).ifPresent(atendidoCpf -> {
//            throw new InvalidRequestException("Cpf Já Cadastrado" + matricula.getAtendido().getCpf());
//        });
        matricula.setDataMatricula(LocalDate.now());

        Matricula novaMatricula = matriculaRepository.save(matricula);
        return matriculaMapper.toDTO(novaMatricula);
    }

    public MatriculaDTO realizarMatricula(MatriculaDTO matriculaDTO) {
        Matricula matriculado = matriculaMapper.toEntity(matriculaDTO);

// Matricula matriculaAtualizada = matriculaRepository.findById(id).orElseThrow(() -> new NotFoundException("Matricula com id: " + id + " não encontrada!"));
        //TODO buscar atendido pelo cpf, se existir=atendidojamatriculado,senao=matricular
        //TODO o cpf esta retornando nulo ao bucar do dto de matricula para o dto de atendido
        Matricula matriculaAtualizada = matriculaRepository.findByAtendidoCpf(matriculado.getAtendido().getCpf())
                .orElseThrow(() -> new InvalidRequestException("Já existe um Atendido matriculado com o CPF: " + matriculado.getAtendido().getCpf()));
        matriculaAtualizada.getAtendido().setCpf(matriculado.getAtendido().getCpf());
        matriculaAtualizada.setDataMatricula(LocalDate.now());
        matriculaAtualizada.setStatusMatricula(matriculado.getStatusMatricula());
        matriculaRepository.save(matriculaAtualizada);
        return matriculaMapper.toDTO(matriculaAtualizada);
    }

//    public MatriculaDTO realizarMatricula(MatriculaDTO matriculaDTO) {
//        Matricula matriculado = matriculaMapper.toEntity(matriculaDTO);
//
//// Matricula matriculaAtualizada = matriculaRepository.findById(id).orElseThrow(() -> new NotFoundException("Matricula com id: " + id + " não encontrada!"));
//        Matricula matriculaAtualizada = matriculaRepository.findByAtendidoCpf(matriculado.getAtendido().getCpf())
//                .orElseThrow(() -> new InvalidRequestException("Já existe um Atendido matriculado com o CPF: " + matriculado.getAtendido().getCpf()));
//        matriculaAtualizada.setDataMatricula(LocalDate.now());
//        matriculaAtualizada.setDataFimMatricula(matriculado.getDataFimMatricula());
//        matriculaAtualizada.setStatusMatricula(matriculado.getStatusMatricula());
//        matriculaRepository.save(matriculaAtualizada);
//        return matriculaMapper.toDTO(matriculaAtualizada);
//    }

    public Matricula buscarPorId(Long id) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Matricula com id: " + id + " não encontrada!"));
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
