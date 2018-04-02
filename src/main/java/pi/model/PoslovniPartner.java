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
}
