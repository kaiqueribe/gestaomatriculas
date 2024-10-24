package com.imsjt.gestaomatriculas.service;


import com.imsjt.gestaomatriculas.dto.AtendidoDTO;
import com.imsjt.gestaomatriculas.dto.MatriculaDTO;
import com.imsjt.gestaomatriculas.entity.Atendido;
import com.imsjt.gestaomatriculas.entity.Matricula;

import com.imsjt.gestaomatriculas.exceptions.InvalidRequestException;

import com.imsjt.gestaomatriculas.mapper.AtendidoMapper;
import com.imsjt.gestaomatriculas.mapper.MatriculaMapper;
import com.imsjt.gestaomatriculas.repository.AtendidoRepository;
import com.imsjt.gestaomatriculas.repository.MatriculaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class MatriculaService {

    private final AtendidoService atendidoService;

    //TODO Unificar Logica de matricula de atendido nessa service matricula

    private AtendidoRepository atendidoRepository;
    private MatriculaRepository matriculaRepository;

    private final MatriculaMapper matriculaMapper;
    private final AtendidoMapper atendidoMapper;

    public MatriculaDTO realizarMatricula(MatriculaDTO matriculaDTO) {
        Matricula dadosMatricula = matriculaMapper.toEntity(matriculaDTO);

        //Define data da realização da matricula
        dadosMatricula.setDataMatricula(LocalDate.now());

        //busca atendido por cpf
        String cpf = matriculaDTO.getAtendidoDTO().getCpf();
        Optional<Atendido> atendidoOpt = atendidoRepository.findByCpf(cpf);

        if (atendidoOpt.isPresent()) {
            log.info(" Já existe um Atendido matriculado com o cpf: " + cpf);
            throw new InvalidRequestException("Já existe um Atendido matriculado com o cpf: " + cpf);
        }

        log.info(" Atendido com cpf: " + cpf + "Cadastrado com sucesso!");
        Atendido novoAtendido = atendidoMapper.toEntity(matriculaDTO.getAtendidoDTO());

        atendidoRepository.save(novoAtendido);
        dadosMatricula.setAtendido(novoAtendido);


        Matricula novaMatricula = matriculaRepository.save(dadosMatricula);
        return matriculaMapper.toDTO(novaMatricula);
    }

//    //precisa ter uma logica que mude o status da matricula para inativo
//    public void calcelarMatricula(Long id) {
//
//    }


}
