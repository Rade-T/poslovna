package pi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy="porez")
	public List<ObracunatiPorez> obracunatiPorez;
	
	@OneToMany(mappedBy="porez")
	public List<PoreskaStopa> poreskaStopa;
	
	@OneToMany(mappedBy="porez")
	public List<Grupa> grupa;
	
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
	public List<ObracunatiPorez> getObracunatiPorez() {
		return obracunatiPorez;
	}
	public void setObracunatiPorez(List<ObracunatiPorez> obracunatiPorez) {
		this.obracunatiPorez = obracunatiPorez;
	}
	public List<PoreskaStopa> getPoreskaStopa() {
		return poreskaStopa;
	}
	public void setPoreskaStopa(List<PoreskaStopa> poreskaStopa) {
		this.poreskaStopa = poreskaStopa;
	}
	public List<Grupa> getGrupa() {
		return grupa;
	}
	public void setGrupa(List<Grupa> grupa) {
		this.grupa = grupa;
	}
	
}
