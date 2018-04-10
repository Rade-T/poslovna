package pi.dto;

import pi.model.Porez;

public class PorezDTO {
	public int id;
	public String nazivPoreza;
	public boolean vazeci;

	public PorezDTO() {

	}

	public PorezDTO(Porez dto) {
		super();
		this.id = dto.getId();
		this.nazivPoreza = dto.getNazivPoreza();
		this.vazeci = dto.isVazeci();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazivPoreza() {
		return nazivPoreza;
	}

	public void setNazivPoreza(String nazivPoreza) {
		this.nazivPoreza = nazivPoreza;
	}

	public boolean isVazeci() {
		return vazeci;
	}

	public void setVazeci(boolean vazeci) {
		this.vazeci = vazeci;
	}
	
	

}
