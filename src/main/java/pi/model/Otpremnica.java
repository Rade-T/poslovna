package pi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="otpremnica")
public class Otpremnica {
	
	@Id
	@Column(name="otpremnica_id",nullable = false, unique = true)
	public int brojOtpremnice;
	
	@Column(name="datumOtpremnice", nullable=false)
	public Date datumOtpremnice;

	@Column(name="osnovica",nullable = false, precision = 15)
	public float osnovica;
	
	@Column(name="ukupanPdv", nullable = false, precision = 15)
	public float ukupanPdv;
	
	@Column(name="iznosZaPlacanje",nullable = false, precision = 15)
	public float iznosZaPlacanje;
	
	@ManyToOne
	@JoinColumn(name="poslovniPartner_id", referencedColumnName="poslovniPartner_id", nullable=false)
	public PoslovniPartner poslovniPartner;
	
	@OneToMany(mappedBy="otpremnica")
	public List<IzlaznaFaktura> izlaznaFaktura;
	
	@ManyToOne
	@JoinColumn(name="poslovnaGodina_id", referencedColumnName="poslovnaGodina_id", nullable=false)
	public PoslovnaGodina poslovnaGodina;
	
	@OneToMany(mappedBy="otpremnica")
	public List<StavkeOtpremnice> stavkeOtpremnice;
	
	@ManyToOne
	@JoinColumn(name="narudzbenica_id", referencedColumnName="narudzbenica_id", nullable= false)
	public Narudzbenica narudzbenica;
	
	public Otpremnica() {
		
	}

	public int getBrojOtpremnice() {
		return brojOtpremnice;
	}

	public void setBrojOtpremnice(int brojOtpremnice) {
		this.brojOtpremnice = brojOtpremnice;
	}

	public Date getDatumOtpremnice() {
		return datumOtpremnice;
	}

	public void setDatumOtpremnice(Date datumOtpremnice) {
		this.datumOtpremnice = datumOtpremnice;
	}

	public float getOsnovica() {
		return osnovica;
	}

	public void setOsnovica(float osnovica) {
		this.osnovica = osnovica;
	}

	public float getUkupanPdv() {
		return ukupanPdv;
	}

	public void setUkupanPdv(float ukupanPdv) {
		this.ukupanPdv = ukupanPdv;
	}

	public float getIznosZaPlacanje() {
		return iznosZaPlacanje;
	}

	public void setIznosZaPlacanje(float iznosZaPlacanje) {
		this.iznosZaPlacanje = iznosZaPlacanje;
	}

	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public List<IzlaznaFaktura> getIzlaznaFaktura() {
		return izlaznaFaktura;
	}

	public void setIzlaznaFaktura(List<IzlaznaFaktura> izlaznaFaktura) {
		this.izlaznaFaktura = izlaznaFaktura;
	}

	public PoslovnaGodina getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	public List<StavkeOtpremnice> getStavkeOtpremnice() {
		return stavkeOtpremnice;
	}

	public void setStavkeOtpremnice(List<StavkeOtpremnice> stavkeOtpremnice) {
		this.stavkeOtpremnice = stavkeOtpremnice;
	}

	public Narudzbenica getNarudzbenica() {
		return narudzbenica;
	}

	public void setNarudzbenica(Narudzbenica narudzbenica) {
		this.narudzbenica = narudzbenica;
	}
}
