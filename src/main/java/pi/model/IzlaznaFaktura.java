package pi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class IzlaznaFaktura {
	
	@Column(unique = true, nullable = false)
	public int brojFakture;

	@Column(nullable = false)
	public Date datumFakture;
	
	@Column(nullable = true)
	public Date datumValute;
	
	@Column(nullable = true)
	public Date datumObracuna;
	
	@Column(nullable = true, precision = 15, scale = 2)
	public float ukupnoRobe;
	
	@Column(nullable = true, precision = 15, scale = 2)
	public float ukupanRabat;
	
	@Column(nullable = true, precision = 15, scale = 2)
	public float ukupanPorez; //pdv iznos ++
	
	@Column(nullable = true, precision = 15, scale = 2)
	public float iznosFakture;
	
	@Column(nullable = true, precision = 15, scale = 2)
	public float iznosFaktureOsnovica; //todo
	
	@Column(nullable = true, length = 40)
	public String uplataNaRacun;
	
	@Column(nullable = true, length = 20)
	public String pozivNaBroj;
	
	@OneToMany(mappedBy="izlaznaFaktura")
	public List<StavkeFakture> stavkeFakture;
	
	@OneToMany(mappedBy="izlaznaFaktura")
	public List<ObracunatiPorez> obracunatiPorez;
	
	@Column(nullable = false) 
	public String statusFakture;
	
	@ManyToOne
	public PoslovniPartner poslovniPartner;
	
	@ManyToOne
	public PoslovnaGodina poslovnaGodina;
	
	@ManyToOne
	public Otpremnica otpremnica;

	public int getBrojFakture() {
		return brojFakture;
	}

	public void setBrojFakture(int brojFakture) {
		this.brojFakture = brojFakture;
	}

	public Date getDatumFakture() {
		return datumFakture;
	}

	public void setDatumFakture(Date datumFakture) {
		this.datumFakture = datumFakture;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public Date getDatumObracuna() {
		return datumObracuna;
	}

	public void setDatumObracuna(Date datumObracuna) {
		this.datumObracuna = datumObracuna;
	}

	public float getUkupnoRobe() {
		return ukupnoRobe;
	}

	public void setUkupnoRobe(float ukupnoRobe) {
		this.ukupnoRobe = ukupnoRobe;
	}

	public float getUkupanRabat() {
		return ukupanRabat;
	}

	public void setUkupanRabat(float ukupanRabat) {
		this.ukupanRabat = ukupanRabat;
	}

	public float getUkupanPorez() {
		return ukupanPorez;
	}

	public void setUkupanPorez(float ukupanPorez) {
		this.ukupanPorez = ukupanPorez;
	}

	public float getIznosFakture() {
		return iznosFakture;
	}

	public void setIznosFakture(float iznosFakture) {
		this.iznosFakture = iznosFakture;
	}

	public float getIznosFaktureOsnovica() {
		return iznosFaktureOsnovica;
	}

	public void setIznosFaktureOsnovica(float iznosFaktureOsnovica) {
		this.iznosFaktureOsnovica = iznosFaktureOsnovica;
	}

	public String getUplataNaRacun() {
		return uplataNaRacun;
	}

	public void setUplataNaRacun(String uplataNaRacun) {
		this.uplataNaRacun = uplataNaRacun;
	}

	public String getPozivNaBroj() {
		return pozivNaBroj;
	}

	public void setPozivNaBroj(String pozivNaBroj) {
		this.pozivNaBroj = pozivNaBroj;
	}

	public List<StavkeFakture> getStavkeFakture() {
		return stavkeFakture;
	}

	public void setStavkeFakture(List<StavkeFakture> stavkeFakture) {
		this.stavkeFakture = stavkeFakture;
	}

	public List<ObracunatiPorez> getObracunatiPorez() {
		return obracunatiPorez;
	}

	public void setObracunatiPorez(List<ObracunatiPorez> obracunatiPorez) {
		this.obracunatiPorez = obracunatiPorez;
	}

	public String getStatusFakture() {
		return statusFakture;
	}

	public void setStatusFakture(String statusFakture) {
		this.statusFakture = statusFakture;
	}

	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public PoslovnaGodina getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	public Otpremnica getOtpremnica() {
		return otpremnica;
	}

	public void setOtpremnica(Otpremnica otpremnica) {
		this.otpremnica = otpremnica;
	}
}
