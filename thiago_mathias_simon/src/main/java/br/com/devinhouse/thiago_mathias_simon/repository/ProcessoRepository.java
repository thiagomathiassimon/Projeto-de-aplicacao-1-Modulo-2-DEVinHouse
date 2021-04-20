package br.com.devinhouse.thiago_mathias_simon.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.devinhouse.thiago_mathias_simon.dto.ProcessoDTO;
import br.com.devinhouse.thiago_mathias_simon.mock.ProcessoMock;

@Repository
public class ProcessoRepository {

	@Autowired
	private ProcessoMock processoMock;

	public List<ProcessoDTO> findAllProcessos() {
		return processoMock.getAllProcessos();
	}

}
