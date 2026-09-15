package com.ifsp.spolbp2.ecommerce_oo.service;

import com.ifsp.spolbp2.ecommerce_oo.model.Pedido;
import com.ifsp.spolbp2.ecommerce_oo.strategy.DescontoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PedidoService {

    private final Map<String, DescontoStrategy> estrategiasDeDesconto = new HashMap<>();

    // O Spring injeta a lista de estratégias disponíveis automaticamente
    @Autowired
    public PedidoService(List<DescontoStrategy> strategies) {
        for (DescontoStrategy strategy : strategies) {
            estrategiasDeDesconto.put(strategy.getPerfilCliente().toUpperCase(), strategy);
        }
    }

    public Pedido processarPedido(String nomeCliente, String perfilCliente, BigDecimal valorTotal) {
        
        // 1. Buscamos a estratégia (Polimorfismo em ação!)
        DescontoStrategy strategy = estrategiasDeDesconto.get(perfilCliente.toUpperCase());
        
        BigDecimal valorFinal = valorTotal;
        
        // Se a estratégia existir, aplicamos. Se não, mantemos o valor original.
        if (strategy != null) {
            valorFinal = strategy.aplicarDesconto(valorTotal);
        }
        
        // 2. Utilizamos o Padrão Builder para montar a resposta
        return Pedido.builder()
                .nomeCliente(nomeCliente)
                .tipoCliente(perfilCliente.toUpperCase())
                .valorOriginal(valorTotal)
                .valorComDesconto(valorFinal)
                .build();
    }
}
