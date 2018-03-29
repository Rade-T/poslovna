package pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Racun {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="poreskaStopa_id", unique=true, nullable=false)
	public int id; 
	
	@Column(nullable = false, length = 30)
	public String banka;
	
	@ManyToOne
	public Preduzece preduzece;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
