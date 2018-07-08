package pi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name="istorijaPoreza")
public class IstorijaPoreza {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="istorijaPoreza_id", unique=true, nullable=false)
	public int id;
	
	@Column(name="datumPrimene",unique=false)
	public Date datumPrimene;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="preduzece_id",referencedColumnName="preduzece_id", nullable=false)
	public Preduzece preduzece;
	
	@OneToMany(mappedBy="istorijaPoreza", fetch=FetchType.EAGER)
	public List<PoreskaStopa> poreskaStopa;
		

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

	public List<PoreskaStopa> getPoreskaStopa() {
		return poreskaStopa;
	}

	public void setPoreskaStopa(List<PoreskaStopa> poreskaStopa) {
		this.poreskaStopa = poreskaStopa;
	}
	
}
