package com.ifsp.spolbp2.ecommerce_oo.model;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class Pedido {
    
    // Pilar do Encapsulamento: Atributos privados
    private String nomeCliente;
    private String tipoCliente; // EX: "VIP", "ESTUDANTE", "PADRAO"
    private BigDecimal valorOriginal;
    private BigDecimal valorComDesconto;
    
}
