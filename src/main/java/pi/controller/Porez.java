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

import pi.dto.PorezDTO;
import pi.repository.PorezRepository;

@RestController
@RequestMapping(value="/Porez")
public class Porez {
	
	@Autowired
	private PorezRepository porezRepository;
	
	@GetMapping
	public @ResponseBody List<PorezDTO> readAll(){
		List<pi.model.Porez> porezi = (List<pi.model.Porez>) porezRepository.findAll();
		List<PorezDTO> poreziDTO = new ArrayList<>();
		for(pi.model.Porez p : porezi){
			poreziDTO.add(new PorezDTO(p));
		}
		
		return poreziDTO;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody PorezDTO readOne(@PathVariable(value="id")Integer id){
		pi.model.Porez p = porezRepository.findById(id).get();
		return new PorezDTO(p);
	}
	
	@PostMapping
	public @ResponseBody PorezDTO readOne(@RequestBody PorezDTO dto){
		pi.model.Porez p = new pi.model.Porez();
		p.setNazivPoreza(dto.getNazivPoreza());
		p.setVazeci(dto.isVazeci());
		porezRepository.save(p);
		
		return new PorezDTO(p);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody PorezDTO update(@PathVariable(value="id") Integer id, @RequestBody PorezDTO dto){
		pi.model.Porez p = porezRepository.findById(id).get();
		p.setNazivPoreza(dto.getNazivPoreza());
		p.setVazeci(dto.isVazeci());
		porezRepository.save(p);
		
		return new PorezDTO(p);
	}
	
	@DeleteMapping("/(id)")
	public @ResponseBody PorezDTO delete(@PathVariable(value="id")Integer id){
		pi.model.Porez p = porezRepository.findById(id).get();
		porezRepository.delete(p);
		
		return new PorezDTO(p);
	}
	

}
