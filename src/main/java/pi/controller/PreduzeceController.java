package pi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pi.dto.PreduzeceDTO;
import pi.model.Preduzece;
import pi.repository.PreduzeceRepository;

@RestController
@RequestMapping(path="/api/preduzeca")
public class PreduzeceController {
	
	@Autowired
	private PreduzeceRepository preduzecaRepository;

	@GetMapping
	public ResponseEntity<List<PreduzeceDTO>> readAll() {
		List<Preduzece> preduzeca = (List<Preduzece>) preduzecaRepository.findAll();
		List<PreduzeceDTO> preduzecaDTO = new ArrayList<>();
		for(Preduzece preduzece : preduzeca) {
		preduzecaDTO.add(new PreduzeceDTO(preduzece));
		}
		return new ResponseEntity<List<PreduzeceDTO>>(preduzecaDTO, HttpStatus.OK);
	}
	
	@GetMapping("/proba")
	public String proba(){
		return "Bravo";
	}
	
	@PostMapping
	public @ResponseBody Preduzece create(@RequestBody PreduzeceDTO dto) {
		Preduzece p = new Preduzece();
		p.setPIB(dto.getPIB());
		p.setAdresa(dto.getAdresa());
		p.setEmail(dto.getEmail());
		p.setMaticniBroj(dto.getMaticniBroj());
		p.setNaziv(dto.getNaziv());
		p.setSifraDelatnosti(dto.getSifraDelatnosti());
		p.setTelefon(dto.getTelefon());
		return preduzecaRepository.save(p);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody PreduzeceDTO readOne(@PathVariable(value = "id") Integer id) {
	    Preduzece p = preduzecaRepository.findById(id).get();
	    return new PreduzeceDTO(p);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody PreduzeceDTO update(@PathVariable(value = "id") Integer id,
	                                        @RequestBody PreduzeceDTO dto) {

	    Preduzece p = preduzecaRepository.findById(id).get();
	    p.setAdresa(dto.getAdresa());
	    p.setEmail(dto.getEmail());
	    p.setMaticniBroj(dto.getMaticniBroj());
	    p.setNaziv(dto.getNaziv());
	    p.setPIB(dto.getPIB());
	    p.setSifraDelatnosti(dto.getSifraDelatnosti());
	    p.setTelefon(dto.getTelefon());
	    preduzecaRepository.save(p);
	    return new PreduzeceDTO(p);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody PreduzeceDTO delete(@PathVariable(value = "id") Integer id) {
		Preduzece p = preduzecaRepository.findById(id).get();
	    preduzecaRepository.delete(p);
	    return new PreduzeceDTO(p);
	}
}
