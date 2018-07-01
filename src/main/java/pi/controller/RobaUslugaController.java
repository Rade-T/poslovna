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

import pi.dto.RobaUslugaDTO;
import pi.repository.RobaUslugaRepository;

@RestController
@RequestMapping(value="api/robe-usluge")
public class RobaUslugaController {
	
	@Autowired
	private RobaUslugaRepository robaUslugaRepository;
	
	@GetMapping
	public @ResponseBody List<RobaUslugaDTO> readAll(){
		List<pi.model.RobaUsluga> robaUsluga = (List<pi.model.RobaUsluga>) robaUslugaRepository.findAll();
		List<RobaUslugaDTO> robaUslugaDTO = new ArrayList<>();
		for(pi.model.RobaUsluga r : robaUsluga){
			robaUslugaDTO.add(new RobaUslugaDTO(r));
		}
		
		return robaUslugaDTO;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody RobaUslugaDTO readOne(@PathVariable(value="id") Integer id){
		pi.model.RobaUsluga r = robaUslugaRepository.findById(id).get();
		return new RobaUslugaDTO(r);
	}
	
	@PostMapping
	public @ResponseBody pi.model.RobaUsluga create(@RequestBody RobaUslugaDTO dto){
		pi.model.RobaUsluga r = new pi.model.RobaUsluga();
		r.setNaziv(dto.getNaziv());
		r.setJedinicaMere(dto.getJedinicaMere());
		r.setGrupa(dto.getGrupa());
		
		return robaUslugaRepository.save(r);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody RobaUslugaDTO update(@PathVariable(value="id")Integer id, @RequestBody RobaUslugaDTO dto){
		pi.model.RobaUsluga r = robaUslugaRepository.findById(id).get();
		r.setNaziv(dto.naziv);
		r.setJedinicaMere(dto.getJedinicaMere());
		r.setGrupa(dto.getGrupa());
		
		return new RobaUslugaDTO(r);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody RobaUslugaDTO delete(@PathVariable(value="id")Integer id){
		pi.model.RobaUsluga r = robaUslugaRepository.findById(id).get();
		robaUslugaRepository.delete(r);
		
		return new RobaUslugaDTO(r);
		
	}

}
