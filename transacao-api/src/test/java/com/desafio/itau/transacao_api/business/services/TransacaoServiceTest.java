package com.desafio.itau.transacao_api.business.services;

import com.desafio.itau.transacao_api.controller.dtos.EstatisticasResponseDTO;
import com.desafio.itau.transacao_api.controller.dtos.TransacaoRequestDTO;
import com.desafio.itau.transacao_api.infrastructure.exceptions.UnprocessableEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransacaoServiceTest {

    @InjectMocks // Cria uma instância real de EstatisticasService e injeta o mock transacaoService nele.
    TransacaoService transacaoService;

    TransacaoRequestDTO transacao;

    EstatisticasResponseDTO estatisticas;

    @BeforeEach
    void setUp(){

        transacao = new TransacaoRequestDTO(20.0, OffsetDateTime.now());
        estatisticas = new EstatisticasResponseDTO(1L, 20.0, 20.0, 20.0, 20.0);

    }

    @Test
    void deveAdicionarTransacaoComSucesso(){

        transacaoService.adicionarTransacoes(transacao);

        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(5000);

        assertTrue(transacoes.contains(transacao));
    }

    @Test
    void deveLancarExcecaoCasoValorSejaNegativo(){

        UnprocessableEntity exception = assertThrows(UnprocessableEntity.class, () -> transacaoService.adicionarTransacoes(new TransacaoRequestDTO(-10.0, OffsetDateTime.now())));

        assertEquals("Valor não poder ser menor que 0", exception.getMessage());

    }

    @Test
    void deveLancarExcecaoCasoDataEOuHoraMaiorQueAtual(){

        UnprocessableEntity exception = assertThrows(UnprocessableEntity.class, () -> transacaoService.adicionarTransacoes(new TransacaoRequestDTO(10.0, OffsetDateTime.now().plusDays(1))));

        assertEquals("Data e hora maiores que a data e hora atuais", exception.getMessage());

    }

    @Test
    void deveLimparTransacaoComSucesso(){

        transacaoService.adicionarTransacoes(transacao);

        transacaoService.limparTransacoes();

        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(5000);

        assertTrue(transacoes.isEmpty());
    }

    @Test
    void deveBuscarTransacoesDentroDoIntervalo(){

        TransacaoRequestDTO dto = new TransacaoRequestDTO(10.0, OffsetDateTime.now().minusHours(1));

        transacaoService.adicionarTransacoes(dto);

        transacaoService.adicionarTransacoes(transacao);

        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(60);

        assertTrue(transacoes.contains(transacao));
        assertFalse(transacoes.contains(dto));
    }


}
