package me.icaro.Ac1.controller;


import me.icaro.Ac1.modelo.Aluno;
import me.icaro.Ac1.repository.AlunoRepository;
import me.icaro.Ac1.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> getAllAluno(){
        return alunoService.getAllAluno();
    }



    @GetMapping("/{id}")
    public Aluno getAlunoById(@PathVariable Long id){
        return alunoService.getAlunoById(id);
    }

    @PostMapping("/add")
    public Aluno createAluno(@RequestBody Aluno aluno){
        return alunoService.createAluno(aluno);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id){
        alunoService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Aluno update(@PathVariable ("id") Long id, @RequestBody Aluno aluno){
       return alunoService.update(aluno);

    }
}
