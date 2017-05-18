package br.fpu.taw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fpu.taw.model.Reuniao;
import br.fpu.taw.repository.ReuniaoRepository;

@Service
public class ReuniaoService {
	@Autowired
	ReuniaoRepository reuniaoRepository;
	
	public List<Reuniao> listar() {
		return reuniaoRepository.findAll();
	}
	
	public Reuniao buscarPorId(Long id) {
		return reuniaoRepository.findOne(id);
	}

	public Reuniao criar(Reuniao reuniao) {
		if (reuniao == null || reuniao.getId() != null) {
			throw new IllegalArgumentException();
		}
		return reuniaoRepository.save(reuniao);
	}

	public Reuniao atualizar(Reuniao reuniao) {
		if (reuniao == null || reuniao.getId() == null) {
			throw new IllegalArgumentException();
		}
		return reuniaoRepository.save(reuniao);
	}

	public void apagar(Long id) {
		if (id == null) {
			throw new IllegalArgumentException();
		}
		reuniaoRepository.delete(id);
	}
	
}
