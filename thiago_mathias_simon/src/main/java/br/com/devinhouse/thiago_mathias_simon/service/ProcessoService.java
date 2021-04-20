package br.com.devinhouse.thiago_mathias_simon.service;

import java.beans.IndexedPropertyChangeEvent;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devinhouse.thiago_mathias_simon.dto.ProcessoReturnDTO;
import br.com.devinhouse.thiago_mathias_simon.entity.ProcessoEntity;
import br.com.devinhouse.thiago_mathias_simon.repository.ProcessoRepository;

@Service
public class ProcessoService {

	@Autowired
	private ProcessoRepository repository;

	public Iterable<ProcessoEntity> listarProcessos() {
		return recuperarProcessos();
	}

	public ProcessoReturnDTO cadastrarProcesso(ProcessoEntity novoProcesso) {

		repository.save(novoProcesso);

		ProcessoReturnDTO processoCriado = new ProcessoReturnDTO();
		processoCriado.setId(novoProcesso.getId());
		processoCriado.setChaveProcesso(novoProcesso.getChaveProcesso());

		return processoCriado;
	}

	public Optional<ProcessoEntity> buscarProcessoPorId(long id) {

		Optional<ProcessoEntity> processo = recuperarProcessoPorId(id);
		return Optional.ofNullable(processo.orElseThrow());
	}

	public ProcessoEntity buscarProcessoPorChave(ProcessoEntity chaveProcesso) {

		Iterable<ProcessoEntity> todosOsProcessos = recuperarProcessos();

		for (ProcessoEntity processo : todosOsProcessos) {
			if (processo.getChaveProcesso().equals(chaveProcesso.getChaveProcesso())) {
				return processo;
			}
		}

		return null;

	}

	public ProcessoEntity atualizarProcessso(long id, ProcessoEntity processoAtualizado) {

		Iterable<ProcessoEntity> todosOsProcessos = repository.findAll();

		for (ProcessoEntity process : todosOsProcessos) {

			if (process.getId() == id) {
				
				Integer nuProcesso = (processoAtualizado.getNuProcesso() != null) ? processoAtualizado.getNuProcesso() : process.getNuProcesso();
				String chaveProcesso = (processoAtualizado.getChaveProcesso() != null) ? processoAtualizado.getChaveProcesso() : process.getChaveProcesso(); 
				String sgOrgaoProcesso =  (processoAtualizado.getSgOrgaoProcesso() != null) ? processoAtualizado.getSgOrgaoProcesso() : process.getSgOrgaoProcesso();
				String nuAnoProcesso = (processoAtualizado.getNuAnoProcesso() != null) ? processoAtualizado.getNuAnoProcesso() : process.getNuAnoProcesso();
				String descricao = (processoAtualizado.getDescricao() != null) ? processoAtualizado.getDescricao() : process.getDescricao();
				Integer cdAssunto = (processoAtualizado.getCdAssunto() != null) ? processoAtualizado.getCdAssunto() : process.getCdAssunto();
				String descricaoAssunto = (processoAtualizado.getDescricaoAssunto() != null) ? processoAtualizado.getDescricaoAssunto() : process.getDescricaoAssunto();
				Integer cdInteressado = (processoAtualizado.getCdInteressado() != null) ? processoAtualizado.getCdInteressado() : process.getCdInteressado();
				String nmInteressado = (processoAtualizado.getNmInteressado() != null) ? processoAtualizado.getNmInteressado() : process.getNmInteressado();
				
				process.setNuProcesso(nuProcesso);
				process.setChaveProcesso(chaveProcesso);
				process.setSgOrgaoProcesso(sgOrgaoProcesso);
				process.setNuAnoProcesso(nuAnoProcesso);
				process.setDescricao(descricao);
				process.setCdAssunto(cdAssunto);
				process.setDescricaoAssunto(descricaoAssunto);
				process.setCdInteressado(cdInteressado);
				process.setNmInteressado(nmInteressado);
				
				repository.save(process);
				return process;
			}
		}
		return null;
	}
	
	public void deletarProcesso(long id) {
		repository.deleteById(id);
	}

	private Iterable<ProcessoEntity> recuperarProcessos() {
		return repository.findAll();
	}

	private Optional<ProcessoEntity> recuperarProcessoPorId(long id) {
		return repository.findById(id);
	}

}
