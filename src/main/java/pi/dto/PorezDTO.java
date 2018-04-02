package pi.dto;

import pi.model.Porez;

public class PorezDTO {
	public int id;
	public String nazivPoreza;
	public boolean vazeci;
	
	
	public PorezDTO(){
		
	}


	public PorezDTO(Porez dto) {
		super();
		this.id = dto.id;
		this.nazivPoreza = dto.nazivPoreza;
		this.vazeci = dto.vazeci;
	}
	
	

}
