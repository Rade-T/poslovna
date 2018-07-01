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

import pi.dto.PoslovnaGodinaDTO;
import pi.repository.PoslovnaGodinaRepository;
import pi.repository.PreduzeceRepository;

@RestController
@RequestMapping(path="/api/poslovne-godine")
public class PoslovnaGodinaController {
	
	@Autowired
	private PoslovnaGodinaRepository poslovnaGodinaRepository;
	
	@Autowired
	private PreduzeceRepository PRepo;
	
	@GetMapping
	public @ResponseBody List<PoslovnaGodinaDTO> readAll(){
		List<pi.model.PoslovnaGodina> poslovnaGodina = (List<pi.model.PoslovnaGodina>) poslovnaGodinaRepository.findAll();
		List<PoslovnaGodinaDTO> poslovnaGodinaDTO = new ArrayList<>();
		for (pi.model.PoslovnaGodina poslovnaGodina2 : poslovnaGodina){
			poslovnaGodinaDTO.add(new PoslovnaGodinaDTO(poslovnaGodina2));
		}
		return poslovnaGodinaDTO;
	}
	@PostMapping
	public @ResponseBody pi.model.PoslovnaGodina create (@RequestBody PoslovnaGodinaDTO dto){
		pi.model.PoslovnaGodina psg = new pi.model.PoslovnaGodina();
		psg.setGodina(dto.getGodina());
		psg.setPreduzece( PRepo.findById(dto.getPreduzece()).get() );
		return poslovnaGodinaRepository.save(psg);
		
	} 
	@GetMapping("{/id}")
	public @ResponseBody PoslovnaGodinaDTO readOne(@PathVariable(value = "id")Integer id){
		pi.model.PoslovnaGodina psg = poslovnaGodinaRepository.findById(id).get();
		return new PoslovnaGodinaDTO(psg);
	}
	
	@PutMapping("{/id}")
	public @ResponseBody PoslovnaGodinaDTO update(@PathVariable(value = "id")Integer id, @RequestBody PoslovnaGodinaDTO dto){
		pi.model.PoslovnaGodina psg = new pi.model.PoslovnaGodina();
		psg.setGodina(dto.getGodina());
		psg.setPreduzece( PRepo.findById(dto.getPreduzece()).get() );
		return new PoslovnaGodinaDTO(psg);
	
	}
	
	@DeleteMapping("{/id}")
	public @ResponseBody PoslovnaGodinaDTO delete(@PathVariable(value = "id")Integer id){
		pi.model.PoslovnaGodina psg = poslovnaGodinaRepository.findById(id).get();
		poslovnaGodinaRepository.delete(psg);
		return new PoslovnaGodinaDTO(psg);
		
	}

}
