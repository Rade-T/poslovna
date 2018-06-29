package pi.dto;

import pi.model.Racun;

public class RacunDTO {
	public int id;
	public String banka;
	public int preduzece_pib;

	public RacunDTO() {
		super();
	}

	public RacunDTO(Racun dto) {
		super();
		this.id = dto.getId();
		this.banka = dto.getBanka();
		this.preduzece_pib = dto.getPreduzece().getPIB();
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

	public int getPreduzece_pib() {
		return preduzece_pib;
	}

	public void setPreduzece_pib(int preduzece) {
		this.preduzece_pib = preduzece;
	}

}
