package pi.dto;

import static org.mockito.Mockito.doNothing;

import java.util.Date;
import java.util.List;

import pi.model.IstorijaPoreza;
import pi.model.PoreskaStopa;

public class IstorijaPorezaDTO {
	
	public int id;
	public Date datumPrimene;
	public int preduzece;
	public List<Integer> poreskaStopa;
	
	public IstorijaPorezaDTO() {
		super();
		
	}

	public IstorijaPorezaDTO(IstorijaPoreza dto) {
		super();
		this.id = dto.id;
		this.datumPrimene = dto.datumPrimene;
		this.preduzece = dto.preduzece.getPIB();
		for (PoreskaStopa ps : dto.getPoreskaStopa()) {
			this.poreskaStopa.add(ps.getId());
		}
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

	public int getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(int preduzece) {
		this.preduzece = preduzece;
	}
	
	
	
	
	
	
	
}
