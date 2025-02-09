package com.desafio.itau.transacao_api.business.services;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.itau.transacao_api.controller.dtos.EstatisticasResponseDTO;
import com.desafio.itau.transacao_api.controller.dtos.TransacaoRequestDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticasService {

	public final TransacaoService trasacaoService;

	public EstatisticasResponseDTO calcularEstatisticasTransacoes(Integer intervaloBusca) {

		log.info("Iniciada busca de estatisticas de transacoes pelo periodo de tempo " + intervaloBusca.toString());
		List<TransacaoRequestDTO> transacoes = trasacaoService.buscarTransacoes(intervaloBusca);

		if (transacoes.isEmpty()) {
			return new EstatisticasResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);
		}

		DoubleSummaryStatistics estatisticasTrasacoes = transacoes.stream()
																	.mapToDouble(TransacaoRequestDTO::valor)
																		.summaryStatistics();
		log.info("Estatisticas retornadas com sucesso");



		return new EstatisticasResponseDTO(
								estatisticasTrasacoes.getCount(),
								estatisticasTrasacoes.getSum(),
								estatisticasTrasacoes.getAverage(),
								estatisticasTrasacoes.getMin(),
								estatisticasTrasacoes.getMax()
								);
	}

}
