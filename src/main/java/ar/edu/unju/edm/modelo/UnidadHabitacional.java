package ar.edu.unju.edm.modelo;

import java.io.Serializable;
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
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="unidad_habitacional")
public class UnidadHabitacional implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(name="IDUnidad")
	private Long idUnidadHabitacional;
	@Column(name="DIRECCION")
	private String direccion;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IDBARRIO")
	private Barrio barrio;
	
	public UnidadHabitacional() {
		
	}

	public UnidadHabitacional(Long idUnidadHabitacional, String direccion, Barrio barrio) {
		super();
		this.idUnidadHabitacional = idUnidadHabitacional;
		this.direccion = direccion;
		this.barrio = barrio;
	}

	public Long getIdUnidadHabitacional() {
		return idUnidadHabitacional;
	}

	public void setIdUnidadHabitacional(Long idUnidadHabitacional) {
		this.idUnidadHabitacional = idUnidadHabitacional;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Barrio getBarrio() {
		return barrio;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barrio == null) ? 0 : barrio.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((idUnidadHabitacional == null) ? 0 : idUnidadHabitacional.hashCode());
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
		UnidadHabitacional other = (UnidadHabitacional) obj;
		if (barrio == null) {
			if (other.barrio != null)
				return false;
		} else if (!barrio.equals(other.barrio))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (idUnidadHabitacional == null) {
			if (other.idUnidadHabitacional != null)
				return false;
		} else if (!idUnidadHabitacional.equals(other.idUnidadHabitacional))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UnidadHabitacional [idUnidadHabitacional=" + idUnidadHabitacional + ", direccion=" + direccion
				+ ", barrio=" + barrio + "]";
	}
	
}