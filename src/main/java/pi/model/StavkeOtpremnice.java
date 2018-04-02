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

	public float getKolicina() {
		return kolicina;
	}

	public void setKolicina(float kolicina) {
		this.kolicina = kolicina;
	}

	public float getCenaPoJediniciMere() {
		return cenaPoJediniciMere;
	}

	public void setCenaPoJediniciMere(float cenaPoJediniciMere) {
		this.cenaPoJediniciMere = cenaPoJediniciMere;
	}

	public float getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(float ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public Otpremnica getOtpremnica() {
		return otpremnica;
	}

	public void setOtpremnica(Otpremnica otpremnica) {
		this.otpremnica = otpremnica;
	}

	public RobaUsluga getRobaUsluga() {
		return robaUsluga;
	}

	public void setRobaUsluga(RobaUsluga robaUsluga) {
		this.robaUsluga = robaUsluga;
	}
	
}
