package com.desafio.itau.transacao_api.business.services;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.desafio.itau.transacao_api.controller.dtos.TransacaoRequestDTO;
import com.desafio.itau.transacao_api.infrastructure.exceptions.UnprocessableEntity;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

	private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList();
	
	public void adicionarTransacoes(TransacaoRequestDTO dto) {
		
		log.info("Iniciando o processamento de gravar transações");
		
		if (dto.dataHora().isAfter(OffsetDateTime.now())) {
			
			log.error("Data e hora maiores que a data e hora atuais");
			
			throw new UnprocessableEntity("Data e hora maiores que a data e hora atuais");
		}
		if (dto.valor() < 0) {
			log.error("Valor não poder ser menor que 0");
			
			throw new UnprocessableEntity("Valor não poder ser menor que 0");
		}
		
		
		listaTransacoes.add(dto);
	}
	
	public void limparTransacoes() {
		
		listaTransacoes.clear();
		
	}
	
	public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloBusca) {
		
		OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);
		
		return listaTransacoes.stream()
				.filter((transacao) -> transacao.dataHora().isAfter(dataHoraIntervalo))
					.toList();
		
	}
	
}
