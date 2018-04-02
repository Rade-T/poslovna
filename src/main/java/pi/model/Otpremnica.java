package pi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Otpremnica {
	
	@Id
	@Column(nullable = false, unique = true)
	public int brojOtpremnice;
	
	@Column
	public Date datumOtpremnice;

	@Column(nullable = false, precision = 15)
	public float osnovica;
	
	@Column(nullable = false, precision = 15)
	public float ukupanPdv;
	
	@Column(nullable = false, precision = 15)
	public float iznosZaPlacanje;
	
	@ManyToOne
	public PoslovniPartner poslovniPartner;
	
	@OneToMany(mappedBy="otpremnica")
	public List<IzlaznaFaktura> izlaznaFaktura;
	
	@ManyToOne
	public PoslovnaGodina poslovnaGodina;
	
	@OneToMany(mappedBy="otpremnica")
	public List<StavkeOtpremnice> stavkeOtpremnice;
	
	@ManyToOne
	public Narudzbenica narudzbenica;
	
	public Otpremnica() {
		
	}

	public int getBrojOtpremnice() {
		return brojOtpremnice;
	}

	public void setBrojOtpremnice(int brojOtpremnice) {
		this.brojOtpremnice = brojOtpremnice;
	}

	public Date getDatumOtpremnice() {
		return datumOtpremnice;
	}

	public void setDatumOtpremnice(Date datumOtpremnice) {
		this.datumOtpremnice = datumOtpremnice;
	}

	public float getOsnovica() {
		return osnovica;
	}

	public void setOsnovica(float osnovica) {
		this.osnovica = osnovica;
	}

	public float getUkupanPdv() {
		return ukupanPdv;
	}

	public void setUkupanPdv(float ukupanPdv) {
		this.ukupanPdv = ukupanPdv;
	}

	public float getIznosZaPlacanje() {
		return iznosZaPlacanje;
	}

	public void setIznosZaPlacanje(float iznosZaPlacanje) {
		this.iznosZaPlacanje = iznosZaPlacanje;
	}

	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public List<IzlaznaFaktura> getIzlaznaFaktura() {
		return izlaznaFaktura;
	}

	public void setIzlaznaFaktura(List<IzlaznaFaktura> izlaznaFaktura) {
		this.izlaznaFaktura = izlaznaFaktura;
	}

	public PoslovnaGodina getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	public List<StavkeOtpremnice> getStavkeOtpremnice() {
		return stavkeOtpremnice;
	}

	public void setStavkeOtpremnice(List<StavkeOtpremnice> stavkeOtpremnice) {
		this.stavkeOtpremnice = stavkeOtpremnice;
	}

	public Narudzbenica getNarudzbenica() {
		return narudzbenica;
	}

	public void setNarudzbenica(Narudzbenica narudzbenica) {
		this.narudzbenica = narudzbenica;
	}
}
