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

}
