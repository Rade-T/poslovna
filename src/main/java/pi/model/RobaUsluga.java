package pi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="robaUsluga")
public class RobaUsluga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="robaUsluga_id",unique = true, nullable = false)
	public int Id;
	
	@Column(name="naziv",nullable = false, length = 30)
	public String naziv;
	
	@Column(name="jedinicaMere", nullable = false, length = 10)
	public String jedinicaMere;
	
	@OneToMany(mappedBy="robaUsluga")
	public List<StavkeFakture> stavkeFakture;
	
	@OneToMany(mappedBy="robaUsluga")
	public List<StavkeCenovnika> stavkeCenovnika;
	
	@ManyToOne
	@JoinColumn(name="grupa_id",referencedColumnName="grupa_id", nullable=false)
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

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
}
