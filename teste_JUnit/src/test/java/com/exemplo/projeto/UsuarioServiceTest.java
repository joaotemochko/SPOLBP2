package com.exemplo.projeto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    UsuarioRepository repository;   // dependência falsa

    @InjectMocks
    UsuarioService service;         // classe real, recebe o mock

    @Test
    void deveBuscarUsuarioExistente() {
        Usuario ana = new Usuario(1L, "Ana");
        when(repository.findById(1L)).thenReturn(Optional.of(ana));

        Usuario resultado = service.buscarPorId(1L);

        assertEquals("Ana", resultado.getNome());
        verify(repository).findById(1L);
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioNaoExiste() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException e = assertThrows(RuntimeException.class, () -> service.buscarPorId(99L));

        assertEquals("Não encontrado", e.getMessage());
    }
}
