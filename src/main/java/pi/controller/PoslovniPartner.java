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

import pi.dto.PoslovniPartnerDTO;
import pi.repository.PoslovniPartnerRepository;
import pi.repository.PreduzeceRepository;

@RestController
@RequestMapping(path = "/PoslovniPartner")
public class PoslovniPartner {
	
	@Autowired
	private PoslovniPartnerRepository poslovniPartnerRepository;
	
	@Autowired
	private PreduzeceRepository PRepo;
	
	@GetMapping
	public @ResponseBody List<PoslovniPartnerDTO> readAll(){
		List<pi.model.PoslovniPartner> poslovniPartneri = (List<pi.model.PoslovniPartner>) poslovniPartnerRepository.findAll();
		List<PoslovniPartnerDTO> poslovniPartnerDTO = new ArrayList<>();
		for (pi.model.PoslovniPartner poslovniPartner : poslovniPartneri){
			poslovniPartnerDTO.add(new PoslovniPartnerDTO(poslovniPartner));
		}
		return poslovniPartnerDTO;
	}
	
	@PostMapping
	public @ResponseBody pi.model.PoslovniPartner create (@RequestBody PoslovniPartnerDTO dto){
		pi.model.PoslovniPartner pp = new pi.model.PoslovniPartner();
		pp.setAdresa(dto.getAdresa());
		pp.setNazivPartnera(dto.getNazivPartnera());
		pp.setPreduzece( PRepo.findById(dto.getPreduzece()).get() );
		pp.setVrstaPartnera(dto.getVrstaPartnera());
		return poslovniPartnerRepository.save(pp);
	}
	
	@GetMapping("{/id}")
	public @ResponseBody PoslovniPartnerDTO readOne(@PathVariable(value = "id")Integer id){
		pi.model.PoslovniPartner pp = poslovniPartnerRepository.findById(id).get();
		return new PoslovniPartnerDTO(pp);
	}
	
	@PutMapping
	public @ResponseBody PoslovniPartnerDTO update(@PathVariable(value = "id")Integer id, @RequestBody PoslovniPartnerDTO dto){
		pi.model.PoslovniPartner pp = poslovniPartnerRepository.findById(id).get();
		pp.setAdresa(dto.getAdresa());
		pp.setNazivPartnera(dto.getNazivPartnera());
		pp.setPreduzece( PRepo.findById(dto.getPreduzece()).get() );
		pp.setVrstaPartnera(dto.getVrstaPartnera());
		poslovniPartnerRepository.save(pp);
		return new PoslovniPartnerDTO(pp);
	}
	
	@DeleteMapping("{/id}")
	public @ResponseBody PoslovniPartnerDTO delete (@PathVariable(value = "id")Integer id){
		pi.model.PoslovniPartner pp = poslovniPartnerRepository.findById(id).get();
		poslovniPartnerRepository.delete(pp);
		return new PoslovniPartnerDTO(pp);
	}

}
