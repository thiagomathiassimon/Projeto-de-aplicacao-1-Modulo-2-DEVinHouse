package br.com.devinhouse.thiago_mathias_simon.dto;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.GregorianCalendar;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = CREATED)
public class ProcessoCriadoDTO {

	private Integer id;
	private String chaveProcesso;
	private String timestamp = new GregorianCalendar().getTime() + " | " + GregorianCalendar.DATE + "/"
			+  GregorianCalendar.MONTH + "/" + GregorianCalendar.YEAR;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChaveProcesso() {
		return chaveProcesso;
	}

	public void setChaveProcesso(String chaveProcesso) {
		this.chaveProcesso = chaveProcesso;
	}
	
	public String getTimestamp() {
		return this.timestamp;
	}

}
