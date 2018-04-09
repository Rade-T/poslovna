package pi.dto;

import java.util.List;

import pi.model.IzlaznaFaktura;
import pi.model.Narudzbenica;
import pi.model.Otpremnica;
import pi.model.Preduzece;

public class PoslovniPartnerDTO {
	public String nazivPartnera;
	public String adresa;
	public String vrstaPartnera;
	public List<IzlaznaFaktura> izlaznaFaktura;
	public Preduzece preduzece;
	public List<Otpremnica> otpremnica;
	public List<Narudzbenica> narudzbenica;
	
	public PoslovniPartnerDTO(){
		
	}

	public PoslovniPartnerDTO(PoslovniPartnerDTO dto) {
		super();
		this.nazivPartnera = nazivPartnera;
		this.adresa = adresa;
		this.vrstaPartnera = vrstaPartnera;
		this.izlaznaFaktura = izlaznaFaktura;
		this.preduzece = preduzece;
		this.otpremnica = otpremnica;
		this.narudzbenica = narudzbenica;
	}

	public String getNazivPartnera() {
		return nazivPartnera;
	}

	public void setNazivPartnera(String nazivPartnera) {
		this.nazivPartnera = nazivPartnera;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getVrstaPartnera() {
		return vrstaPartnera;
	}

	public void setVrstaPartnera(String vrstaPartnera) {
		this.vrstaPartnera = vrstaPartnera;
	}

	public List<IzlaznaFaktura> getIzlaznaFaktura() {
		return izlaznaFaktura;
	}

	public void setIzlaznaFaktura(List<IzlaznaFaktura> izlaznaFaktura) {
		this.izlaznaFaktura = izlaznaFaktura;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	public List<Otpremnica> getOtpremnica() {
		return otpremnica;
	}

	public void setOtpremnica(List<Otpremnica> otpremnica) {
		this.otpremnica = otpremnica;
	}

	public List<Narudzbenica> getNarudzbenica() {
		return narudzbenica;
	}

	public void setNarudzbenica(List<Narudzbenica> narudzbenica) {
		this.narudzbenica = narudzbenica;
	}
	
	
	
	

}
