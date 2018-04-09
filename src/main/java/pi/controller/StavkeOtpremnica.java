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

import pi.dto.StavkeOtpremniceDTO;
import pi.model.StavkeOtpremnice;
import pi.repository.StavkeOtpremniceRepository;

@RequestMapping(path="/StavkeOtpremnice")
public class StavkeOtpremnica {
	
	@Autowired
	private StavkeOtpremniceRepository  stavkeotpremniceRepository;
	
	@GetMapping
	public @ResponseBody List<StavkeOtpremniceDTO> readAll() {
		List<StavkeOtpremnice> otpremnice = (List<StavkeOtpremnice>) stavkeotpremniceRepository.findAll();
		List<StavkeOtpremniceDTO> narudzbeniceDTO = new ArrayList<>();
		for (StavkeOtpremnice otpremnica : otpremnice) {
			narudzbeniceDTO.add(new StavkeOtpremniceDTO(otpremnica));
		}
		return narudzbeniceDTO;
				
	}
	
	@PostMapping
	public @ResponseBody StavkeOtpremnice create(@RequestBody StavkeOtpremniceDTO dto) {
		StavkeOtpremnice o = new StavkeOtpremnice();
		
		o.setKolicina(dto.getKolicina());
		o.setCenaPoJediniciMere(dto.getCenaPoJediniciMere());
		o.setOtpremnica(dto.getOptremnica());
		o.setRobaUsluga(dto.getRobaUsluga());
		

		return stavkeotpremniceRepository.save(o);	

	}
	
	@GetMapping("/{id}")
	public @ResponseBody StavkeOtpremniceDTO readOne(@PathVariable(value = "id") Integer id) {
		StavkeOtpremnice o = stavkeotpremniceRepository.findById(id).get();
	    return new StavkeOtpremniceDTO(o);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody StavkeOtpremniceDTO update(@PathVariable(value = "id") Integer id,
	                                        @RequestBody StavkeOtpremniceDTO dto) {

		StavkeOtpremnice o = stavkeotpremniceRepository.findById(id).get();  
		
		o.setKolicina(dto.getKolicina());
		o.setCenaPoJediniciMere(dto.getCenaPoJediniciMere());
		o.setOtpremnica(dto.getOptremnica());
		o.setRobaUsluga(dto.getRobaUsluga());
		
	    stavkeotpremniceRepository.save(o);
	    return new StavkeOtpremniceDTO(o);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody StavkeOtpremniceDTO delete(@PathVariable(value = "id") Integer id) {
		StavkeOtpremnice o = stavkeotpremniceRepository.findById(id).get();
	    stavkeotpremniceRepository.delete(o);
	    return new StavkeOtpremniceDTO(o);
	}

}
