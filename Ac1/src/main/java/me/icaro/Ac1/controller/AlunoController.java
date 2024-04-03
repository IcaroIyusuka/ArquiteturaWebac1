package me.icaro.Ac1.controller;


import me.icaro.Ac1.modelo.Aluno;
import me.icaro.Ac1.service.AlunoService;
import org.springframework.web.bind.annotation.*;


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

    @PutMapping("/update/{id}")
    public Aluno updateAluno(@PathVariable ("id") Long id, @RequestBody Aluno aluno){
        return alunoService.updateAluno(aluno);
    }


    @DeleteMapping("/remove/{id}")
    public Aluno removeAluno(@PathVariable int id){
        return alunoService.removeAluno(id);
    }

}
