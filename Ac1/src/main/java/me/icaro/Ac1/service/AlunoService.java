package me.icaro.Ac1.service;

import me.icaro.Ac1.modelo.Aluno;
import java.util.List;
public interface AlunoService {

    List<Aluno> getAllAluno();

    Aluno getAlunoById(Long id);

    Aluno createAluno(Aluno aluno);

    Aluno removeAluno(int id);

    Aluno updateAluno(Aluno aluno);
}
