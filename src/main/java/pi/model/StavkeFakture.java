package pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StavkeFakture {
	
	@Id
	@Column
	private int id;
	
	@Column(nullable = true)
	public float kolicina;
	
	@Column(nullable = true)
	public float cenaPoJediniciMere;
	
	@Column(nullable = true)
	public float rabat;
	
	@Column(nullable = true, precision = 15, scale = 2)
	public float osnovica;
	
	@Column(nullable = true)
	public float pdvIznos; 
	
	@Column(nullable = true)
	public float ukupanIznos;
	
	@Column(nullable = true)
	public float pdv;
	
	@ManyToOne
	public IzlaznaFaktura izlaznaFaktura;
	
	@ManyToOne
	public RobaUsluga robaUsluga;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
