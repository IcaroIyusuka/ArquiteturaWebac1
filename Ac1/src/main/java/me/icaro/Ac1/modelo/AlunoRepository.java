package me.icaro.Ac1.modelo;

import java.util.List;

public interface AlunoRepository {


    List<Aluno> findAll();

    Aluno findById(Long id);

    Aluno save(Aluno aluno);

    Aluno delete(int id);
}
