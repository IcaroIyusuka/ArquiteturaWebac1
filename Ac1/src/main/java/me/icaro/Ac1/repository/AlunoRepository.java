package me.icaro.Ac1.repository;

import me.icaro.Ac1.modelo.Aluno;

import java.util.List;

public interface AlunoRepository {

    List<Aluno> findAll();

    Aluno findById(Long id);

    Aluno save(Aluno aluno);

    Aluno deleteById(Long id);
    Aluno update(Aluno aluno);
}
