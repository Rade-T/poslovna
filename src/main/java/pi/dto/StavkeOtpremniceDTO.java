package pi.dto;

import pi.model.Otpremnica;
import pi.model.RobaUsluga;

public class StavkeOtpremniceDTO {
	public float kolicina;
	public float cenaPoJediniciMere;
	public float ukupnaCena;
	public Otpremnica optremnica;
	public RobaUsluga robaUsluga;
	
	
	public StavkeOtpremniceDTO(){
		
	}


	public StavkeOtpremniceDTO(StavkeOtpremniceDTO dto) {
		super();
		this.kolicina = kolicina;
		this.cenaPoJediniciMere = cenaPoJediniciMere;
		this.ukupnaCena = ukupnaCena;
		this.optremnica = optremnica;
		this.robaUsluga = robaUsluga;
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


	public Otpremnica getOptremnica() {
		return optremnica;
	}


	public void setOptremnica(Otpremnica optremnica) {
		this.optremnica = optremnica;
	}


	public RobaUsluga getRobaUsluga() {
		return robaUsluga;
	}


	public void setRobaUsluga(RobaUsluga robaUsluga) {
		this.robaUsluga = robaUsluga;
	}
	
	
	

}
