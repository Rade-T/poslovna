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

import pi.dto.CenovnikDTO;
import pi.dto.GrupaDTO;
import pi.model.Cenovnik;
import pi.repository.GrupaRepository;;

@RestController
@RequestMapping(path="/grupa")
public class Grupa {
	
	@Autowired
	private GrupaRepository grupaRepository;

	@GetMapping
	public @ResponseBody List<GrupaDTO> readAll(){
		List<pi.model.Grupa> grupe = (List<pi.model.Grupa>) grupaRepository.findAll();
		List<GrupaDTO> grupeDTO = new ArrayList<>();
		for(pi.model.Grupa g : grupe){
			grupeDTO.add(new GrupaDTO(g));
		}
		return grupeDTO;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody GrupaDTO readOne(@PathVariable(value="id")int id, @RequestBody GrupaDTO dto ){
		pi.model.Grupa g = grupaRepository.findById(id).get();
		return new GrupaDTO(g);
	}
	
	@PostMapping
	public @ResponseBody pi.model.Grupa create(@RequestBody GrupaDTO dto){
		pi.model.Grupa g = new pi.model.Grupa();
		g.setNaziv(dto.getNaziv());
		g.setPorez(g.getPorez());
		g.setPreduzece(g.getPreduzece());
		
		return grupaRepository.save(g);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody GrupaDTO update(@PathVariable(value="id")int id, @RequestBody GrupaDTO dto ){
		pi.model.Grupa g = grupaRepository.findById(id).get();
		g.setNaziv(dto.naziv);
		g.setPorez(dto.porez);
		g.setPreduzece(dto.preduzece);
		grupaRepository.save(g);
		return new GrupaDTO(g);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody GrupaDTO delete(@PathVariable(value="id")int id, @RequestBody GrupaDTO dto){
		pi.model.Grupa g = grupaRepository.findById(id).get();
		grupaRepository.delete(g);
		return new GrupaDTO(g);
	}
	
	
	
	
}