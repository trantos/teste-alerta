package br.fpu.taw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fpu.taw.model.Patrulha;
import br.fpu.taw.repository.PatrulhaRepository;

@Service
public class PatrulhaService {
	@Autowired
	PatrulhaRepository patrulhaRepository;
	
	public List<Patrulha> listar() {
		return patrulhaRepository.findAll();
	}
	
	public Patrulha buscarPorId(Long id) {
		return patrulhaRepository.findOne(id);
	}

	public Patrulha criar(Patrulha patrulha) {
		if (patrulha == null || patrulha.getId() != null) {
			throw new IllegalArgumentException();
		}
		return patrulhaRepository.save(patrulha);
	}

	public Patrulha atualizar(Patrulha patrulha) {
		if (patrulha == null || patrulha.getId() == null) {
			throw new IllegalArgumentException();
		}
		return patrulhaRepository.save(patrulha);
	}

	public void apagar(Long id) {
		if (id == null) {
			throw new IllegalArgumentException();
		}
		patrulhaRepository.delete(id);
	}
	
}
