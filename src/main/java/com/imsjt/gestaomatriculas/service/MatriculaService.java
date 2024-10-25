package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.dto.AtendidoDTO;
import com.imsjt.gestaomatriculas.dto.EnderecoDTO;
import com.imsjt.gestaomatriculas.dto.MatriculaDTO;
import com.imsjt.gestaomatriculas.entity.Atendido;
import com.imsjt.gestaomatriculas.entity.Endereco;
import com.imsjt.gestaomatriculas.entity.Matricula;
import com.imsjt.gestaomatriculas.entity.Responsavel;
import com.imsjt.gestaomatriculas.exceptions.InvalidRequestException;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.mapper.AtendidoMapper;
import com.imsjt.gestaomatriculas.mapper.EnderecoMapper;
import com.imsjt.gestaomatriculas.mapper.MatriculaMapper;
import com.imsjt.gestaomatriculas.repository.AtendidoRepository;
import com.imsjt.gestaomatriculas.repository.MatriculaRepository;
import com.imsjt.gestaomatriculas.repository.ResponsavelRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class MatriculaService {

    //TODO Unificar Logica de matricula de atendido nessa service matricula

    private MatriculaRepository matriculaRepository;
    @Autowired
    private AtendidoService atendidoService;
    private TelefoneService telefoneService;
    private ResponsavelService responsavelService;
    private EnderecoService enderecoService;

    private final MatriculaMapper matriculaMapper;
    private final AtendidoMapper atendidoMapper;
    private final EnderecoMapper enderecoMapper;


    public MatriculaDTO realizarMatricula(MatriculaDTO matriculaDTO) {
        Matricula dadosMatriculado = matriculaMapper.toEntity(matriculaDTO);

        log.info(" definindo data matricula ");
        dadosMatriculado.setDataMatricula(LocalDate.now());

        AtendidoDTO novoAtendidoDTO = atendidoService.cadastrarAtendido(matriculaDTO.getAtendidoDTO());
        Atendido novoAtendido = atendidoMapper.toEntity(novoAtendidoDTO);
        dadosMatriculado.setAtendido(novoAtendido);
        log.info(" Cadastrou novo atendido ");

        EnderecoDTO enderecoDTO = enderecoService.cadastrarEndereco(matriculaDTO.getEnderecoDTO());
        Endereco novoEndereco = enderecoMapper.toEntity(enderecoDTO);
        dadosMatriculado.getAtendido().setEndereco(novoEndereco);
        log.info(" Cadastrou novo Endereco ");


        //TODO verifica se foi definido pelo menos um telefone


        Matricula novaMatricula =  matriculaRepository.save(dadosMatriculado);
        return matriculaMapper.toDTO(novaMatricula);
    }


    //precisa ter uma logica que mude o status da matricula para inativo
    public MatriculaDTO calcelarMatricula(Long cpf, MatriculaDTO matriculaDTO) {
        Matricula matriculado = matriculaMapper.toEntity(matriculaDTO);

        return null;
    }


}
