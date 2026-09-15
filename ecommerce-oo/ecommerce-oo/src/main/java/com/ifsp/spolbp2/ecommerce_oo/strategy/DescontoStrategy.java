package com.ifsp.spolbp2.ecommerce_oo.strategy;

import java.math.BigDecimal;

public interface DescontoStrategy {
    
    // Método para aplicar o desconto
    BigDecimal aplicarDesconto(BigDecimal valorOriginal);
    
    // Identificador para o tipo de cliente que essa regra atende
    String getPerfilCliente();
}
