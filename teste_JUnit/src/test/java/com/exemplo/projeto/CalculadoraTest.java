package com.exemplo.projeto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Calculadora")
class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    void setUp() {
        calc = new Calculadora();   // objeto novo a cada teste
    }

    @Test
    @DisplayName("soma 2 + 3 deve resultar em 5")
    void deveSomarDoisNumeros() {
        Calculadora calc = new Calculadora();   // Arrange
        int resultado = calc.somar(2, 3);       // Act
        assertEquals(5, resultado);             // Assert
    }

    @Test
    void deveSubtrair() {
        assertEquals(1, calc.subtrair(3, 2));
    }

    @Test
    void deveMultiplicar() {
        assertEquals(12, calc.multiplicar(3, 4));
    }

    @Test
    void deveLancarExcecaoAoDividirPorZero() {
        IllegalArgumentException e = assertThrows(
            IllegalArgumentException.class,
            () -> calc.dividir(10, 0)
        );

        assertEquals("Divisor zero", e.getMessage());
    }

    @Test
    void deveDividirComResultadoTruncado() {
        assertEquals(3, calc.dividir(10, 3));
    }

    @ParameterizedTest
    @CsvSource({
        "2, 3, 5",
        "0, 0, 0",
        "-1, 1, 0",
        "100, 200, 300"
    })
    void deveSomarVariosValores(int a, int b, int esperado) {
        assertEquals(esperado, calc.somar(a, b));
    }
}
