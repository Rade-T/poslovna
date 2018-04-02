package pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PoreskaStopa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="poreskaStopa_id", unique=true, nullable=false)
	public int id;
	
	@Column
	public float iznosStope;
	
	@ManyToOne
	public IstorijaPoreza istorijaPoreza;
	
	@ManyToOne
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
