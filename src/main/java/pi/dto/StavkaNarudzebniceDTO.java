package pi.dto;

import pi.model.Narudzbenica;
import pi.model.RobaUsluga;
import pi.model.StavkaNarudzbenice;

public class StavkaNarudzebniceDTO {
	public float kolicina;
	public float cenaPoJediniciMere;
	public float ukupnaCena;
	public RobaUsluga robaUsluga;
	public Narudzbenica narudzbenica;
	
	public StavkaNarudzebniceDTO(){
		
	}

	public StavkaNarudzebniceDTO(StavkaNarudzbenice dto) {
		super();
		this.kolicina = kolicina;
		this.cenaPoJediniciMere = cenaPoJediniciMere;
		this.ukupnaCena = ukupnaCena;
		this.robaUsluga = robaUsluga;
		this.narudzbenica = narudzbenica;
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

	public RobaUsluga getRobaUsluga() {
		return robaUsluga;
	}

	public void setRobaUsluga(RobaUsluga robaUsluga) {
		this.robaUsluga = robaUsluga;
	}

	public Narudzbenica getNarudzbenica() {
		return narudzbenica;
	}

	public void setNarudzbenica(Narudzbenica narudzbenica) {
		this.narudzbenica = narudzbenica;
	}
	
	
	
	

}
