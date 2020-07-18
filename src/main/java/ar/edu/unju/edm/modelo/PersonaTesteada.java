package ar.edu.unju.edm.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;


@Entity
@Component
@Table(name="persona_testeada")
public class PersonaTesteada implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(name="IDPersona")
	private Integer idPersonaTesteada;
	@Column
	private String documento;
	@Column
	private String apellido;
	@Column
	private String nombres;
	@Column
	private String resultadoTesteado;
	
	public PersonaTesteada() {
		
	}

	public PersonaTesteada(int idPersonaTesteada, String documento, String apellido, String nombres,
			String resultadoTesteado) {
		super();
		this.idPersonaTesteada = idPersonaTesteada;
		this.documento = documento;
		this.apellido = apellido;
		this.nombres = nombres;
		this.resultadoTesteado = resultadoTesteado;
	}

	public int getIdPersonaTesteada() {
		return idPersonaTesteada;
	}

	public void setIdPersonaTesteada(int idPersonaTesteada) {
		this.idPersonaTesteada = idPersonaTesteada;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getResultadoTesteado() {
		return resultadoTesteado;
	}

	public void setResultadoTesteado(String resultadoTesteado) {
		this.resultadoTesteado = resultadoTesteado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + idPersonaTesteada;
		result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
		result = prime * result + ((resultadoTesteado == null) ? 0 : resultadoTesteado.hashCode());
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
		PersonaTesteada other = (PersonaTesteada) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (idPersonaTesteada != other.idPersonaTesteada)
			return false;
		if (nombres == null) {
			if (other.nombres != null)
				return false;
		} else if (!nombres.equals(other.nombres))
			return false;
		if (resultadoTesteado == null) {
			if (other.resultadoTesteado != null)
				return false;
		} else if (!resultadoTesteado.equals(other.resultadoTesteado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PersonaTesteada [idPersonaTesteada=" + idPersonaTesteada + ", documento=" + documento + ", apellido="
				+ apellido + ", nombres=" + nombres + ", resultadoTesteado=" + resultadoTesteado + "]";
	}
	
}