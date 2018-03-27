package pi.dto;

import java.util.Date;

import pi.model.Cenovnik;
import pi.model.Preduzece;

public class CenovnikDTO {
	
	public int Id;
	
	public Date datumPrimene;	

	public Preduzece preduzece;
	
	public CenovnikDTO(){
		
	}
	
	public CenovnikDTO(Cenovnik dto) {
		super();
		this.Id = dto.getId();
		this.datumPrimene = dto.getDatumPrimene();
		this.preduzece = dto.getPreduzece();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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
