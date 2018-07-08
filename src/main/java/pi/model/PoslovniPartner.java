package pi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="poslovniPartner")
public class PoslovniPartner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="poslovniPartner_id",unique = true, nullable = false)
	public int id;

	@Column(name="nazivPartnera", unique = false, nullable = false, length = 150)
	public String nazivPartnera;
	
	@Column(name="adresa",unique = false, nullable = false, length = 150)
	public String adresa;
	
	@Column(name="vrstaPartnera",unique = false, nullable = false, length = 10)
	public String vrstaPartnera; //Kupac, Dobavljac, Oboje
	
	@OneToMany(mappedBy="poslovniPartner")
	public List<IzlaznaFaktura> izlaznaFaktura;
	
	@ManyToOne
	@JoinColumn(name="preduzece_id", referencedColumnName="preduzece_id", nullable=false)
	public Preduzece preduzece;
	
	@OneToMany(mappedBy="poslovniPartner")
	public List<Otpremnica> otpremnica;
	
	@OneToMany(mappedBy="poslovniPartner")
	public List<Narudzbenica> narudzbenica;

	public String getNazivPartnera() {
		return nazivPartnera;
	}

	public void setNazivPartnera(String nazivPartnera) {
		this.nazivPartnera = nazivPartnera;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getVrstaPartnera() {
		return vrstaPartnera;
	}

	public void setVrstaPartnera(String vrstaPartnera) {
		this.vrstaPartnera = vrstaPartnera;
	}

	public List<IzlaznaFaktura> getIzlaznaFaktura() {
		return izlaznaFaktura;
	}

	public void setIzlaznaFaktura(List<IzlaznaFaktura> izlaznaFaktura) {
		this.izlaznaFaktura = izlaznaFaktura;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	public List<Otpremnica> getOtpremnica() {
		return otpremnica;
	}

	public void setOtpremnica(List<Otpremnica> otpremnica) {
		this.otpremnica = otpremnica;
	}

	public List<Narudzbenica> getNarudzbenica() {
		return narudzbenica;
	}

	public void setNarudzbenica(List<Narudzbenica> narudzbenica) {
		this.narudzbenica = narudzbenica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
