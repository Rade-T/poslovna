package pi.dto;

import pi.model.StavkaNarudzbenice;

public class StavkaNarudzebniceDTO {
	private int id;
	public float kolicina;
	public float cenaPoJediniciMere;
	public float ukupnaCena;
	public int robaUsluga;
	public int narudzbenica;
	
	public StavkaNarudzebniceDTO(){
		
	}

	public StavkaNarudzebniceDTO(StavkaNarudzbenice dto) {
		super();
		this.id = dto.getId();
		this.kolicina = dto.getKolicina();
		this.cenaPoJediniciMere = dto.getCenaPoJediniciMere();
		this.ukupnaCena = dto.getUkupnaCena();
		this.robaUsluga = dto.getRobaUsluga().getId();
		this.narudzbenica = dto.getNarudzbenica().getId();
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

	public int getRobaUsluga() {
		return robaUsluga;
	}

	public void setRobaUsluga(int robaUsluga) {
		this.robaUsluga = robaUsluga;
	}

	public int getNarudzbenica() {
		return narudzbenica;
	}

	public void setNarudzbenica(int narudzbenica) {
		this.narudzbenica = narudzbenica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
