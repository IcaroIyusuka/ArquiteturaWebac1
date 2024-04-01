package me.icaro.Ac1.service;

import me.icaro.Ac1.modelo.Aluno;
import me.icaro.Ac1.repository.AlunoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {
    private final AlunoRepository alunoRepository;


    public AlunoServiceImpl(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<Aluno> getAllAluno(){
        return alunoRepository.findAll();
    }
    @Override
    public Aluno getAlunoById(Long id){
        return alunoRepository.findById(id);
    }
    @Override
    public Aluno getAlunoByNome(String nome){
        return null;
    }
    @Override
    public Aluno createAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Aluno findByNome(String nomeAluno) {
        return null;
    }

}
