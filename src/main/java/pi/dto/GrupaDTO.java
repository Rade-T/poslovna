package pi.dto;

import pi.model.Grupa;
import pi.model.Porez;
import pi.model.Preduzece;

public class GrupaDTO {
	
	public int id;
	public String naziv;
	public Preduzece preduzece;
	//public List<RobaUsluga> robaUsluga;
	public Porez porez;
	
	public GrupaDTO() {
		super();
	}

	public GrupaDTO(Grupa dto) {
		super();
		this.id = dto.id;
		this.naziv = dto.naziv;
		this.preduzece = dto.preduzece;
		this.porez = dto.porez;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	public Porez getPorez() {
		return porez;
	}

	public void setPorez(Porez porez) {
		this.porez = porez;
	}
	
	
	
	
}
