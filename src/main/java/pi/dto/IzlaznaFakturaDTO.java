package pi.dto;

import java.util.Date;

import pi.model.IzlaznaFaktura;

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
	public String statusFakture;
	public int poslovniPartner;
	public int poslovnaGodina;
	public int otpremnica;

	public IzlaznaFakturaDTO() {

	}

	public IzlaznaFakturaDTO(IzlaznaFaktura dto) {
		super();
		this.brojFakture = dto.getBrojFakture();
		this.datumFakture = dto.getDatumFakture();
		this.datumValute = dto.getDatumValute();
		this.datumObracuna = dto.getDatumObracuna();
		this.ukupnoRobe = dto.getUkupnoRobe();
		this.ukupanRabat = dto.getUkupanRabat();
		this.ukupanPorez = dto.getUkupanPorez();
		this.iznosFakture = dto.getIznosFakture();
		this.iznosFaktureOsnovica = dto.getIznosFaktureOsnovica();
		this.uplataNaRacun = dto.getUplataNaRacun();
		this.pozivNaBroj = dto.getPozivNaBroj();
		this.statusFakture = dto.getStatusFakture();
		this.poslovniPartner = dto.getPoslovniPartner().getId();
		this.poslovnaGodina = dto.getPoslovnaGodina().getId();
		this.otpremnica = dto.getOtpremnica().getBrojOtpremnice();
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

	public String getStatusFakture() {
		return statusFakture;
	}

	public void setStatusFakture(String statusFakture) {
		this.statusFakture = statusFakture;
	}

	public int getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(int poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public int getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(int poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	public int getOtpremnica() {
		return otpremnica;
	}

	public void setOtpremnica(int otpremnica) {
		this.otpremnica = otpremnica;
	}

}
