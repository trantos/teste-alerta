package br.fpu.taw.model;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;

@Entity
@AssociationOverrides({
		@AssociationOverride(name = "id.escoteiro", joinColumns = @JoinColumn(name = "escoteiro_registro")),
		@AssociationOverride(name = "id.reuniao", joinColumns = @JoinColumn(name = "reuniao_id")) })
public class ParticipacaoEscoteiro implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ParticipacaoEscoteiroId id;

	@Enumerated(EnumType.STRING)
	private Presenca presenca;

	@Column
	private short participacao;

	@Column
	private short uniforme;

	@Column
	private short disciplina;

	@Column(nullable = true)
	private String observacao;

	public ParticipacaoEscoteiroId getId() {
		return id;
	}

	public void setId(ParticipacaoEscoteiroId id) {
		this.id = id;
	}

	public Presenca getPresenca() {
		return presenca;
	}

	public void setPresenca(Presenca presenca) {
		this.presenca = presenca;
	}

	public short getParticipacao() {
		return participacao;
	}

	public void setParticipacao(short participacao) {
		this.participacao = participacao;
	}

	public short getUniforme() {
		return uniforme;
	}

	public void setUniforme(short uniforme) {
		this.uniforme = uniforme;
	}

	public short getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(short disciplina) {
		this.disciplina = disciplina;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParticipacaoEscoteiro [id=");
		builder.append(id);
		builder.append(", presenca=");
		builder.append(presenca);
		builder.append(", participacao=");
		builder.append(participacao);
		builder.append(", uniforme=");
		builder.append(uniforme);
		builder.append(", disciplina=");
		builder.append(disciplina);
		builder.append(", observacao=");
		builder.append(observacao);
		builder.append("]");
		return builder.toString();
	}

}
