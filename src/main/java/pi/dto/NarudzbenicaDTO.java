package pi.dto;

import java.util.List;

import pi.model.Narudzbenica;
import pi.model.Otpremnica;
import pi.model.PoslovnaGodina;
import pi.model.StavkaNarudzbenice;

public class NarudzbenicaDTO {
	public int id;
	public float kolicina;
	public PoslovnaGodina poslovnaGodina;
	public List<Otpremnica> otpremnica;
	public List<StavkaNarudzbenice> stavkeNarudzbenice;

	public NarudzbenicaDTO(){
		
	}
	
	public NarudzbenicaDTO(Narudzbenica dto) {
		super();
		this.id = dto.id;
		this.kolicina = dto.kolicina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getKolicina() {
		return kolicina;
	}

	public void setKolicina(float kolicina) {
		this.kolicina = kolicina;
	}

	public PoslovnaGodina getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	public List<Otpremnica> getOtpremnica() {
		return otpremnica;
	}

	public void setOtpremnica(List<Otpremnica> otpremnica) {
		this.otpremnica = otpremnica;
	}

	public List<StavkaNarudzbenice> getStavkeNarudzbenice() {
		return stavkeNarudzbenice;
	}

	public void setStavkeNarudzbenice(List<StavkaNarudzbenice> stavkeNarudzbenice) {
		this.stavkeNarudzbenice = stavkeNarudzbenice;
	}
	
	

	
	
	

}
