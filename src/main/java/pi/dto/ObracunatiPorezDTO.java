package pi.dto;

import pi.model.ObracunatiPorez;

public class ObracunatiPorezDTO {
	public float stopa;
	public float iznos;
	public int porez;
	public int izlaznaFaktura;

	public ObracunatiPorezDTO() {

	}

	public ObracunatiPorezDTO(ObracunatiPorez dto) {
		super();
		this.stopa = dto.getStopa();
		this.iznos = dto.getIznos();
		this.porez = dto.getPorez().getId();
		this.izlaznaFaktura = dto.getIzlaznaFaktura().getBrojFakture();
	}

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

	public int getPorez() {
		return porez;
	}

	public void setPorez(int porez) {
		this.porez = porez;
	}

	public int getIzlaznaFaktura() {
		return izlaznaFaktura;
	}

	public void setIzlaznaFaktura(int izlaznaFaktura) {
		this.izlaznaFaktura = izlaznaFaktura;
	}

}
