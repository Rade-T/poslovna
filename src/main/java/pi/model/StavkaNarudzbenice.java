package pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class StavkaNarudzbenice {
	
	@Column(nullable = false)
	public float kolicina;
	
	@Column(nullable = false)
	public float cenaPoJediniciMere;
	
	@Column(nullable = false)
	public float ukupnaCena;
	
	@ManyToOne
	public RobaUsluga robaUsluga;
	
	@ManyToOne
	public Narudzbenica narudzbenica;
}
