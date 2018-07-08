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
@Table(name="grupa")
public class Grupa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grupa_id", unique = true, nullable = false)
	public int id;

	@Column(name="naziv",nullable = false)
	public String naziv;

	@ManyToOne
	@JoinColumn(name="preduzece_id",referencedColumnName="preduzece_id", nullable=false)
	public Preduzece preduzece;

	@OneToMany(mappedBy = "grupa")
	public List<RobaUsluga> robaUsluga;
	
	@ManyToOne
	@JoinColumn(name="porez_id",referencedColumnName="porez_id", nullable=false)
	public Porez porez;

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

	public Porez getPorez() {
		return porez;
	}

	public void setPorez(Porez porez) {
		this.porez = porez;
	}

	public List<RobaUsluga> getRobaUsluga() {
		return robaUsluga;
	}

	public void setRobaUsluga(List<RobaUsluga> robaUsluga) {
		this.robaUsluga = robaUsluga;
	}

}
