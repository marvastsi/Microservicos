package com.marvastsi.crud.exception;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = -5352614499261996749L;

	private Date timestamp;
	private String message;
	private String details;
}
