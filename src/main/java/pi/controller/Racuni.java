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

import pi.dto.RacunDTO;
import pi.model.Racun;
import pi.repository.PreduzeceRepository;
import pi.repository.RacunRepository;

@RestController
@RequestMapping(path="/Racuni")
public class Racuni {
	
	@Autowired
	private RacunRepository racunRepository;
	
	@Autowired
	private PreduzeceRepository PRepo;
	
	
	@GetMapping
	public @ResponseBody List<RacunDTO> readAll(){
		List<Racun> racuni = (List<Racun>) racunRepository.findAll();
		List<RacunDTO> racuniDTO = new ArrayList<>();
		for (Racun r : racuni){
			racuniDTO.add(new RacunDTO(r));
		}
		
		return racuniDTO;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody RacunDTO readOne(@PathVariable(value="id") Integer id){
		Racun r = racunRepository.findById(id).get();
		return new RacunDTO(r);
	}
	
	@PostMapping
	public @ResponseBody Racun create(@RequestBody RacunDTO dto){
		Racun r = new Racun();
		r.setBanka(dto.getBanka());
		r.setPreduzece(PRepo.findById(dto.getPreduzece()).get());
		
		return racunRepository.save(r);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody RacunDTO update(@PathVariable(value="id") Integer id, @RequestBody RacunDTO dto){
		Racun r = racunRepository.findById(id).get();
		r.setBanka(dto.getBanka());
		r.setPreduzece(PRepo.findById(dto.getPreduzece()).get());
		racunRepository.save(r);
		
		return new RacunDTO(r);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody RacunDTO delete(@PathVariable(value="id")Integer id){
		Racun r = racunRepository.findById(id).get();
		racunRepository.delete(r);
		
		return new RacunDTO(r);
	}

}
