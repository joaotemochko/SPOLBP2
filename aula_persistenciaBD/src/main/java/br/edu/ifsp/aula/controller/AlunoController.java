package br.edu.ifsp.aula.controller;

import br.edu.ifsp.aula.model.Aluno;
import br.edu.ifsp.aula.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("alunos", repository.findAll());
        model.addAttribute("novoAluno", new Aluno());
        return "index";
    }

    @PostMapping("/adicionar")
    public String adicionar(@ModelAttribute Aluno aluno) {
        repository.save(aluno);
        return "redirect:/";
    }

    @GetMapping("/deletar/{id}")
    public String remover(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
