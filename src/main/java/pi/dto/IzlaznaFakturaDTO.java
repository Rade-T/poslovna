package pi.dto;

import java.util.Date;
import java.util.List;

import pi.model.ObracunatiPorez;
import pi.model.Otpremnica;
import pi.model.PoslovnaGodina;
import pi.model.PoslovniPartner;
import pi.model.StavkeFakture;

public class IzlaznaFakturaDTO {
	public int brojFakture;
	public Date datumFakture;
	public Date datumValute;
	public Date datumObracuna;
	public float ukupnoRobe;
	public float ukupanRabat;
	public float ukupanPorez;
	public float iznosFakture;
	public float iznosFaktureOsnovica;
	public String uplataNaRacun;
	public String pozivNaBroj;
	public List<StavkeFakture> stavkeFakture;
	public List<ObracunatiPorez> obracunatiPorez;
	public String statusFakture;
	public PoslovniPartner poslovniPartner;
	public PoslovnaGodina poslovnaGodina;
	public Otpremnica otpremnica;
	
	public IzlaznaFakturaDTO(){
		
	}

	public IzlaznaFakturaDTO(IzlaznaFakturaDTO dto) {
		super();
		this.brojFakture = brojFakture;
		this.datumFakture = datumFakture;
		this.datumValute = datumValute;
		this.datumObracuna = datumObracuna;
		this.ukupnoRobe = ukupnoRobe;
		this.ukupanRabat = ukupanRabat;
		this.ukupanPorez = ukupanPorez;
		this.iznosFakture = iznosFakture;
		this.iznosFaktureOsnovica = iznosFaktureOsnovica;
		this.uplataNaRacun = uplataNaRacun;
		this.pozivNaBroj = pozivNaBroj;
		this.stavkeFakture = stavkeFakture;
		this.obracunatiPorez = obracunatiPorez;
		this.statusFakture = statusFakture;
		this.poslovniPartner = poslovniPartner;
		this.poslovnaGodina = poslovnaGodina;
		this.otpremnica = otpremnica;
	}

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
