package pi.dto;

import pi.model.PoreskaStopa;

public class PoreskaStopaDTO {
	
	public int id;
	public float iznosStope;
	public int istorijaPoreza;
	public int porez;
	
	public PoreskaStopaDTO() {
		super();
	}

	public PoreskaStopaDTO(PoreskaStopa dto) {
		super();
		this.id = dto.getId();
		this.iznosStope = dto.getIznosStope();
		this.istorijaPoreza = dto.getIstorijaPoreza().getId();
		this.porez = dto.getPorez().getId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getIznosStope() {
		return iznosStope;
	}

	public void setIznosStope(float iznosStope) {
		this.iznosStope = iznosStope;
	}

	public int getIstorijaPoreza() {
		return istorijaPoreza;
	}

	public void setIstorijaPoreza(int istorijaPoreza) {
		this.istorijaPoreza = istorijaPoreza;
	}

	public int getPorez() {
		return porez;
	}

	public void setPorez(int porez) {
		this.porez = porez;
	}
}
