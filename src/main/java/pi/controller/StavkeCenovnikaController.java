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
import pi.dto.StavkeCenovnikaDTO;
import pi.model.RobaUsluga;
import pi.model.StavkeCenovnika;
import pi.repository.CenovnikRepository;
import pi.repository.RobaUslugaRepository;
import pi.repository.StavkeCenovnikaRepository;

@RestController
@RequestMapping(path = "/api/stavke-cenovnika")
public class StavkeCenovnikaController {

	@Autowired
	private StavkeCenovnikaRepository stavkecenovnikRepository;
	
	@Autowired
	private CenovnikRepository CRepo;
	
	@Autowired
	private RobaUslugaRepository robuslRepository;

	@GetMapping
	public @ResponseBody List<StavkeCenovnikaDTO> readAll() {
		 List<StavkeCenovnika> liStavkeCenovnika = (List<StavkeCenovnika>)stavkecenovnikRepository.findAll();
		 List<StavkeCenovnikaDTO> liStavkeCenovnikaDTO = new ArrayList<>();
		 for(StavkeCenovnika sc : liStavkeCenovnika){
			 liStavkeCenovnikaDTO.add(new StavkeCenovnikaDTO(sc));
		 }
		 
		 return liStavkeCenovnikaDTO;
		 
	}

	@PostMapping
	public @ResponseBody StavkeCenovnika create(@RequestBody StavkeCenovnikaDTO dto) {
		StavkeCenovnika c = new StavkeCenovnika();
		c.setJedinicnaCena(dto.getJedinicnaCena());
		c.setCenovnik(CRepo.findById(dto.getCenovnik()).get() );
		c.setRobaUsluga(robuslRepository.findById(dto.getIdRobaUsluge()).get());
		

		return stavkecenovnikRepository.save(c);

	}

	@GetMapping("/{id}")
	public @ResponseBody StavkeCenovnikaDTO readOne(@PathVariable(value = "id") Integer id) {
		StavkeCenovnika c = stavkecenovnikRepository.findById(id).get();
		return new StavkeCenovnikaDTO(c);
	}

	@PutMapping("/{id}")
	public @ResponseBody StavkeCenovnikaDTO update(@PathVariable(value = "id") Integer id,
			@RequestBody StavkeCenovnikaDTO dto) {

		StavkeCenovnika c = stavkecenovnikRepository.findById(id).get();
		c.setJedinicnaCena(dto.getJedinicnaCena());
		c.setCenovnik( CRepo.findById(dto.getCenovnik()).get() );
		c.setRobaUsluga(robuslRepository.findById(dto.getIdRobaUsluge()).get());
		stavkecenovnikRepository.save(c);
		return new StavkeCenovnikaDTO(c);
	}

	@DeleteMapping("/{id}")
	public @ResponseBody StavkeCenovnikaDTO delete(@PathVariable(value = "id") Integer id) {
		StavkeCenovnika c = stavkecenovnikRepository.findById(id).get();
		stavkecenovnikRepository.delete(c);
		return new StavkeCenovnikaDTO(c);
	}

}
