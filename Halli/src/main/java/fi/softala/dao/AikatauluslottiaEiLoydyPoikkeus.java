package fi.softala.dao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class AikatauluslottiaEiLoydyPoikkeus extends RuntimeException {

	public AikatauluslottiaEiLoydyPoikkeus(Exception cause) {
		super(cause);
	}
	
}