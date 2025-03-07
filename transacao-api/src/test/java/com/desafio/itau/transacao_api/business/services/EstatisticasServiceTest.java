package com.desafio.itau.transacao_api.business.services;

import com.desafio.itau.transacao_api.controller.dtos.EstatisticasResponseDTO;
import com.desafio.itau.transacao_api.controller.dtos.TransacaoRequestDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EstatisticasServiceTest {

    @Mock // Cria um Mock da classe TransacaoService que serja injetada na classe EstatisticasService
    TransacaoService transacaoService;

    @InjectMocks // Cria uma instância real de EstatisticasService e injeta o mock transacaoService nele.
    EstatisticasService estatisticasService;

    TransacaoRequestDTO transacao;

    EstatisticasResponseDTO estatisticas;

    @BeforeEach
    void setUp(){

        transacao = new TransacaoRequestDTO(20.0, OffsetDateTime.now());
        estatisticas = new EstatisticasResponseDTO(1L, 20.0, 20.0, 20.0, 20.0);

    }

    @Test
    void calcularEstatisticasComSucesso(){
        when(transacaoService.buscarTransacoes(60)).thenReturn(Collections.singletonList(transacao));

        EstatisticasResponseDTO resultado = estatisticasService.calcularEstatisticasTransacoes(60);

        verify(transacaoService, times(1)).buscarTransacoes(60);

        Assertions.assertThat(resultado).usingRecursiveComparison().isEqualTo(estatisticas);
    }

    @Test
    void calcularEstatisticasQuandoListaVazia(){

        EstatisticasResponseDTO estatisticasEsperada = new EstatisticasResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);

        when(transacaoService.buscarTransacoes(60)).thenReturn(Collections.emptyList());

        EstatisticasResponseDTO resultado = estatisticasService.calcularEstatisticasTransacoes(60);

        verify(transacaoService, times(1)).buscarTransacoes(60);

        Assertions.assertThat(resultado).usingRecursiveComparison().isEqualTo(estatisticasEsperada);
    }


}
