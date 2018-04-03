package pi.dto;

import java.util.List;

import pi.model.Grupa;
import pi.model.StavkaNarudzbenice;
import pi.model.StavkeCenovnika;
import pi.model.StavkeFakture;
import pi.model.StavkeOtpremnice;

public class RobaUslugaDTO {
	public String naziv;
	public String jedinicaMere;
	public List<StavkeFakture> stavkeFakture;
	public List<StavkeCenovnika> stavkeCenovnika;
	public Grupa grupa;
	public List<StavkeOtpremnice> stavkeOtpremnice;
	public List<StavkaNarudzbenice> stavkeNarudzbenice;
	
	public RobaUslugaDTO(){
		
	}

	public RobaUslugaDTO(RobaUslugaDTO dto) {
		super();
		this.naziv = naziv;
		this.jedinicaMere = jedinicaMere;
		this.stavkeFakture = stavkeFakture;
		this.stavkeCenovnika = stavkeCenovnika;
		this.grupa = grupa;
		this.stavkeOtpremnice = stavkeOtpremnice;
		this.stavkeNarudzbenice = stavkeNarudzbenice;
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

	public List<StavkeFakture> getStavkeFakture() {
		return stavkeFakture;
	}

	public void setStavkeFakture(List<StavkeFakture> stavkeFakture) {
		this.stavkeFakture = stavkeFakture;
	}

	public List<StavkeCenovnika> getStavkeCenovnika() {
		return stavkeCenovnika;
	}

	public void setStavkeCenovnika(List<StavkeCenovnika> stavkeCenovnika) {
		this.stavkeCenovnika = stavkeCenovnika;
	}

	public Grupa getGrupa() {
		return grupa;
	}

	public void setGrupa(Grupa grupa) {
		this.grupa = grupa;
	}

	public List<StavkeOtpremnice> getStavkeOtpremnice() {
		return stavkeOtpremnice;
	}

	public void setStavkeOtpremnice(List<StavkeOtpremnice> stavkeOtpremnice) {
		this.stavkeOtpremnice = stavkeOtpremnice;
	}

	public List<StavkaNarudzbenice> getStavkeNarudzbenice() {
		return stavkeNarudzbenice;
	}

	public void setStavkeNarudzbenice(List<StavkaNarudzbenice> stavkeNarudzbenice) {
		this.stavkeNarudzbenice = stavkeNarudzbenice;
	}
	
	
	
	

}
