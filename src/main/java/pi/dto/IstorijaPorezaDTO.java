package pi.dto;

import java.util.Date;

import pi.model.IstorijaPoreza;
import pi.model.Preduzece;

public class IstorijaPorezaDTO {
	
	public int id;
	public Date datumPrimene;
	public Preduzece preduzece;
	//public List<PoreskaStopa> poreskaStopa;
	
	public IstorijaPorezaDTO() {
		super();
		
	}

	public IstorijaPorezaDTO(IstorijaPoreza dto) {
		super();
		this.id = dto.id;
		this.datumPrimene = dto.datumPrimene;
		this.preduzece = dto.preduzece;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatumPrimene() {
		return datumPrimene;
	}

	public void setDatumPrimene(Date datumPrimene) {
		this.datumPrimene = datumPrimene;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}
	
	
	
	
	
	
	
}
