package pi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import antlr.collections.List;

@Entity
public class IstorijaPoreza {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="istorijaPoreza_id", unique=true, nullable=false)
	public int id;
	
	@Column(unique=false)
	public Date datumPrimene;
	
	@ManyToOne
	public Preduzece preduzece;
	
	//@OneToMany(mappedBy="istorijaPoreza")
	//public List<PoreskaStopa> poreskaStopa;
		

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
}
