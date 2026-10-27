package com.exemplo.projeto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository repository;

    @Test
    void deveSalvarEBuscarUsuario() {
        Usuario salvo = repository.save(new Usuario("Ana", "ana@email.com"));

        assertNotNull(salvo.getId());
        assertEquals("Ana", repository.findById(salvo.getId()).orElseThrow().getNome());
    }
}
