package com.ifsp.spolbp2.ecommerce_oo.strategy.impl;

import com.ifsp.spolbp2.ecommerce_oo.strategy.DescontoStrategy;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class DescontoVip implements DescontoStrategy {

    @Override
    public BigDecimal aplicarDesconto(BigDecimal valorOriginal) {
        // Regra: 20% de desconto para clientes VIP
        BigDecimal fatorDesconto = new BigDecimal("0.80"); 
        return valorOriginal.multiply(fatorDesconto);
    }

    @Override
    public String getPerfilCliente() {
        return "VIP";
    }
}
