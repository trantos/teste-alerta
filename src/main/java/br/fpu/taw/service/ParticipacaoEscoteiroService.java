package br.fpu.taw.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fpu.taw.model.Escoteiro;
import br.fpu.taw.model.ParticipacaoEscoteiro;
import br.fpu.taw.model.ParticipacaoEscoteiroId;
import br.fpu.taw.model.Reuniao;
import br.fpu.taw.repository.ParticipacaoEscoteiroRepository;

@Service
public class ParticipacaoEscoteiroService {
	@Autowired
	ParticipacaoEscoteiroRepository participacaoEscoteiroRepository;
	
	public List<ParticipacaoEscoteiro> listar() {
		return participacaoEscoteiroRepository.findAll();
	}
	
	public Collection<ParticipacaoEscoteiro> buscarPorEscoteiro(Escoteiro escoteiro) {
		return participacaoEscoteiroRepository.findByEscoteiro(escoteiro);
	}
	
	public Collection<ParticipacaoEscoteiro> buscarPorReuniao(Reuniao reuniao) {
		return participacaoEscoteiroRepository.findByReuniao(reuniao);
	}

	public ParticipacaoEscoteiro salvar(ParticipacaoEscoteiro participacaoEscoteiro) {
		if (participacaoEscoteiro == null || participacaoEscoteiro.getId() == null) {
			throw new IllegalArgumentException();
		}
		return participacaoEscoteiroRepository.save(participacaoEscoteiro);
	}
	
	public ParticipacaoEscoteiro criar(ParticipacaoEscoteiro participacaoEscoteiro) {
		return salvar(participacaoEscoteiro);
	}

	public ParticipacaoEscoteiro atualizar(ParticipacaoEscoteiro participacaoEscoteiro) {
		return salvar(participacaoEscoteiro);
	}

	public void apagar(ParticipacaoEscoteiroId id) {
		if (id == null) {
			throw new IllegalArgumentException();
		}
		participacaoEscoteiroRepository.delete(id);
	}
	
}
