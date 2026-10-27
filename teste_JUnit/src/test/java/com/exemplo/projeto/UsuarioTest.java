package com.exemplo.projeto;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UsuarioTest {

    @Test
    void deveValidarUsuario() {
        Usuario u = new Usuario("Ana", "ana@email.com");

        assertAll("usuario",
            () -> assertEquals("Ana", u.getNome()),
            () -> assertEquals("ana@email.com", u.getEmail()),
            () -> assertTrue(u.getEmail().contains("@"))
        );
    }
}
