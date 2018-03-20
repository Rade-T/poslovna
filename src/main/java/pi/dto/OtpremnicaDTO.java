package pi.dto;

import java.util.Date;

import pi.model.Otpremnica;

public class OtpremnicaDTO {
	
	public int brojOtpremnice;
	
	
	public Date datumOtpremnice;


	public float osnovica;
	

	public float ukupanPdv;
	

	public float iznosZaPlacanje;


	public OtpremnicaDTO() {
		
	}

	public OtpremnicaDTO(Otpremnica dto) {
		super();
		this.brojOtpremnice = dto.getBrojOtpremnice();
		this.datumOtpremnice = dto.getDatumOtpremnice();
		this.osnovica = dto.getOsnovica();
		this.ukupanPdv = dto.getUkupanPdv();
		this.iznosZaPlacanje = dto.getIznosZaPlacanje();
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
