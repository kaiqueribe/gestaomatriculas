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
import com.imsjt.gestaomatriculas.mapper.MatriculaMapper;
import com.imsjt.gestaomatriculas.repository.AtendidoRepository;
import com.imsjt.gestaomatriculas.repository.MatriculaRepository;
import com.imsjt.gestaomatriculas.repository.ResponsavelRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class MatriculaService {

    //TODO Unificar Logica de matricula de atendido nessa service matricula

    private final AtendidoRepository atendidoRepository;
    private ResponsavelRepository responsavelRepository;
    private MatriculaRepository matriculaRepository;

    private AtendidoService atendidoService;
    private TelefoneService telefoneService;
    private ResponsavelService responsavelService;
    private EnderecoService enderecoService;

    private final MatriculaMapper matriculaMapper;
    private final AtendidoMapper atendidoMapper;


    public MatriculaDTO realizarMatricula(MatriculaDTO matriculaDTO) {
        Matricula dadosMatriculado = matriculaMapper.toEntity(matriculaDTO);

        //caso não encontre o cpf cadastra atendido definindo dia atual que esta sendo matriculado
        dadosMatriculado.setDataMatricula(LocalDate.now());


        //TODO o cpf esta retornando nulo ao bucar do dto de matricula para o dto de atendido
        //TODO ao registrar deve ser gravada a data atual

        //Definir Endereço do atendido
//        Endereco


        //Busca por CPF e caso encontre retorna atendido com cpf ja esta matriculado
        String cpf = matriculaDTO.getAtendidoDTO().getCpf();
        Optional<Atendido> atendidoOpt = atendidoRepository.findByCpf(cpf);

        if (atendidoOpt.isPresent()) {
            log.info("cpf buscado: " + cpf);
            throw new InvalidRequestException("Já existe um Atendido matriculado com o CPF: " + cpf);
        }
        Atendido novoAtendido = atendidoMapper.toEntity(matriculaDTO.getAtendidoDTO());
        atendidoRepository.save(novoAtendido);
        dadosMatriculado.setAtendido(novoAtendido);
        log.info("Atendido com CPF: " + cpf + "Cadastrado com sucesso");


        //verifica se foi definido pelo menos um telefone

        matriculaRepository.save(dadosMatriculado);

        atendidoMapper.toDTO(novoAtendido);
        return matriculaMapper.toDTO(dadosMatriculado);
    }


    //precisa ter uma logica que mude o status da matricula para inativo
    public MatriculaDTO calcelarMatricula(Long cpf, MatriculaDTO matriculaDTO) {
        Matricula matriculado = matriculaMapper.toEntity(matriculaDTO);

        return null;
    }


}
