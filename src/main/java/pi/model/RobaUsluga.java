package pi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class RobaUsluga {
	
	@Column(nullable = false, length = 30)
	public String naziv;
	
	@Column(nullable = false, length = 10)
	public String jedinicaMere;
	
	@OneToMany(mappedBy="robaUsluga")
	public List<StavkeFakture> stavkeFakture;
	
	@OneToMany(mappedBy="robaUsluga")
	public List<StavkeCenovnika> stavkeCenovnika;
	
	@ManyToOne
	public Grupa grupa;
	
	@OneToMany(mappedBy="robaUsluga")
	public List<StavkeOtpremnice> stavkeOtpremnice;
	
	@OneToMany(mappedBy="robaUsluga")
	public List<StavkaNarudzbenice> stavkeNarudzbenice;

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