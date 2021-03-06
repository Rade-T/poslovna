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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="poslovnaGodina")
public class PoslovnaGodina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="poslovnaGodina_id",unique = true, nullable = false)
	public int id;
	
	@Column(name="godina",unique = true, length = 4)
	public int godina;
	
	@Column(name="zakljucena")
	public boolean zakljucena;
	
	@OneToMany(mappedBy="poslovnaGodina")
	public List<IzlaznaFaktura> izlaznaFaktura;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="preduzece_id", referencedColumnName="preduzece_id", nullable=false)
	public Preduzece preduzece;
	
	@OneToMany(mappedBy="poslovnaGodina")
	public List<Otpremnica> otpremnica;
	
	@OneToMany(mappedBy="poslovnaGodina")
	public List<Narudzbenica> narudzbenica;

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public boolean isZakljucena() {
		return zakljucena;
	}

	public void setZakljucena(boolean zakljucena) {
		this.zakljucena = zakljucena;
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
