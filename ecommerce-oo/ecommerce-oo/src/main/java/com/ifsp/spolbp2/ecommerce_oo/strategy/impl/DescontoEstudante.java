package com.ifsp.spolbp2.ecommerce_oo.strategy.impl;

import com.ifsp.spolbp2.ecommerce_oo.strategy.DescontoStrategy;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class DescontoEstudante implements DescontoStrategy {

    @Override
    public BigDecimal aplicarDesconto(BigDecimal valorOriginal) {
        // Regra: 15% de desconto fixo
        BigDecimal fatorDesconto = new BigDecimal("0.85");
        return valorOriginal.multiply(fatorDesconto);
    }

    @Override
    public String getPerfilCliente() {
        return "ESTUDANTE";
    }
}