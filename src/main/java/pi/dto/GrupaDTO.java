package pi.dto;

import pi.model.Grupa;

public class GrupaDTO {
	
	public int id;
	public String naziv;
	public int preduzece;
	//public List<RobaUsluga> robaUsluga;
	public int porez;
	
	public GrupaDTO() {
		super();
	}

	public GrupaDTO(Grupa dto) {
		super();
		this.id = dto.getId();
		this.naziv = dto.getNaziv();
		this.preduzece = dto.getPreduzece().getPIB();
		this.porez = dto.getPorez().getId();
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

	public int getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(int preduzece) {
		this.preduzece = preduzece;
	}

	public int getPorez() {
		return porez;
	}

	public void setPorez(int porez) {
		this.porez = porez;
	}
}
