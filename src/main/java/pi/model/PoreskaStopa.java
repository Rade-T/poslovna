package pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="poreskaStopa")
public class PoreskaStopa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="poreskaStopa_id", unique=true, nullable=false)
	public int id;
	
	@Column(name="iznos")
	public float iznosStope;
	
	@ManyToOne
	@JoinColumn(name="istorijaPoreza_id", referencedColumnName="istorijaPoreza_id", nullable=false)
	public IstorijaPoreza istorijaPoreza;
	
	@ManyToOne
	@JoinColumn(name="porez_id", referencedColumnName="porez_id", nullable=false)
	public Porez porez;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getIznosStope() {
		return iznosStope;
	}

	public void setIznosStope(float iznosStope) {
		this.iznosStope = iznosStope;
	}

	public IstorijaPoreza getIstorijaPoreza() {
		return istorijaPoreza;
	}

	public void setIstorijaPoreza(IstorijaPoreza istorijaPoreza) {
		this.istorijaPoreza = istorijaPoreza;
	}

	public Porez getPorez() {
		return porez;
	}

	public void setPorez(Porez porez) {
		this.porez = porez;
	}
}
