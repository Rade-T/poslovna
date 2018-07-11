package pi.dto;

import pi.model.StavkeFakture;

public class StavkeFaktureDTO {
	public int id;
	public float kolicina;
	public float cenaPoJediniciMere;
	public float rabat;
	public float osnovica;
	public float pdvIznos;
	public float ukupanIznos;
	public float pdv;
	public int izlaznaFaktura;
	public int robaUsluga;

	public StavkeFaktureDTO() {

	}

	public StavkeFaktureDTO(StavkeFakture dto) {
		super();
		this.id = dto.getId();
		this.kolicina = dto.getKolicina();
		this.cenaPoJediniciMere = dto.getCenaPoJediniciMere();
		this.rabat = dto.getRabat();
		this.osnovica = dto.getOsnovica();
		this.pdvIznos = dto.getPdvIznos();
		this.ukupanIznos = dto.getUkupanIznos();
		this.pdv = dto.getPdv();
		this.izlaznaFaktura = dto.getIzlaznaFaktura().getBrojFakture();
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

	public int getIzlaznaFaktura() {
		return izlaznaFaktura;
	}

	public void setIzlaznaFaktura(int izlaznaFaktura) {
		this.izlaznaFaktura = izlaznaFaktura;
	}

	public int getRobaUsluga() {
		return robaUsluga;
	}

	public void setRobaUsluga(int robaUsluga) {
		this.robaUsluga = robaUsluga;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
