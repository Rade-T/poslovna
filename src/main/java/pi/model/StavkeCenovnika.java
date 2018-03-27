package pi.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class StavkeCenovnika {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stavke_id",unique=true,nullable=false)
	public int Id;	
	
	@Column(nullable = false, precision = 10)
	public float jedinicnaCena;
	
	@ManyToOne
	public Cenovnik cenovnik;

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
	
	/*
	@ManyToOne
	public RobaUsluga robaUsluga;*/
	
	
	

}
