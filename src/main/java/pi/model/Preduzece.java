package pi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="preduzece")
public class Preduzece {
	
	@Id
	@Column(name="preduzece_id", nullable = false)
	public int PIB; 
	
	@Column(name="naziv",length = 30, nullable = false)
	public String naziv;
	
	@Column(name="adresa",nullable = false, length = 50)
	public String adresa;
	
	@Column(name="maticniBroj",nullable = false)
	public int maticniBroj;
	
	@Column(name="sifraDelatnosti",nullable = false)
	public int sifraDelatnosti;
	
	@Column(name="telefon",nullable = false)
	public int telefon;
	
	@Column(name="email", nullable = false, length = 50)
	public String email;
	
	@OneToMany(mappedBy="preduzece")
	public List<PoslovniPartner> poslovniPartner;
	
	@OneToMany(mappedBy="preduzece")
	public List<PoslovnaGodina> poslovnaGodina;
	
	@OneToMany(mappedBy="preduzece")
	public List<Racun> racun;
	
	@OneToMany(mappedBy="preduzece")
	public List<Cenovnik> cenovnik;
	
	@OneToMany(mappedBy="preduzece")
	public List<Grupa> grupa;
	
	@OneToMany(mappedBy="preduzece")
	public List<IstorijaPoreza> istorijaPoreza;

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

	public List<PoslovniPartner> getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(List<PoslovniPartner> poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public List<PoslovnaGodina> getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(List<PoslovnaGodina> poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	public List<Racun> getRacun() {
		return racun;
	}

	public void setRacun(List<Racun> racun) {
		this.racun = racun;
	}

	public List<Cenovnik> getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(List<Cenovnik> cenovnik) {
		this.cenovnik = cenovnik;
	}

	public List<Grupa> getGrupa() {
		return grupa;
	}

	public void setGrupa(List<Grupa> grupa) {
		this.grupa = grupa;
	}

	public List<IstorijaPoreza> getIstorijaPoreza() {
		return istorijaPoreza;
	}

	public void setIstorijaPoreza(List<IstorijaPoreza> istorijaPoreza) {
		this.istorijaPoreza = istorijaPoreza;
	}
	
}
