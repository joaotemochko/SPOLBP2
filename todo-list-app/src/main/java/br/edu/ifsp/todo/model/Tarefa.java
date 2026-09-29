package br.edu.ifsp.todo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {
    private Long id;
    private String titulo;
    private String descricao;
    private boolean concluida;
}
