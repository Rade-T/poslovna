package pi.dto;

import pi.model.Preduzece;

public class PreduzeceDTO {
	
	public int PIB; 
	
	public String naziv;
	
	public String adresa;
	
	public int maticniBroj;
	
	public int sifraDelatnosti;
	
	public int telefon;
	
	public String email;
	
	public PreduzeceDTO() {
		
	}

	public PreduzeceDTO(Preduzece dto) {
		this.PIB = dto.getPIB();
		this.naziv = dto.getNaziv();
		this.adresa = dto.getAdresa();
		this.maticniBroj = dto.getMaticniBroj();
		this.sifraDelatnosti = dto.getSifraDelatnosti();
		this.telefon = dto.getTelefon();
		this.email = dto.getEmail();
	}
	
	public int getPIB() {
		return PIB;
	}

	public void setPIB(int pIB) {
		PIB = pIB;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getMaticniBroj() {
		return maticniBroj;
	}

	public void setMaticniBroj(int maticniBroj) {
		this.maticniBroj = maticniBroj;
	}

	public int getSifraDelatnosti() {
		return sifraDelatnosti;
	}

	public void setSifraDelatnosti(int sifraDelatnosti) {
		this.sifraDelatnosti = sifraDelatnosti;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
//	@OneToMany(mappedBy="preduzece")
//	public List<PoslovniPartner> poslovniPartner;
//	
//	@OneToMany(mappedBy="preduzece")
//	public List<PoslovnaGodina> poslovnaGodina;
//	
//	@OneToMany(mappedBy="preduzece")
//	public List<Racun> racun;
//	
//	@OneToMany(mappedBy="preduzece")
//	public List<Cenovnik> cenovnik;
//	
//	@OneToMany(mappedBy="preduzece")
//	public List<Grupa> grupa;
//	
//	@OneToMany(mappedBy="preduzece")
//	public List<IstorijaPoreza> istorijaPoreza;
}
