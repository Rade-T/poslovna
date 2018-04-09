package pi.dto;

import pi.model.IstorijaPoreza;
import pi.model.PoreskaStopa;
import pi.model.Porez;

public class PoreskaStopaDTO {
	
	public int id;
	public float iznosStope;
	public IstorijaPoreza istorijaPoreza;
	public Porez porez;
	
	public PoreskaStopaDTO() {
		super();
	}

	public PoreskaStopaDTO(PoreskaStopa dto) {
		super();
		this.id = dto.id;
		this.iznosStope = dto.iznosStope;
		this.istorijaPoreza = dto.istorijaPoreza;
		this.porez = dto.porez;
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

	public IstorijaPoreza getIstorijaPoreza() {
		return istorijaPoreza;
	}

	public void setIstorijaPoreza(IstorijaPoreza istorijaPoreza) {
		this.istorijaPoreza = istorijaPoreza;
	}

	public Porez getPorez() {
		return porez;
	}

	public void setPorez(Porez porez) {
		this.porez = porez;
	}

	public static void add(PoreskaStopaDTO poreskaStopaDTO) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
