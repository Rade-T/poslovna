package pi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PoslovniPartner {

	@Column(unique = false, nullable = false, length = 150)
	public String nazivPartnera;
	
	@Column(unique = false, nullable = false, length = 150)
	public String adresa;
	
	@Column(unique = false, nullable = false, length = 10)
	public String vrstaPartnera; //Kupac, Dobavljac, Oboje
	
	@OneToMany(mappedBy="poslovniPartner")
	public List<IzlaznaFaktura> izlaznaFaktura;
	
	@ManyToOne
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
}
