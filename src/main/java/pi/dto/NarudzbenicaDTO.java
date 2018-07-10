package pi.dto;

import pi.model.Narudzbenica;

public class NarudzbenicaDTO {
	public int id;
	public float kolicina;
	public int poslovnaGodina;
	public int poslovniPartner;
//	public List<Integer> otpremnica;
//	public List<Integer> ;

	public NarudzbenicaDTO(){
		
	}
	
	public NarudzbenicaDTO(Narudzbenica dto) {
		super();
		this.id = dto.getId();
		this.kolicina = dto.getKolicina();
		this.poslovnaGodina = dto.getPoslovnaGodina().getId();
		this.poslovniPartner = dto.getPoslovniPartner().getId();
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

	public int getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(int poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}
	
	

}
