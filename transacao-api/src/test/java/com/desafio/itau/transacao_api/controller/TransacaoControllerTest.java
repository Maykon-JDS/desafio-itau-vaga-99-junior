package com.desafio.itau.transacao_api.controller;

import com.desafio.itau.transacao_api.business.services.TransacaoService;
import com.desafio.itau.transacao_api.controller.dtos.TransacaoRequestDTO;
import com.desafio.itau.transacao_api.infrastructure.exceptions.UnprocessableEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TransacaoControllerTest {

    @Mock
    TransacaoService transacaoService;

    TransacaoRequestDTO transacao;

    @InjectMocks
    TransacaoController transacaoController;

    MockMvc mockMvc;

    @Autowired
    final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp(){
        objectMapper.registerModule(new JavaTimeModule());
        mockMvc = MockMvcBuilders.standaloneSetup(transacaoController).build();
        transacao = new TransacaoRequestDTO(20.0, OffsetDateTime.of(2025, 3, 7, 14, 0, 0, 0, ZoneOffset.UTC));
    }

    @Test
    void deveAdicionarTransacaoComSucesso() throws Exception {

        doNothing().when(transacaoService).adicionarTransacoes(transacao);

        mockMvc.perform(MockMvcRequestBuilders.post("/transacao")
                .content(objectMapper.writeValueAsString(transacao))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());


    }

    @Test
    void deveGerarExcecaoAoAdicionarTransacao() throws Exception{
        doThrow(new UnprocessableEntity("Erro de requisição")).when(transacaoService).adicionarTransacoes(transacao);

        mockMvc.perform(MockMvcRequestBuilders.post("/transacao")
               .content(objectMapper.writeValueAsString(transacao))
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().is4xxClientError());
    }

    @Test
    void deveDeletarTransacoesComSucesso() throws Exception{
        doNothing().when(transacaoService).limparTransacoes();

        mockMvc.perform(MockMvcRequestBuilders.delete("/transacao"))
                .andExpect(status().isOk());
    }
	
}
