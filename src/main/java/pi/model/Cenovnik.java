package pi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="cenovnici")
public class Cenovnik {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cenovnik_id", unique = true, nullable = false)
	public int Id;

	@Column(name="datumPrimene", unique = false)
	public Date datumPrimene;

	@ManyToOne
	@JoinColumn(name="preduzece_id", referencedColumnName="preduzece_id", nullable=false)
	public Preduzece preduzece;

	@OneToMany(cascade={ALL}, fetch=FetchType.LAZY, mappedBy="cenovnik")
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
