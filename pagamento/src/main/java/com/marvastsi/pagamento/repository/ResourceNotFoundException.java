package com.marvastsi.pagamento.repository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3097921878123574439L;

	public ResourceNotFoundException(String exception) {
		super(exception);
	}
}
