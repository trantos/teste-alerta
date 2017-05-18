package br.fpu.taw.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reuniao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 100)
	private String tema;

	@Column(nullable = false, length = 100)
	private String objetivo;

//	@OneToMany(mappedBy = "id.reuniao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@Fetch( FetchMode.JOIN )
//	private Set<ParticipacaoEscoteiro> participacaoEscoteiros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reuniao [id=");
		builder.append(id);
		builder.append(", tema=");
		builder.append(tema);
		builder.append(", objetivo=");
		builder.append(objetivo);
		builder.append("]");
		return builder.toString();
	}

}
