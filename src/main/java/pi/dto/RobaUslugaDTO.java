package pi.dto;

import pi.model.RobaUsluga;

public class RobaUslugaDTO {
	public String naziv;
	public String jedinicaMere;
//	public List<StavkeFakture> stavkeFakture;
//	public List<StavkeCenovnika> stavkeCenovnika;
	public int grupa;
//	public List<StavkeOtpremnice> stavkeOtpremnice;
//	public List<StavkaNarudzbenice> stavkeNarudzbenice;
	
	public RobaUslugaDTO(){
		
	}

	public RobaUslugaDTO(RobaUsluga dto) {
		super();
		this.naziv = dto.getNaziv();
		this.jedinicaMere = dto.getJedinicaMere();
		this.grupa = dto.getGrupa().getId();
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
		return grupa;
	}

	public void setGrupa(int grupa) {
		this.grupa = grupa;
	}

}
