package pi.dto;

import pi.model.IzlaznaFaktura;
import pi.model.Porez;

public class ObracunatiPorezDTO {
	public float stopa;
	public float iznos;
	public Porez porez;
	public IzlaznaFaktura izlaznaFaktura;
	
	public ObracunatiPorezDTO(){
		
	}

	public ObracunatiPorezDTO(ObracunatiPorezDTO dto) {
		super();
		this.stopa = stopa;
		this.iznos = iznos;
		this.porez = porez;
		this.izlaznaFaktura = izlaznaFaktura;
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
