package com.example.jogos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jogos.dtos.JogoRequestDTO;
import com.example.jogos.dtos.JogoResponseDTO;
import com.example.jogos.models.Jogo;
import com.example.jogos.repositories.JogoRepository;

@Service
public class JogoService {

    @Autowired
    private JogoRepository repository;

    public List<JogoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(jogo -> new JogoResponseDTO(jogo.getId(), jogo.getTitulo(), jogo.getPlataforma()))
                .collect(Collectors.toList());
    }

    public JogoResponseDTO buscarPorId(Long id) {
        Jogo jogo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado!"));
        return new JogoResponseDTO(jogo.getId(), jogo.getTitulo(), jogo.getPlataforma());
    }

    public JogoResponseDTO salvar(JogoRequestDTO dto) {
        // Converte o DTO para a Entidade (sem ID, pois a base de dados vai gerar)
        Jogo novoJogo = new Jogo(null, dto.titulo(), dto.plataforma());
        
        // Guarda na base de dados
        Jogo jogoGuardado = repository.save(novoJogo);
        
        // Devolve o DTO com o ID gerado
        return new JogoResponseDTO(jogoGuardado.getId(), jogoGuardado.getTitulo(), jogoGuardado.getPlataforma());
    }

    public JogoResponseDTO atualizar(Long id, JogoRequestDTO dto) {
        // 1. Busca o jogo antigo no banco de dados
        Jogo jogoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado!"));

        // 2. Atualiza os dados na memória usando os Setters
        jogoExistente.setTitulo(dto.titulo());
        jogoExistente.setPlataforma(dto.plataforma());

        // 3. Salva por cima (O Spring faz o UPDATE no banco)
        Jogo jogoAtualizado = repository.save(jogoExistente);

        // 4. Converte para DTO e devolve
        return new JogoResponseDTO(
            jogoAtualizado.getId(), 
            jogoAtualizado.getTitulo(), 
            jogoAtualizado.getPlataforma()
        );
    }

    public void deletar(Long id) {
        // 1. Verifica se o jogo existe antes de tentar apagar
        if (!repository.existsById(id)) {
            throw new RuntimeException("Jogo não encontrado!");
        }
        
        // 2. Apaga do banco
        repository.deleteById(id);
    }
}
