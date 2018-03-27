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

import pi.dto.StavkeCenovnikaDTO;
import pi.model.StavkeCenovnika;
import pi.repository.StavkeCenovnikaRepository;

@RequestMapping(path="/StavkeCenovnika")
public class StavkeCenovnici {
	
	@Autowired
	private StavkeCenovnikaRepository stavkecenovnikRepository;
	
	@GetMapping
	public @ResponseBody List<StavkeCenovnikaDTO> readAll() {
		List<StavkeCenovnika> cenovnici = (List<StavkeCenovnika>) stavkecenovnikRepository.findAll();
		List<StavkeCenovnikaDTO> cenovniciDTO = new ArrayList<>();
		for (StavkeCenovnika stavke : cenovnici) {
			cenovniciDTO.add(new StavkeCenovnikaDTO(stavke));
		}
		return cenovniciDTO;
				
	}
	
	@PostMapping
	public @ResponseBody StavkeCenovnika create(@RequestBody StavkeCenovnikaDTO dto) {
		StavkeCenovnika c = new StavkeCenovnika();
		
		c.setCenovnik(dto.getCenovnik());
		c.setJedinicnaCena(dto.getJedinicnaCena());

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
		c.setCenovnik(dto.getCenovnik());
		c.setJedinicnaCena(dto.getJedinicnaCena());
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
