package com.example.api_catalogoProdutos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_catalogoProdutos.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

