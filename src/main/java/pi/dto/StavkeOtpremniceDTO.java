package pi.dto;

import pi.model.StavkeOtpremnice;

public class StavkeOtpremniceDTO {
	public float kolicina;
	public float cenaPoJediniciMere;
	public float ukupnaCena;
	public int optremnica;
	public int robaUsluga;

	public StavkeOtpremniceDTO() {

	}

	public StavkeOtpremniceDTO(StavkeOtpremnice dto) {
		super();
		this.kolicina = dto.getKolicina();
		this.cenaPoJediniciMere = dto.getCenaPoJediniciMere();
		this.ukupnaCena = dto.getUkupnaCena();
		this.optremnica = dto.getOtpremnica().getBrojOtpremnice();
		this.robaUsluga = dto.getRobaUsluga().getId();
	}

	public float getKolicina() {
		return kolicina;
	}

	public void setKolicina(float kolicina) {
		this.kolicina = kolicina;
	}

	public float getCenaPoJediniciMere() {
		return cenaPoJediniciMere;
	}

	public void setCenaPoJediniciMere(float cenaPoJediniciMere) {
		this.cenaPoJediniciMere = cenaPoJediniciMere;
	}

	public float getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(float ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public int getOptremnica() {
		return optremnica;
	}

	public void setOptremnica(int optremnica) {
		this.optremnica = optremnica;
	}

	public int getRobaUsluga() {
		return robaUsluga;
	}

	public void setRobaUsluga(int robaUsluga) {
		this.robaUsluga = robaUsluga;
	}

}
