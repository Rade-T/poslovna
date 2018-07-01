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

import pi.dto.OtpremnicaDTO;
import pi.model.Otpremnica;
import pi.repository.OtpremnicaRepository;

@RestController
@RequestMapping(path="/api/otpremnice")
public class OtpremnicaController {
	
	@Autowired
	private OtpremnicaRepository otpremniceRepository;
	
	@GetMapping
	public @ResponseBody List<OtpremnicaDTO> readAll() {
		List<Otpremnica> otpremnice = (List<Otpremnica>) otpremniceRepository.findAll();
		List<OtpremnicaDTO> otpremniceDTO = new ArrayList<>();
		for (Otpremnica otpremnica : otpremnice) {
			otpremniceDTO.add(new OtpremnicaDTO(otpremnica));
		}
		return otpremniceDTO;
				
	}
	
	@PostMapping
	public @ResponseBody Otpremnica create(@RequestBody OtpremnicaDTO dto) {
		Otpremnica o = new Otpremnica();
		o.setBrojOtpremnice(dto.getBrojOtpremnice());
		o.setDatumOtpremnice(dto.getDatumOtpremnice());
		o.setOsnovica(dto.getOsnovica());
		o.setUkupanPdv(dto.getUkupanPdv());
		o.setIznosZaPlacanje(dto.getIznosZaPlacanje());

		return otpremniceRepository.save(o);	

	}
	
	@GetMapping("/{id}")
	public @ResponseBody OtpremnicaDTO readOne(@PathVariable(value = "id") Integer id) {
	    Otpremnica o = otpremniceRepository.findById(id).get();
	    return new OtpremnicaDTO(o);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody OtpremnicaDTO update(@PathVariable(value = "id") Integer id,
	                                        @RequestBody OtpremnicaDTO dto) {

	    Otpremnica o = otpremniceRepository.findById(id).get();  
		o.setBrojOtpremnice(dto.getBrojOtpremnice());
		o.setDatumOtpremnice(dto.getDatumOtpremnice());
		o.setOsnovica(dto.getOsnovica());
		o.setUkupanPdv(dto.getUkupanPdv());
		o.setIznosZaPlacanje(dto.getIznosZaPlacanje());
	    otpremniceRepository.save(o);
	    return new OtpremnicaDTO(o);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody OtpremnicaDTO delete(@PathVariable(value = "id") Integer id) {
		Otpremnica o = otpremniceRepository.findById(id).get();
	    otpremniceRepository.delete(o);
	    return new OtpremnicaDTO(o);
	}
	
}
