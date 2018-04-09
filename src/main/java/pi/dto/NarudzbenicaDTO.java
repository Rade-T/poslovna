package pi.dto;

import pi.model.Narudzbenica;

public class NarudzbenicaDTO {
	public int id;
	public float kolicina;
	public int poslovnaGodina;
//	public List<Integer> otpremnica;
//	public List<Integer> stavkeNarudzbenice;

	public NarudzbenicaDTO(){
		
	}
	
	public NarudzbenicaDTO(Narudzbenica dto) {
		super();
		this.id = dto.getId();
		this.kolicina = dto.getKolicina();
		this.poslovnaGodina = dto.getPoslovnaGodina().getId();
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

	public int getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(int poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

}
