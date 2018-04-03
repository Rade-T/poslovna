package pi.dto;

import java.util.List;

import pi.model.IzlaznaFaktura;
import pi.model.Narudzbenica;
import pi.model.Otpremnica;
import pi.model.Preduzece;

public class PoslovnaGodinaDTO {
	public int godina;
	public boolean zakljucena;
	public List<IzlaznaFaktura> izlaznaFaktura;
	public Preduzece preduzece;
	public List<Otpremnica> otpremnica;
	public List<Narudzbenica> narudzbenica;
	
	public PoslovnaGodinaDTO(){
		
	}

	public PoslovnaGodinaDTO(PoslovnaGodinaDTO dto) {
		super();
		this.godina = godina;
		this.zakljucena = zakljucena;
		this.izlaznaFaktura = izlaznaFaktura;
		this.preduzece = preduzece;
		this.otpremnica = otpremnica;
		this.narudzbenica = narudzbenica;
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
