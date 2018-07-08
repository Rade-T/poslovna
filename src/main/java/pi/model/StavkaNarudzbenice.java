package pi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;

@Entity
@Table(name="stavkeNarudzbenice")
public class StavkaNarudzbenice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stavkeNarudzbenice_id",unique=true,nullable=false)
	public int id;
	
	@Column(name="kolicina",nullable = false)
	public float kolicina;
	
	@Column(name="cena", nullable = false)
	public float cenaPoJediniciMere;
	
	@Column(name="ukupnaCena", nullable = false)
	public float ukupnaCena;
	
	@ManyToOne
	@JoinColumn(name="robaUsluga_id", referencedColumnName="robaUsluga_id", nullable=false)
	public RobaUsluga robaUsluga;
	
	@ManyToOne
	@JoinColumn(name="narudzbenica_id", referencedColumnName="narudzbenica_id", nullable=false)
	public Narudzbenica narudzbenica;

	public float getKolicina() {
		return kolicina;
	}

	public void setKolicina(float kolicina) {
		this.kolicina = kolicina;
	}

	public float getCenaPoJediniciMere() {
		return cenaPoJediniciMere;
	}

	public void setCenaPoJediniciMere(float cenaPoJediniciMere) {
		this.cenaPoJediniciMere = cenaPoJediniciMere;
	}

	public float getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(float ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public RobaUsluga getRobaUsluga() {
		return robaUsluga;
	}

	public void setRobaUsluga(RobaUsluga robaUsluga) {
		this.robaUsluga = robaUsluga;
	}

	public Narudzbenica getNarudzbenica() {
		return narudzbenica;
	}

	public void setNarudzbenica(Narudzbenica narudzbenica) {
		this.narudzbenica = narudzbenica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
