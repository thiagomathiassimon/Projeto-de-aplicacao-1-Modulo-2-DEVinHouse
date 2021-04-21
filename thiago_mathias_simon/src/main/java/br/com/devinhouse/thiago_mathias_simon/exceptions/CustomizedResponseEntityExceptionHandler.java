package br.com.devinhouse.thiago_mathias_simon.exceptions;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.devinhouse.thiago_mathias_simon.ErrorDTO.ExceptionResponse;

@RestControllerAdvice
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ProcessAlreadyExistException.class })
	public final ResponseEntity<Object> handleExceptionEntity(ProcessAlreadyExistException paee, WebRequest request)
			throws Exception {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), paee.getMessage(),
				request.getDescription(false), BAD_REQUEST.getReasonPhrase());

		return new ResponseEntity<Object>(exceptionResponse, BAD_REQUEST);

	}

	@ExceptionHandler(value = { NullProcessException.class })
	public final ResponseEntity<Object> handleExceptionEntity(NullProcessException npe, WebRequest request)
			throws Exception {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), npe.getMessage(),
				request.getDescription(false), BAD_REQUEST.getReasonPhrase());

		return new ResponseEntity<Object>(exceptionResponse, BAD_REQUEST);

	}

	@ExceptionHandler(value = { NoSuchElementException.class })
	public final ResponseEntity<Object> handleExceptionEntity(NoSuchElementException nsee, WebRequest request)
			throws Exception {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), nsee.getMessage(),
				request.getDescription(false), NOT_FOUND.getReasonPhrase());

		return new ResponseEntity<Object>(exceptionResponse, NOT_FOUND);

	}

	@ExceptionHandler(value = { ProcessNotFoundException.class })
	public final ResponseEntity<Object> handleExceptionEntity(ProcessNotFoundException pnfe, WebRequest request)
			throws Exception {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), pnfe.getMessage(),
				request.getDescription(false), NOT_FOUND.getReasonPhrase());

		return new ResponseEntity<Object>(exceptionResponse, NOT_FOUND);

	}

}