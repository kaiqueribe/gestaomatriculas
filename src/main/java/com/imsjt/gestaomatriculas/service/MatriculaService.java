package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.dto.*;
import com.imsjt.gestaomatriculas.entity.*;

import com.imsjt.gestaomatriculas.mapper.*;

import com.imsjt.gestaomatriculas.repository.MatriculaRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class MatriculaService {

    //TODO Unificar Logica de matricula de atendido nessa service matricula

    private MatriculaRepository matriculaRepository;

    private AtendidoService atendidoService;

    private TelefoneService telefoneService;

    private ResponsavelService responsavelService;

    private EnderecoService enderecoService;

    private final MatriculaMapper matriculaMapper;
    private final AtendidoMapper atendidoMapper;
    private final EnderecoMapper enderecoMapper;


    public MatriculaDTO realizarMatricula(MatriculaDTO matriculaDTO) {
        Matricula matricula = matriculaMapper.toEntity(matriculaDTO);

        log.info(" definindo data matricula ");
        matricula.setDataMatricula(LocalDate.now());
        Matricula novaMatricula = matriculaRepository.save(matricula);

        AtendidoDTO novoAtendidoDTO = atendidoService.cadastrarAtendido(matriculaDTO.getAtendidoDTO());
        Atendido novoAtendido = atendidoMapper.toEntity(novoAtendidoDTO);
        matricula.setAtendido(novoAtendido);
        log.info(" Cadastrou novo atendido ");

        EnderecoDTO novoEnderecoDTO = enderecoService.cadastrarEndereco(matriculaDTO.getEnderecoDTO(),novoAtendido);
        Endereco novoEndereco = enderecoMapper.toEntity(novoEnderecoDTO);
        novoAtendido.setEndereco(novoEndereco);
        log.info(" Cadastrou novo Endereco ");


        for (TelefoneDTO telefoneDTO : matriculaDTO.getTelefoneDTOList()) {
            telefoneService.cadastrarTelefoneAtendido(telefoneDTO, novoAtendido);
        }


        for (ResponsavelDTO responsavelDTO : matriculaDTO.getResponsavelDTOList()) {
            responsavelService.cadastrarResponsavel(responsavelDTO,novoAtendido);
        }


        return matriculaMapper.toDTO(novaMatricula);
    }


    //precisa ter uma logica que mude o status da matricula para inativo
//    public MatriculaDTO calcelarMatricula(Long cpf, MatriculaDTO matriculaDTO) {
//        Matricula matriculado = matriculaMapper.toEntity(matriculaDTO);
//
//        return null;
//    }


}
