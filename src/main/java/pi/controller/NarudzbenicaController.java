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

import pi.dto.NarudzbenicaDTO;
import pi.model.Narudzbenica;
import pi.repository.NarudzbenicaRepository;

@RestController
@RequestMapping(path="/api/narudzbenice")

public class NarudzbenicaController {
	
	@Autowired
	private NarudzbenicaRepository narudzbenicaRepository;
	
	@GetMapping
	public @ResponseBody List<NarudzbenicaDTO> readAll(){
		List<Narudzbenica> narudzbenice = (List<Narudzbenica>) narudzbenicaRepository.findAll();
		List<NarudzbenicaDTO> narudzbeniceDTO = new ArrayList<>();
		for (Narudzbenica n : narudzbenice){
			narudzbeniceDTO.add(new NarudzbenicaDTO(n));
		}
		return narudzbeniceDTO;
	}
	
	@PostMapping
	public @ResponseBody Narudzbenica create (@RequestBody NarudzbenicaDTO dto) {
		Narudzbenica n = new Narudzbenica();
		n.setKolicina(dto.getKolicina());
		return narudzbenicaRepository.save(n);
	}
	
	@GetMapping("/id")
	public @ResponseBody NarudzbenicaDTO readOne (@PathVariable(value="id")Integer id, @RequestBody NarudzbenicaDTO dto){
		Narudzbenica n = narudzbenicaRepository.findById(id).get();
		return new NarudzbenicaDTO(n);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody NarudzbenicaDTO update(@PathVariable(value = "id") Integer id,
	                                        @RequestBody NarudzbenicaDTO dto) {

	    Narudzbenica n = narudzbenicaRepository.findById(id).get();  
		n.setKolicina(dto.getKolicina());
		narudzbenicaRepository.save(n);
	    return new NarudzbenicaDTO(n);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody NarudzbenicaDTO delete(@PathVariable(value = "id") Integer id) {
		Narudzbenica n = narudzbenicaRepository.findById(id).get();
	    narudzbenicaRepository.delete(n);
	    return new NarudzbenicaDTO(n);
	}

}
