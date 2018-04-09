package pi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pi.dto.IzlaznaFakturaDTO;
import pi.model.IzlaznaFaktura;
import pi.repository.IzlaznaFakturaRepository;
import pi.repository.OtpremnicaRepository;
import pi.repository.PoslovnaGodinaRepository;
import pi.repository.PoslovniPartnerRepository;

@RestController
@RequestMapping(path = "/IzlazneFakture")
public class IzlazneFakture {
	
	@Autowired
	private IzlaznaFakturaRepository izlaznaFakturaRepository;
	
	@Autowired
	private PoslovnaGodinaRepository PGRepository;
	
	@Autowired
	private PoslovniPartnerRepository PPRepository;
	
	@Autowired
	private OtpremnicaRepository ORepository;

	@GetMapping
	public @ResponseBody List<IzlaznaFakturaDTO> readAll() {
		List<IzlaznaFaktura> izlazneFakture = (List<IzlaznaFaktura>) izlaznaFakturaRepository.findAll();
		List<IzlaznaFakturaDTO> izlazneFaktureDTO = new ArrayList<>();
		for (IzlaznaFaktura IzlaznaFaktura : izlazneFakture) {
			izlazneFaktureDTO.add(new IzlaznaFakturaDTO(IzlaznaFaktura));
		}
		return izlazneFaktureDTO;

	}

	@PostMapping
	public @ResponseBody IzlaznaFakturaDTO create(@RequestBody IzlaznaFakturaDTO dto) {
		IzlaznaFaktura c = new IzlaznaFaktura();

		c.brojFakture = dto.getBrojFakture();
		c.datumFakture = dto.getDatumFakture();
		c.datumValute = dto.getDatumValute();
		c.datumObracuna = dto.getDatumObracuna();
		c.ukupnoRobe = dto.getUkupnoRobe();
		c.ukupanRabat = dto.getUkupanRabat();
		c.ukupanPorez = dto.getUkupanPorez();
		c.iznosFakture = dto.getIznosFakture();
		c.iznosFaktureOsnovica = dto.getIznosFaktureOsnovica();
		c.uplataNaRacun = dto.getUplataNaRacun();
		c.pozivNaBroj = dto.getPozivNaBroj();
		c.statusFakture = dto.getStatusFakture();
		c.poslovniPartner = PPRepository.findById(dto.getPoslovniPartner()).get();
		c.poslovnaGodina = PGRepository.findById(dto.getPoslovnaGodina()).get();
		c.otpremnica = ORepository.findById(dto.getOtpremnica()).get();

		izlaznaFakturaRepository.save(c);
		return new IzlaznaFakturaDTO(c);

	}

	@GetMapping("/{id}")
	public @ResponseBody IzlaznaFakturaDTO readOne(@PathVariable(value = "id") Integer id) {
		IzlaznaFaktura c = izlaznaFakturaRepository.findById(id).get();
		return new IzlaznaFakturaDTO(c);
	}

	@PutMapping("/{id}")
	public @ResponseBody IzlaznaFakturaDTO update(@PathVariable(value = "id") Integer id, @RequestBody IzlaznaFakturaDTO dto) {

		IzlaznaFaktura c = izlaznaFakturaRepository.findById(id).get();
		
		c.brojFakture = dto.getBrojFakture();
		c.datumFakture = dto.getDatumFakture();
		c.datumValute = dto.getDatumValute();
		c.datumObracuna = dto.getDatumObracuna();
		c.ukupnoRobe = dto.getUkupnoRobe();
		c.ukupanRabat = dto.getUkupanRabat();
		c.ukupanPorez = dto.getUkupanPorez();
		c.iznosFakture = dto.getIznosFakture();
		c.iznosFaktureOsnovica = dto.getIznosFaktureOsnovica();
		c.uplataNaRacun = dto.getUplataNaRacun();
		c.pozivNaBroj = dto.getPozivNaBroj();
		c.statusFakture = dto.getStatusFakture();
		c.poslovniPartner = PPRepository.findById(dto.getPoslovniPartner()).get();
		c.poslovnaGodina = PGRepository.findById(dto.getPoslovnaGodina()).get();
		c.otpremnica = ORepository.findById(dto.getOtpremnica()).get();
		
		izlaznaFakturaRepository.save(c);
		return new IzlaznaFakturaDTO(c);
	}

	@DeleteMapping("/{id}")
	public @ResponseBody IzlaznaFakturaDTO delete(@PathVariable(value = "id") Integer id) {
		IzlaznaFaktura c = izlaznaFakturaRepository.findById(id).get();
		izlaznaFakturaRepository.delete(c);
		return new IzlaznaFakturaDTO(c);
	}
}
