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

import pi.dto.StavkaNarudzebniceDTO;
import pi.model.StavkaNarudzbenice;
import pi.repository.StavkaNarudzbeniceRepository;

@RequestMapping(path="/stavkeNarudzbenica")
public class StavkeNarudzbenica {
	
	@Autowired
	private StavkaNarudzbeniceRepository stavkenarudzbenicaRepository;
	
	@GetMapping
	public @ResponseBody List<StavkaNarudzebniceDTO> readAll() {
		List<StavkaNarudzbenice> narudzbenice = (List<StavkaNarudzbenice>) stavkenarudzbenicaRepository.findAll();
		List<StavkaNarudzebniceDTO> narudzbeniceDTO = new ArrayList<>();
		for (StavkaNarudzbenice narudzbenica : narudzbenice) {
			narudzbeniceDTO.add(new StavkaNarudzebniceDTO(narudzbenica));
		}
		return narudzbeniceDTO;
				
	}
	
	@PostMapping
	public @ResponseBody StavkaNarudzbenice create(@RequestBody StavkaNarudzebniceDTO dto) {
		StavkaNarudzbenice n = new StavkaNarudzbenice();
		
		n.setKolicina(dto.getKolicina());
		n.setCenaPoJediniciMere(dto.getCenaPoJediniciMere());
		n.setUkupnaCena(dto.getUkupnaCena());
		n.setRobaUsluga(dto.getRobaUsluga());
		n.setNarudzbenica(dto.getNarudzbenica());
		

		return stavkenarudzbenicaRepository.save(n);	

	}
	
	@GetMapping("/{id}")
	public @ResponseBody StavkaNarudzebniceDTO readOne(@PathVariable(value = "id") Integer id) {
		StavkaNarudzbenice n = stavkenarudzbenicaRepository.findById(id).get();
	    return new StavkaNarudzebniceDTO(n);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody StavkaNarudzebniceDTO update(@PathVariable(value = "id") Integer id,
	                                        @RequestBody StavkaNarudzebniceDTO dto) {

		StavkaNarudzbenice n = stavkenarudzbenicaRepository.findById(id).get();  
		
		n.setKolicina(dto.getKolicina());
		n.setCenaPoJediniciMere(dto.getCenaPoJediniciMere());
		n.setUkupnaCena(dto.getUkupnaCena());
		n.setRobaUsluga(dto.getRobaUsluga());
		n.setNarudzbenica(dto.getNarudzbenica());
		
	    stavkenarudzbenicaRepository.save(n);
	    return new StavkaNarudzebniceDTO(n);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody StavkaNarudzebniceDTO delete(@PathVariable(value = "id") Integer id) {
		StavkaNarudzbenice n = stavkenarudzbenicaRepository.findById(id).get();
	    stavkenarudzbenicaRepository.delete(n);
	    return new StavkaNarudzebniceDTO(n);
	}

}
