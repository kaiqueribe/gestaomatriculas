package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.dto.*;
import com.imsjt.gestaomatriculas.entity.*;
import com.imsjt.gestaomatriculas.mapper.*;
import com.imsjt.gestaomatriculas.repository.MatriculaRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public MatriculaDTO realizarMatricula(MatriculaDTO matriculaDTO) {


        Atendido novoAtendido = atendidoService.matricularAtendido(matriculaDTO.getAtendidoDTO());
//

        log.info(" Cadastrou novo atendido ");


        Matricula novaMatricula = matriculaMapper.toEntity(matriculaDTO);
        novaMatricula.setAtendido(novoAtendido);
        novaMatricula.setDataMatricula(LocalDate.now());
        log.info(" Definiu data matricula " + novaMatricula.getDataMatricula());



        EnderecoDTO novoEnderecoDTO = matriculaDTO.getEnderecoDTO();
        enderecoService.cadastrarEndereco(novoEnderecoDTO, novoAtendido);

        log.info(" Cadastrou novo Endereco ");


        for (TelefoneDTO telefoneDTO : matriculaDTO.getTelefoneDTOList()) {
            telefoneService.cadastrarTelefoneAtendido(telefoneDTO, novoAtendido);
            log.info("Cadastrou novo telefone" + telefoneDTO.getNumeroTelefone());
        }

        for (ResponsavelDTO responsavelDTO : matriculaDTO.getResponsavelDTOList()) {
            responsavelService.cadastrarResponsavel(responsavelDTO, novoAtendido);
            log.info("Cadastrou novo Responsavel" + responsavelDTO.getCpf());
        }
        novaMatricula.setAtendido(novoAtendido);
        Matricula matriculaSalva = matriculaRepository.save(novaMatricula);

        return matriculaMapper.toDTO(matriculaSalva);

    }


    //precisa ter uma logica que mude o status da matricula para inativo
//    public MatriculaDTO calcelarMatricula(Long cpf, MatriculaDTO matriculaDTO) {
//        Matricula matriculado = matriculaMapper.toEntity(matriculaDTO);
//
//        return null;
//    }


}
