package pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Grupa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="grupa_id", unique=true, nullable=false)
	public int id;
	
	@Column(nullable=false)
	public String naziv;
	
	@ManyToOne
	public Preduzece preduzece;
	
	//@OneToMany(mappedBy="grupa")
	//public List<RobaUsluga> robaUsluga;
	//@ManyToOne
	//public Porez porez;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}
	
}
