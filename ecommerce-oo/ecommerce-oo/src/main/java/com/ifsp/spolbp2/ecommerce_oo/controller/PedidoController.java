package com.ifsp.spolbp2.ecommerce_oo.controller;

import com.ifsp.spolbp2.ecommerce_oo.model.Pedido;
import com.ifsp.spolbp2.ecommerce_oo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // Teste no navegador: http://localhost:8080/api/pedidos/checkout?nome=Joao&perfil=VIP&valor=100
    @GetMapping("/checkout")
    public ResponseEntity<Pedido> realizarCheckout(
            @RequestParam String nome, 
            @RequestParam String perfil, 
            @RequestParam BigDecimal valor) {
        
        Pedido pedidoProcessado = pedidoService.processarPedido(nome, perfil, valor);
        return ResponseEntity.ok(pedidoProcessado);
    }
}