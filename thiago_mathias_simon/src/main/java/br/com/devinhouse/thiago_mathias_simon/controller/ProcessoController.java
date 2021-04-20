package br.com.devinhouse.thiago_mathias_simon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devinhouse.thiago_mathias_simon.dto.ProcessoCriadoDTO;
import br.com.devinhouse.thiago_mathias_simon.dto.ProcessoDTO;
import br.com.devinhouse.thiago_mathias_simon.service.ProcessoService;

@RestController
@RequestMapping(value = "/processos")
public class ProcessoController {

	@Autowired
	private ProcessoService service;

	public ProcessoCriadoDTO criarProcesso(@RequestBody ProcessoDTO novoProcesso) {

		return null;

	}

	public List<ProcessoDTO> listarProcessos() {
		return service.listarProcessos();
	}

}
