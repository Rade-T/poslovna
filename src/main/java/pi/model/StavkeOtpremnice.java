package pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class StavkeOtpremnice {
	
	@Column(nullable = false)
	public float kolicina;
	
	@Column(nullable = false)
	public float cenaPoJediniciMere;
	
	@Column(nullable = false)
	public float ukupnaCena;
	
	@ManyToOne
	public Otpremnica otpremnica;
	
	@ManyToOne
	public RobaUsluga robaUsluga;
}
