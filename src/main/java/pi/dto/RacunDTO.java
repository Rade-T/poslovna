package pi.dto;

import pi.model.Preduzece;
import pi.model.Racun;

public class RacunDTO {
	public int id;
	public String banka;
	public int preduzece;

	public RacunDTO() {

	}

	public RacunDTO(Racun dto) {
		super();
		this.id = dto.getId();
		this.banka = dto.getBanka();
		this.preduzece = dto.getPreduzece().getPIB();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBanka() {
		return banka;
	}

	public void setBanka(String banka) {
		this.banka = banka;
	}

	public int getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(int preduzece) {
		this.preduzece = preduzece;
	}

}
