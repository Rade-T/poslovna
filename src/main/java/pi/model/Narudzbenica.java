package pi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="narudzbenica")
public class Narudzbenica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "narudzbenica_id", unique = true, nullable = false)
	public int id;

	@Column(name="kolicina", unique = false)
	public float kolicina;
	
	@ManyToOne
	@JoinColumn(name="poslovnaGodina_id", referencedColumnName="poslovnaGodina_id")
	public PoslovnaGodina poslovnaGodina;
	
	@ManyToOne
	@JoinColumn(name="poslovniPartner_id", referencedColumnName="poslovniPartner_id")
	public PoslovniPartner poslovniPartner;
	
	@OneToMany(mappedBy = "narudzbenica")
	public List<Otpremnica> otpremnica;
	
	@OneToMany(mappedBy = "narudzbenica")
	public List<StavkaNarudzbenice> stavkeNarudzbenice;

	public float getKolicina() {
		return kolicina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setKolicina(float kolicina) {
		this.kolicina = kolicina;
	}

	public PoslovnaGodina getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public List<Otpremnica> getOtpremnica() {
		return otpremnica;
	}

	public void setOtpremnica(List<Otpremnica> otpremnica) {
		this.otpremnica = otpremnica;
	}

	public List<StavkaNarudzbenice> getStavkeNarudzbenice() {
		return stavkeNarudzbenice;
	}

	public void setStavkeNarudzbenice(List<StavkaNarudzbenice> stavkeNarudzbenice) {
		this.stavkeNarudzbenice = stavkeNarudzbenice;
	}

}
