package br.fpu.taw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fpu.taw.model.Escoteiro;
import br.fpu.taw.repository.EscoteiroRepository;

@Service
public class EscoteiroService {
	@Autowired
	EscoteiroRepository escoteiroRepository;
	
	public List<Escoteiro> listar() {
		return escoteiroRepository.findAll();
	}
	
	public Escoteiro buscarPorRegistro(String registro) {
		return escoteiroRepository.findOne(registro);
	}

	public Escoteiro salvar(Escoteiro escoteiro) {
		if (escoteiro == null || escoteiro.getRegistro() == null) {
			throw new IllegalArgumentException();
		}
		return escoteiroRepository.save(escoteiro);
	}
	
	public Escoteiro criar(Escoteiro escoteiro) {
		// nesse caso a logica é a mesma
		return salvar(escoteiro);
	}

	public Escoteiro atualizar(Escoteiro escoteiro) {
		// nesse caso a logica é a mesma
		return salvar(escoteiro);
	}

	public void apagar(String registro) {
		if (registro == null) {
			throw new IllegalArgumentException();
		}
		escoteiroRepository.delete(registro);
	}
	
}
