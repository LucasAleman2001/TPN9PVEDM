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

@Component
@Entity
@Table(name="barrio")
public class Barrio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idBarrio;
	@Column
	private String Nombre;

	public Barrio() {
		
	}

	public Barrio(Long idBarrio, String nombre) {
		super();
		this.idBarrio = idBarrio;
		Nombre = nombre;
	}

	public Long getIdBarrio() {
		return idBarrio;
	}

	public void setIdBarrio(Long idBarrio) {
		this.idBarrio = idBarrio;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((idBarrio == null) ? 0 : idBarrio.hashCode());
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
		Barrio other = (Barrio) obj;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (idBarrio == null) {
			if (other.idBarrio != null)
				return false;
		} else if (!idBarrio.equals(other.idBarrio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Barrio [idBarrio=" + idBarrio + ", Nombre=" + Nombre + "]";
	}

}