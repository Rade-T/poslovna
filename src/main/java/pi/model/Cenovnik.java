package pi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cenovnik {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cenovnik_id", unique = true, nullable = false)
	public int Id;

	@Column(unique = false)
	public Date datumPrimene;

	@ManyToOne
	public Preduzece preduzece;

	@OneToMany(mappedBy = "cenovnik")
	public List<StavkeCenovnika> stavkeCenovnika;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getDatumPrimene() {
		return datumPrimene;
	}

	public void setDatumPrimene(Date datumPrimene) {
		this.datumPrimene = datumPrimene;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	public List<StavkeCenovnika> getStavkeCenovnika() {
		return stavkeCenovnika;
	}

	public void setStavkeCenovnika(List<StavkeCenovnika> stavkeCenovnika) {
		this.stavkeCenovnika = stavkeCenovnika;
	}

}
