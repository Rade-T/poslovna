package pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Preduzece {
	
	@Id
	@Column(nullable = false)
	public int PIB; 
	
	@Column(length = 30, nullable = false)
	public String naziv;
	
	@Column(nullable = false, length = 50)
	public String adresa;
	
	@Column(nullable = false)
	public int maticniBroj;
	
	@Column(nullable = false)
	public int sifraDelatnosti;
	
	@Column(nullable = false)
	public int telefon;
	
	@Column(nullable = false, length = 50)
	public String email;

	public int getPIB() {
		return PIB;
	}
	
	public Preduzece() {
		
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
