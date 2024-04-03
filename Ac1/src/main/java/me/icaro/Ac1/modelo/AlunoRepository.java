package me.icaro.Ac1.modelo;

import java.util.List;

public interface AlunoRepository {


    List<Aluno> findAll();

    Aluno createAluno(Aluno aluno);

    Aluno findById(Long id);

    Aluno save(Aluno aluno);

    Aluno delete(int id);

    Aluno update(Aluno aluno);
}
