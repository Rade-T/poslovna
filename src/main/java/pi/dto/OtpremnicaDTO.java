package pi.dto;

import java.util.Date;

import pi.model.Otpremnica;

public class OtpremnicaDTO {

	public int brojOtpremnice;

	public Date datumOtpremnice;

	public float osnovica;

	public float ukupanPDV;

	public float iznosZaPlacanje;
	
	private int poslovniPartner;
	
	private int poslovnaGodina;
	
	private int narudzbenica;

	public OtpremnicaDTO() {

	}

	public OtpremnicaDTO(Otpremnica dto) {
		super();
		this.brojOtpremnice = dto.getBrojOtpremnice();
		this.datumOtpremnice = dto.getDatumOtpremnice();
		this.osnovica = dto.getOsnovica();
		this.ukupanPDV = dto.getUkupanPdv();
		this.iznosZaPlacanje = dto.getIznosZaPlacanje();
		this.poslovnaGodina = dto.getPoslovnaGodina().getId();
		this.poslovniPartner = dto.getPoslovniPartner().getId();
		this.narudzbenica = dto.getNarudzbenica().getId();
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

	public float getUkupanPDV() {
		return ukupanPDV;
	}

	public void setUkupanPDV(float ukupanPdv) {
		this.ukupanPDV = ukupanPdv;
	}

	public float getIznosZaPlacanje() {
		return iznosZaPlacanje;
	}

	public void setIznosZaPlacanje(float iznosZaPlacanje) {
		this.iznosZaPlacanje = iznosZaPlacanje;
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

	public int getNarudzbenica() {
		return narudzbenica;
	}

	public void setNarudzbenica(int narudzbenica) {
		this.narudzbenica = narudzbenica;
	}
}
