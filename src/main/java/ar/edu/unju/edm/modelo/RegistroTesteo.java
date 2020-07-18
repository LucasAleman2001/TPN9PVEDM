package ar.edu.unju.edm.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="registro_Testeos")
public class RegistroTesteo implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(name="IDRegistro")
	private Long idRegistroTesteo;
	@Column(name="FECHAHORA")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDateTime fechahora;
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IDUNIDADHABITACIONAL")
	private UnidadHabitacional unidad_habitacional;
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IDPERSONATESTEADA")
	private PersonaTesteada persona_testeada;
	
	public RegistroTesteo() {
		
	}

	public RegistroTesteo(Long idRegistroTesteo, LocalDateTime fechahora, UnidadHabitacional unidad_habitacional,
			PersonaTesteada persona_testeada) {
		super();
		this.idRegistroTesteo = idRegistroTesteo;
		this.fechahora = fechahora;
		this.unidad_habitacional = unidad_habitacional;
		this.persona_testeada = persona_testeada;
	}

	public Long getIdRegistroTesteo() {
		return idRegistroTesteo;
	}

	public void setIdRegistroTesteo(Long idRegistroTesteo) {
		this.idRegistroTesteo = idRegistroTesteo;
	}

	public LocalDateTime getFechahora() {
		return fechahora;
	}

	public void setFechahora(LocalDateTime fechahora) {
		this.fechahora = fechahora;
	}

	public UnidadHabitacional getUnidad_habitacional() {
		return unidad_habitacional;
	}

	public void setUnidad_habitacional(UnidadHabitacional unidad_habitacional) {
		this.unidad_habitacional = unidad_habitacional;
	}

	public PersonaTesteada getPersona_testeada() {
		return persona_testeada;
	}

	public void setPersona_testeada(PersonaTesteada persona_testeada) {
		this.persona_testeada = persona_testeada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechahora == null) ? 0 : fechahora.hashCode());
		result = prime * result + ((idRegistroTesteo == null) ? 0 : idRegistroTesteo.hashCode());
		result = prime * result + ((persona_testeada == null) ? 0 : persona_testeada.hashCode());
		result = prime * result + ((unidad_habitacional == null) ? 0 : unidad_habitacional.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroTesteo other = (RegistroTesteo) obj;
		if (fechahora == null) {
			if (other.fechahora != null)
				return false;
		} else if (!fechahora.equals(other.fechahora))
			return false;
		if (idRegistroTesteo == null) {
			if (other.idRegistroTesteo != null)
				return false;
		} else if (!idRegistroTesteo.equals(other.idRegistroTesteo))
			return false;
		if (persona_testeada == null) {
			if (other.persona_testeada != null)
				return false;
		} else if (!persona_testeada.equals(other.persona_testeada))
			return false;
		if (unidad_habitacional == null) {
			if (other.unidad_habitacional != null)
				return false;
		} else if (!unidad_habitacional.equals(other.unidad_habitacional))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RegistroTesteo [idRegistroTesteo=" + idRegistroTesteo + ", fechahora=" + fechahora
				+ ", unidad_habitacional=" + unidad_habitacional + ", persona_testeada=" + persona_testeada + "]";
	}
	

}