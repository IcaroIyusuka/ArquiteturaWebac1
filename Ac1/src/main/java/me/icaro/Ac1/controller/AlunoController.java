package me.icaro.Ac1.controller;


import me.icaro.Ac1.modelo.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private List<Aluno> alunos = new ArrayList<>();
    private Long idCounter = 1L;

    public AlunoController (){

        alunos.add(new Aluno(idCounter,
                "jose",
                "M" ,
                "ze@pode",
                "flamengos"));
    }

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunos;
    }

    @PostMapping
    public Aluno addAluno(@RequestBody Aluno aluno) {
        aluno.setId(idCounter++);
        alunos.add(aluno);
        return aluno;
    }

    @GetMapping("/{id}")
    public Aluno getAlunoById(@PathVariable Long id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId().equals(id)) {
                return aluno;
            }
        }
        return null; // or throw exception
    }

    @PutMapping("/alunos/{id}")
    public Aluno updateAluno(@PathVariable Long id, @RequestBody Aluno updatedAluno) {
        for (Aluno aluno : alunos) {
            if (aluno.getId().equals(id)) {
                aluno.setNome(updatedAluno.getNome());
                aluno.setSexo(updatedAluno.getSexo());
                aluno.setEmail(updatedAluno.getEmail());
                aluno.setTelefone(updatedAluno.getTelefone());
                return aluno;
            }
        }
        return null; // or throw exception
    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable Long id) {
        alunos.removeIf(aluno -> aluno.getId().equals(id));
    }
}
