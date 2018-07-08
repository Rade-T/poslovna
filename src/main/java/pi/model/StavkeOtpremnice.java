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
@Table(name="stavkeOtpremnice")
public class StavkeOtpremnice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stavkeOtpremnice_id",unique=true,nullable=false)
	public int id;
	
	@Column(name="kolicina",nullable = false)
	public float kolicina;
	
	@Column(name="cenaPoJediniciMere",nullable = false)
	public float cenaPoJediniciMere;
	
	@Column(name="ukupnaCena",nullable = false)
	public float ukupnaCena;
	
	@ManyToOne
	@JoinColumn(name="otpremnica_id", referencedColumnName="otpremnica_id", nullable=false)
	public Otpremnica otpremnica;
	
	@ManyToOne
	@JoinColumn(name="robaUsluga_id", referencedColumnName="robaUsluga_id", nullable=false)
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
