package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.entity.Funcionario;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public Funcionario cadastrarFuncionario(Funcionario funcionario) {
        Funcionario funcionarioCadastrado = funcionarioRepository.save(funcionario);
        return funcionarioCadastrado;
    }

    public List<Funcionario> listarTodosFuncionarios() {
        List<Funcionario> funcionarioList = funcionarioRepository.findAll();
        return funcionarioList.stream().toList();
    }

    public Funcionario buscarPorId(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Funcionario com id: " + id + " não encontrado!"));
        return funcionario;
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionario) {
        Funcionario funcionarioAtualizado = funcionarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Funcionario com id: " + id + " não encontrado!"));
        funcionarioAtualizado.setNomeFuncionario(funcionario.getNomeFuncionario());
        funcionarioAtualizado.setEmailFuncionario(funcionario.getEmailFuncionario());
        funcionarioAtualizado.setCargoFuncionario(funcionario.getCargoFuncionario());
        return funcionarioAtualizado;
    }

    public String removerFuncionario(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Funcionario com id: " + id + " não encontrado!"));
        funcionarioRepository.delete(funcionario);
        return "Funcionario removido com sucesso!";
    }

}
