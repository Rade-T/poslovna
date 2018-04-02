package pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class StavkeFakture {
	
	@Column(nullable = true)
	public float kolicina;
	
	@Column(nullable = true)
	public float cenaPoJediniciMere;
	
	@Column(nullable = true)
	public float rabat;
	
	@Column(nullable = true, precision = 15, scale = 2)
	public float osnovica;
	
	@Column(nullable = true)
	public float pdvIznos; 
	
	@Column(nullable = true)
	public float ukupanIznos;
	
	@Column(nullable = true)
	public float pdv;
	
	@ManyToOne
	public IzlaznaFaktura izlaznaFaktura;
	
	
	@ManyToOne
	public RobaUsluga robaUsluga;
}
