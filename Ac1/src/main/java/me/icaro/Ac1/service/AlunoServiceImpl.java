package me.icaro.Ac1.service;

import me.icaro.Ac1.modelo.Aluno;
import me.icaro.Ac1.modelo.AlunoRepository;

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
    public Aluno createAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }
    
    //@Override
    //public Aluno updateAluno(Aluno aluno){    
   //return alunoRepository.update(aluno);    
    //}
    
    @Override
    public Aluno removeAluno(int id){
        return alunoRepository.delete(id);
    }
}
