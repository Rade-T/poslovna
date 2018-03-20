package pi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
	
	
	
	/*
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
	
	*/
}
