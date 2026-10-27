package com.exemplo.projeto;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidadorTest {

    private Validador validador;

    @BeforeEach
    void setUp() {
        validador = new Validador();
    }

    @ParameterizedTest
    @ValueSource(ints = {18, 19, 30, 100})
    void devePermitirMaioresDeIdade(int idade) {
        assertTrue(validador.isMaiorDeIdade(idade));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 17})
    void deveBloquearMenoresDeIdade(int idade) {
        assertFalse(validador.isMaiorDeIdade(idade));
    }

    @Test
    void deveLancarExcecaoParaIdadeNegativa() {
        assertThrows(IllegalArgumentException.class, () -> validador.isMaiorDeIdade(-1));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ana@email.com", "joao.silva@ifsp.edu.br"})
    void deveAceitarEmailsValidos(String email) {
        assertTrue(validador.isEmailValido(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "ana", "ana@", "@email.com", "ana@email"})
    void deveRejeitarEmailsInvalidos(String email) {
        assertFalse(validador.isEmailValido(email));
    }

    @Test
    void deveRejeitarEmailNulo() {
        assertFalse(validador.isEmailValido(null));
    }
}
