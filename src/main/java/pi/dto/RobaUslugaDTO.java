package pi.dto;

import pi.model.Grupa;
import pi.model.RobaUsluga;

public class RobaUslugaDTO {
	private int id;
	public String naziv;
	public String jedinicaMere;
//	public List<StavkeFakture> stavkeFakture;
//	public List<StavkeCenovnika> stavkeCenovnika;
	public int idGrupa;
//	public List<StavkeOtpremnice> stavkeOtpremnice;
//	public List<StavkaNarudzbenice> stavkeNarudzbenice;
	
	public RobaUslugaDTO(){
		
	}

	public RobaUslugaDTO(RobaUsluga dto) {
		super();
		this.id = dto.getId();
		this.naziv = dto.getNaziv();
		this.jedinicaMere = dto.getJedinicaMere();
		this.idGrupa = dto.getGrupa().getId();
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public int getGrupa() {
		return idGrupa;
	}

	public void setGrupa(int grupa) {
		this.idGrupa = grupa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
