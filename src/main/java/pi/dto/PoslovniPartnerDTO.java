package pi.dto;

import pi.model.PoslovniPartner;

public class PoslovniPartnerDTO {
	public int id;
	public String nazivPartnera;
	public String adresa;
	public String vrstaPartnera;
//	public List<IzlaznaFaktura> izlaznaFaktura;
	public int preduzece;
//	public List<Otpremnica> otpremnica;
//	public List<Narudzbenica> narudzbenica;

	public PoslovniPartnerDTO() {

	}

	public PoslovniPartnerDTO(PoslovniPartner dto) {
		super();
		this.id = dto.getId();
		this.nazivPartnera = dto.getNazivPartnera();
		this.adresa = dto.getAdresa();
		this.vrstaPartnera = dto.getVrstaPartnera();
		this.preduzece = dto.getPreduzece().getPIB();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(int preduzece) {
		this.preduzece = preduzece;
	}

}
