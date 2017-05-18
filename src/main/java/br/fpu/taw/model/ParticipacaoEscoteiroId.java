package br.fpu.taw.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ParticipacaoEscoteiroId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL)
	private Escoteiro escoteiro;

	@ManyToOne(cascade = CascadeType.ALL)
	private Reuniao reuniao;

	public Escoteiro getEscoteiro() {
		return escoteiro;
	}

	public void setEscoteiro(Escoteiro escoteiro) {
		this.escoteiro = escoteiro;
	}

	public Reuniao getReuniao() {
		return reuniao;
	}

	public void setReuniao(Reuniao reuniao) {
		this.reuniao = reuniao;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParticipacaoEscoteiroId [escoteiro=");
		builder.append(escoteiro);
		builder.append(", reuniao=");
		builder.append(reuniao);
		builder.append("]");
		return builder.toString();
	}

}
