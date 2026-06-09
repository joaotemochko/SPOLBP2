package com.example.jogos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jogos.dtos.JogoRequestDTO;
import com.example.jogos.dtos.JogoResponseDTO;
import com.example.jogos.services.JogoService;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private JogoService service;

    @GetMapping
    public ResponseEntity<List<JogoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<JogoResponseDTO> criar(@RequestBody JogoRequestDTO dto) {
        JogoResponseDTO response = service.salvar(dto);
        // Retorna o status 201 (Created) quando inserido com sucesso
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // O PUT precisa do ID na URL e do JSON no corpo da requisição
    @PutMapping("/{id}")
    public ResponseEntity<JogoResponseDTO> atualizar(@PathVariable Long id, @RequestBody JogoRequestDTO dto) {
        JogoResponseDTO response = service.atualizar(id, dto);
        return ResponseEntity.ok(response); // Retorna 200 OK com os dados atualizados
    }

    // O DELETE só precisa do ID na URL
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content (Deletado com sucesso)
    }
}
