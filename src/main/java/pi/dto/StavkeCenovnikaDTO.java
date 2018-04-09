package pi.dto;

import pi.model.StavkeCenovnika;

public class StavkeCenovnikaDTO {

	public int Id;

	public float jedinicnaCena;

	public int cenovnik;

	public StavkeCenovnikaDTO() {

	}

	public StavkeCenovnikaDTO(StavkeCenovnika dto) {
		super();
		this.Id = dto.getId();
		this.jedinicnaCena = dto.getJedinicnaCena();
		this.cenovnik = dto.getCenovnik().getId();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public float getJedinicnaCena() {
		return jedinicnaCena;
	}

	public void setJedinicnaCena(float jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}

	public int getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(int cenovnik) {
		this.cenovnik = cenovnik;
	}

}
