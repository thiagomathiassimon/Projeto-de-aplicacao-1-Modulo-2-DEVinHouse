package br.com.devinhouse.thiago_mathias_simon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devinhouse.thiago_mathias_simon.dto.ProcessoDTO;
import br.com.devinhouse.thiago_mathias_simon.repository.ProcessoRepository;

@Service
public class ProcessoService {

	@Autowired
	private ProcessoRepository repository;
	
	public List<ProcessoDTO> listarProcessos(){
		return repository.findAllProcessos();
	}
	
}
