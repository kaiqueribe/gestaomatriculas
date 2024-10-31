package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.dto.*;
import com.imsjt.gestaomatriculas.entity.*;

import com.imsjt.gestaomatriculas.exceptions.InvalidRequestException;
import com.imsjt.gestaomatriculas.mapper.*;

import com.imsjt.gestaomatriculas.repository.MatriculaRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Slf4j
@Service
@AllArgsConstructor
public class MatriculaService {

    //TODO Unificar Logica de matricula de atendido nessa service matricula

    private MatriculaRepository matriculaRepository;

    private AtendidoService atendidoService;
    private EnderecoService enderecoService;
    private TelefoneService telefoneService;
    private ResponsavelService responsavelService;

    private final MatriculaMapper matriculaMapper;
    private final AtendidoMapper atendidoMapper;
    private final EnderecoMapper enderecoMapper;


    public MatriculaDTO realizarMatricula(MatriculaDTO matriculaDTO) {

        Matricula novaMatricula = matriculaMapper.toEntity(matriculaDTO);


        try {
            AtendidoDTO novoAtendidoDTO = atendidoService.cadastrarAtendido(matriculaDTO.getAtendidoDTO());
            Atendido novoAtendido = atendidoMapper.toEntity(novoAtendidoDTO);
            log.info(" Cadastrou novo atendido ");
            novaMatricula.setDataMatricula(LocalDate.now());
            log.info(" Definiu data matricula " + novaMatricula.getDataMatricula());
            novaMatricula.setAtendido(novoAtendido);
            log.info("Matricula recebe dados ");
            Matricula matricula = matriculaRepository.save(novaMatricula);

            Endereco novoEndereco = enderecoMapper.toEntity(matriculaDTO.getEnderecoDTO());
            enderecoService.cadastrarEndereco(matriculaDTO.getEnderecoDTO(), novoAtendido);
            novoAtendido.setEndereco(novoEndereco);
            log.info(" Cadastrou novo Endereco ");

            for (TelefoneDTO telefoneDTO : matriculaDTO.getTelefoneDTOList()) {
                telefoneService.cadastrarTelefoneAtendido(telefoneDTO, novoAtendido);
                log.info("Cadastrou novo telefone" + telefoneDTO.getNumeroTelefone());
            }

            for (ResponsavelDTO responsavelDTO : matriculaDTO.getResponsavelDTOList()) {
                responsavelService.cadastrarResponsavel(responsavelDTO, novoAtendido);
                log.info("Cadastrou novo Responsavel" + responsavelDTO.getCpf());
            }

            matriculaRepository.save(novaMatricula);

            return matriculaMapper.toDTO(matricula);
        } catch (InvalidRequestException e) {

            log.error("Erro ao realizar matricula");

            throw e;
        }

    }


    //precisa ter uma logica que mude o status da matricula para inativo
//    public MatriculaDTO calcelarMatricula(Long cpf, MatriculaDTO matriculaDTO) {
//        Matricula matriculado = matriculaMapper.toEntity(matriculaDTO);
//
//        return null;
//    }


}
