package com.marvastsi.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -126209736610142899L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
