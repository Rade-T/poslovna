package pi.dto;

import pi.model.Narudzbenica;

public class NarudzbenicaDTO {
	public int id;
	public float kolicina;
	/*public PoslovnaGodina poslovnaGodina;
	public list <Otpremnica> otpremnica;
	public list <StavkeNarudzbenice> stavkeNarudzbenice;*/
	
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

	
	
	

}
