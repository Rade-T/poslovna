package pi.dto;

import pi.model.IzlaznaFaktura;
import pi.model.RobaUsluga;
import pi.model.StavkeFakture;

public class StavkeFaktureDTO {
	public float kolicina;
	public float cenaPoJediniciMere;
	public float rabat;
	public float osnovica;
	public float pdvIznos;
	public float ukupanIznos;
	public float pdv;
	public IzlaznaFaktura izlaznaFaktura;
	public RobaUsluga robaUsluga;
	
	public StavkeFaktureDTO(){
		
	}

	public StavkeFaktureDTO(StavkeFakture dto) {
		super();
		this.kolicina = kolicina;
		this.cenaPoJediniciMere = cenaPoJediniciMere;
		this.rabat = rabat;
		this.osnovica = osnovica;
		this.pdvIznos = pdvIznos;
		this.ukupanIznos = ukupanIznos;
		this.pdv = pdv;
		this.izlaznaFaktura = izlaznaFaktura;
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

	public float getRabat() {
		return rabat;
	}

	public void setRabat(float rabat) {
		this.rabat = rabat;
	}

	public float getOsnovica() {
		return osnovica;
	}

	public void setOsnovica(float osnovica) {
		this.osnovica = osnovica;
	}

	public float getPdvIznos() {
		return pdvIznos;
	}

	public void setPdvIznos(float pdvIznos) {
		this.pdvIznos = pdvIznos;
	}

	public float getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(float ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}

	public float getPdv() {
		return pdv;
	}

	public void setPdv(float pdv) {
		this.pdv = pdv;
	}

	public IzlaznaFaktura getIzlaznaFaktura() {
		return izlaznaFaktura;
	}

	public void setIzlaznaFaktura(IzlaznaFaktura izlaznaFaktura) {
		this.izlaznaFaktura = izlaznaFaktura;
	}

	public RobaUsluga getRobaUsluga() {
		return robaUsluga;
	}

	public void setRobaUsluga(RobaUsluga robaUsluga) {
		this.robaUsluga = robaUsluga;
	}
	
	
	

}
