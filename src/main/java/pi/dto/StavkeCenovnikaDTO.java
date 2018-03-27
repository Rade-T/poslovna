package pi.dto;

import pi.model.Cenovnik;

public class StavkeCenovnikaDTO {
	
	public int Id;	
	
	public float jedinicnaCena;
	
	public Cenovnik cenovnik;
	
	public StavkeCenovnikaDTO(){
		
	}
	
	public StavkeCenovnikaDTO(StavkeCenovnikaDTO dto) {
		super();
		this.Id = dto.getId();
		this.jedinicnaCena = dto.getJedinicnaCena();
		this.cenovnik = dto.getCenovnik();
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

	public Cenovnik getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}
	
	

}