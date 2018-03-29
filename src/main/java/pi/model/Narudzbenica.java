package pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Narudzbenica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="narudzbenica_id", unique=true, nullable=false)
	public int id;
	
	@Column(unique=false)
	public float kolicina;
	//@ManyToOne
	//public PoslovnaGodina poslovnaGodina;
	//@ManyToOne
	//public PoslovniPartner poslovniPartner;
	//@OneToMany(mappedBy="narudzbenica")
	//public list <Otpremnica> otpremnica;
	//@OneToMany(mappedBy="narudzbenica")
	//public list <StavkaNarudzbenice> stavkeNarudzbenice;

	

	public float getKolicina() {
		return kolicina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setKolicina(float kolicina) {
		this.kolicina = kolicina;
	}
	
	
	

}
