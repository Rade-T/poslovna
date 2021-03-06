package pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="stavkeCenovnika")
public class StavkeCenovnika {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stavkeCenovnika_id",unique=true,nullable=false)
	public int Id;	
	
	@Column(name="jedinicnaCena",nullable = false, precision = 10)
	public float jedinicnaCena;
	
	@ManyToOne
	@JoinColumn(name="cenovnik_id",referencedColumnName="cenovnik_id", nullable=false)
	public Cenovnik cenovnik;

	@ManyToOne
	@JoinColumn(name="robaUsluga_id",referencedColumnName="robaUsluga_id", nullable=false)
	public RobaUsluga robaUsluga;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public float getJedinicnaCena() {
		return jedinicnaCena;
	}

	public void setJedinicnaCena(float jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}

	public Cenovnik getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}

	public RobaUsluga getRobaUsluga() {
		return robaUsluga;
	}

	public void setRobaUsluga(RobaUsluga robaUsluga) {
		this.robaUsluga = robaUsluga;
	}
}
