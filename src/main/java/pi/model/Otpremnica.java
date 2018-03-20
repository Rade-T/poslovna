package pi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Otpremnica {
	
	@Id
	@Column(nullable = false, unique = true)
	public int brojOtpremnice;
	
	@Column
	public Date datumOtpremnice;

	@Column(nullable = false, precision = 15)
	public float osnovica;
	
	@Column(nullable = false, precision = 15)
	public float ukupanPdv;
	
	@Column(nullable = false, precision = 15)
	public float iznosZaPlacanje;
	
	/*
	@ManyToOne
	public PoslovniPartner poslovniPartner;
	
	@OneToMany(mappedBy="otpremnica")
	public List<IzlaznaFaktura> izlaznaFaktura;
	
	@ManyToOne
	public PoslovnaGodina poslovnaGodina;
	
	@OneToMany(mappedBy="otpremnica")
	public List<StavkeOtpremnice> stavkeOtpremnice;
	
	@ManyToOne
	public Narudzbenica narudzbenica;
	
	*/
}
