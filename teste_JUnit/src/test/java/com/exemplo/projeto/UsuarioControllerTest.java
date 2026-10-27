package com.exemplo.projeto;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    MockMvc mockMvc;          // simula requisições HTTP

    @MockitoBean
    UsuarioService service;   // Service falso, sem banco

    @Test
    void deveRetornarUsuarioPorId() throws Exception {
        Usuario ana = new Usuario(1L, "Ana");
        when(service.buscarPorId(1L)).thenReturn(ana);

        mockMvc.perform(get("/usuarios/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nome").value("Ana"));
    }
}
