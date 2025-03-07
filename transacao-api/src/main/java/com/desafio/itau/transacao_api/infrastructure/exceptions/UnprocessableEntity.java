package com.desafio.itau.transacao_api.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntity extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 1L;

	public UnprocessableEntity(String message) {super(message);};
	
}
