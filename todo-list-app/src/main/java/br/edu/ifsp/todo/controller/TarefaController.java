package br.edu.ifsp.todo.controller;

import br.edu.ifsp.todo.dto.TarefaDTO;
import br.edu.ifsp.todo.model.Tarefa;
import br.edu.ifsp.todo.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    // Injeção de Dependência via construtor
    @Autowired
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listar() {
        // O Controller não acessa o banco, ele delega para o Service!
        return ResponseEntity.ok(tarefaService.listarTodas());
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody TarefaDTO tarefaDTO) {
        Tarefa nova = tarefaService.criarTarefa(tarefaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nova);
    }
}
