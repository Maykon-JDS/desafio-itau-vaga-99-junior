package com.desafio.itau.transacao_api.controller;

import com.desafio.itau.transacao_api.business.services.EstatisticasService;
import com.desafio.itau.transacao_api.controller.dtos.EstatisticasResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.net.ssl.SSLEngineResult;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class EstatisticasControllerTest {

    @Mock
    EstatisticasService estatisticasService;

    EstatisticasResponseDTO estatisticas;

    @InjectMocks
    EstatisticasController estatisticasController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(estatisticasController).build();
        estatisticas = new EstatisticasResponseDTO(1L, 20.0, 20.0, 20.0, 20.0);
    }

    @Test
    void deveBuscarEstatisticasComSucesso() throws Exception {
        when (estatisticasService.calcularEstatisticasTransacoes(60)).thenReturn(estatisticas);

        mockMvc.perform(MockMvcRequestBuilders.get("/estatistica")
                .param("intervaloBusca", "60")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.count").value(estatisticas.count()));


    }
	
}
