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
    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private AtendidoService atendidoService;
    @Autowired
    private TelefoneService telefoneService;
    @Autowired
    private ResponsavelService responsavelService;
    @Autowired
    private EnderecoService enderecoService;

    private final MatriculaMapper matriculaMapper;
    private final AtendidoMapper atendidoMapper;
    private final EnderecoMapper enderecoMapper;
    private final TelefoneMapper telefoneMapper;
    private final ResponsavelMapper responsavelMapper;


    public MatriculaDTO realizarMatricula(MatriculaDTO matriculaDTO) {
        Matricula dadosMatriculado = matriculaMapper.toEntity(matriculaDTO);

        log.info(" definindo data matricula ");
        dadosMatriculado.setDataMatricula(LocalDate.now());

        AtendidoDTO novoAtendidoDTO = atendidoService.cadastrarAtendido(matriculaDTO.getAtendidoDTO());
        Atendido novoAtendido = atendidoMapper.toEntity(novoAtendidoDTO);
        dadosMatriculado.setAtendido(novoAtendido);
        log.info(" Cadastrou novo atendido ");

        EnderecoDTO novoEnderecoDTO = enderecoService.cadastrarEndereco(matriculaDTO.getEnderecoDTO());
        Endereco novoEndereco = enderecoMapper.toEntity(novoEnderecoDTO);
        dadosMatriculado.getAtendido().setEndereco(novoEndereco);
        log.info(" Cadastrou novo Endereco ");

        TelefoneDTO telefoneDTO = telefoneService.cadastrarTelefone(matriculaDTO.getTelefoneDTOList().getFirst());
        Telefone novoTelefone = telefoneMapper.toEntity(telefoneDTO);
        List<Telefone> telefoneList = new ArrayList<>();
        telefoneList.add(novoTelefone);
        dadosMatriculado.getAtendido().setTelefonesList(telefoneList);

        ResponsavelDTO responsavelDTO = responsavelService.cadastrarResponsavel(matriculaDTO.getResponsavelDTOList().getFirst());
        Responsavel novoResponsavel = responsavelMapper.toEntity(responsavelDTO);
        List<Responsavel> responsavelList = new ArrayList<>();
        responsavelList.add(novoResponsavel);
        dadosMatriculado.getAtendido().setResponsavelList(responsavelList);

        Matricula novaMatricula = matriculaRepository.save(dadosMatriculado);
        return matriculaMapper.toDTO(novaMatricula);
    }


    //precisa ter uma logica que mude o status da matricula para inativo
    public MatriculaDTO calcelarMatricula(Long cpf, MatriculaDTO matriculaDTO) {
        Matricula matriculado = matriculaMapper.toEntity(matriculaDTO);

        return null;
    }


}
