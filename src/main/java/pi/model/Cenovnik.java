package pi.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cenovnik {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cenovnik_id",unique=true,nullable=false)
	public int Id;
	
	@Column(unique = false)
	public Date datumPrimene;
	
	@ManyToOne
	public Preduzece preduzece;
	
	@OneToMany(mappedBy="cenovnik")
	public List<StavkeCenovnika> stavkeCenovnika;

}
