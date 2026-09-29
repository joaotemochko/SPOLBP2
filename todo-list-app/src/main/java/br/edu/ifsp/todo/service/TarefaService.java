package br.edu.ifsp.todo.service;

import br.edu.ifsp.todo.dto.TarefaDTO;
import br.edu.ifsp.todo.model.Tarefa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TarefaService {

    // Simulando um banco de dados em memória
    private final List<Tarefa> repositorio = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(1);

    public List<Tarefa> listarTodas() {
        return repositorio;
    }

    public Tarefa criarTarefa(TarefaDTO dto) {
        Tarefa novaTarefa = new Tarefa(
            contadorId.getAndIncrement(),
            dto.getTitulo(),
            dto.getDescricao(),
            false
        );
        repositorio.add(novaTarefa);
        return novaTarefa;
    }
}
