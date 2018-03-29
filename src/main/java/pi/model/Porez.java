package pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Porez {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="porez_id", unique=true, nullable=false)
	public int id;
	@Column(nullable = false, length = 120)
	public String nazivPoreza;
	@Column
	public boolean vazeci;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazivPoreza() {
		return nazivPoreza;
	}
	public void setNazivPoreza(String nazivPoreza) {
		this.nazivPoreza = nazivPoreza;
	}
	public boolean isVazeci() {
		return vazeci;
	}
	public void setVazeci(boolean vazeci) {
		this.vazeci = vazeci;
	}
	
	/*@OneToMany(mappedBy="porez")
	public List<ObracunatiPorez> obracunatiPorez;
	
	@OneToMany(mappedBy="porez")
	public List<PoreskaStopa> poreskaStopa;
	
	@OneToMany(mappedBy="porez")
	public List<Grupa> grupa;*/
	
	

}
