package pi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class RobaUsluga {
	
	@Column(nullable = false, length = 30)
	public String naziv;
	
	@Column(nullable = false, length = 10)
	public String jedinicaMere;
	
	@OneToMany(mappedBy="robaUsluga")
	public List<StavkeFakture> stavkeFakture;
	
	@OneToMany(mappedBy="robaUsluga")
	public List<StavkeCenovnika> stavkeCenovnika;
	
	@ManyToOne
	public Grupa grupa;
	
	@OneToMany(mappedBy="robaUsluga")
	public List<StavkeOtpremnice> stavkeOtpremnice;
	
	@OneToMany(mappedBy="robaUsluga")
	public List<StavkaNarudzbenice> stavkeNarudzbenice;
}
