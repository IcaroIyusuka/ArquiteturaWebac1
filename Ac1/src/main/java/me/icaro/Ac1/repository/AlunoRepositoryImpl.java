package me.icaro.Ac1.repository;

import me.icaro.Ac1.modelo.Aluno;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {
    private final List<Aluno> alunos = new ArrayList<>();
    private Long nextId = 1L;

    public AlunoRepositoryImpl(){
    alunos.add(new Aluno(1L,"Jorge","M","Alooobrasil@gmail.com","78961233"));
    nextId = 2L;
    }
    @Override
    public List<Aluno> findAll(){
        return alunos;
    }

    @Override
    public Aluno findById(Long id){
        return alunos.stream()
                .filter(aluno -> aluno.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Aluno save(Aluno aluno) {
        if (aluno.getId()==null){
            aluno.setId(nextId++);
            alunos.add(aluno);
        } else {
            alunos.removeIf(t -> t.getId().equals(aluno.getId()));
            alunos.add(aluno);
        }
        return aluno;
    }
}
