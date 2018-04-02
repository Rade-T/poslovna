package pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ObracunatiPorez {

	@Column(nullable = false, precision = 5, scale = 2)
	public float stopa;

	@Column(nullable = false, precision = 15, scale = 2)
	public float iznos;

	@ManyToOne
	public Porez porez;

	@ManyToOne
	public IzlaznaFaktura izlaznaFaktura;

	public float getStopa() {
		return stopa;
	}

	public void setStopa(float stopa) {
		this.stopa = stopa;
	}

	public float getIznos() {
		return iznos;
	}

	public void setIznos(float iznos) {
		this.iznos = iznos;
	}

	public Porez getPorez() {
		return porez;
	}

	public void setPorez(Porez porez) {
		this.porez = porez;
	}

	public IzlaznaFaktura getIzlaznaFaktura() {
		return izlaznaFaktura;
	}

	public void setIzlaznaFaktura(IzlaznaFaktura izlaznaFaktura) {
		this.izlaznaFaktura = izlaznaFaktura;
	}
}
