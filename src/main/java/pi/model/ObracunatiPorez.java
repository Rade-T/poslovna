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
@Table(name="obracunatiPorez")
public class ObracunatiPorez {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="obracunatiPorez_id",unique=true,nullable=false)
	public int id;

	@Column(name="stopa", nullable = false, precision = 5, scale = 2)
	private float stopa;

	@Column(name="iznos", nullable = false, precision = 15, scale = 2)
	private float iznos;

	@ManyToOne
	@JoinColumn(name="porez_id", referencedColumnName="porez_id", nullable=false)
	public Porez porez;

	@ManyToOne
	@JoinColumn(name="izlaznaFaktura_id", referencedColumnName="izlaznaFaktura_id", nullable=false)
	public IzlaznaFaktura izlaznaFaktura;

	public float getStopa() {
		return stopa;
	}

	public void setStopa(float stopa) {
		this.stopa = stopa;
	}

	public float getIznos() {
		return iznos;
	}

	public void setIznos(float iznos) {
		this.iznos = iznos;
	}

	public Porez getPorez() {
		return porez;
	}

	public void setPorez(Porez porez) {
		this.porez = porez;
	}

	public IzlaznaFaktura getIzlaznaFaktura() {
		return izlaznaFaktura;
	}

	public void setIzlaznaFaktura(IzlaznaFaktura izlaznaFaktura) {
		this.izlaznaFaktura = izlaznaFaktura;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
