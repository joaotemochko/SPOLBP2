package com.example.api_catalogoProdutos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_catalogoProdutos.dtos.ProdutoRequestDTO;
import com.example.api_catalogoProdutos.dtos.ProdutoResponseDTO;
import com.example.api_catalogoProdutos.models.Produto;
import com.example.api_catalogoProdutos.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(p -> new ProdutoResponseDTO(p.getId(), p.getNome(), p.getPreco()))
                .toList();
    }

    public ProdutoResponseDTO salvar(ProdutoRequestDTO data) {
        Produto novoProduto = new Produto(null, data.nome(), data.preco());
        Produto salvo = repository.save(novoProduto);
        return new ProdutoResponseDTO(salvo.getId(), salvo.getNome(), salvo.getPreco());
    }
}

