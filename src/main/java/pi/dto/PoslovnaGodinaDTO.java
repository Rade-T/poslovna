package pi.dto;

import pi.model.PoslovnaGodina;

public class PoslovnaGodinaDTO {
	public int godina;
	public boolean zakljucena;
//	public List<IzlaznaFaktura> izlaznaFaktura;
	public int preduzece;
//	public List<Otpremnica> otpremnica;
//	public List<Narudzbenica> narudzbenica;
	
	public PoslovnaGodinaDTO(){
		
	}

	public PoslovnaGodinaDTO(PoslovnaGodina dto) {
		super();
		this.godina = dto.getGodina();
		this.zakljucena = dto.isZakljucena();
		this.preduzece = dto.getPreduzece().getPIB();
	}

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

	public int getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(int preduzece) {
		this.preduzece = preduzece;
	}

}
