package pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="racun")
public class Racun {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="racun_id",unique = true, nullable = false)
	public int Id;
	
	@Column(name="banka",nullable = false, length = 30)
	public String banka;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="preduzece_id", referencedColumnName="preduzece_id", nullable= false)
	public Preduzece preduzece;
	
	public Racun() {
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getBanka() {
		return banka;
	}

	public void setBanka(String banka) {
		this.banka = banka;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}
}
