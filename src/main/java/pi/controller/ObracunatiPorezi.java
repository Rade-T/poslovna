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

import pi.dto.ObracunatiPorezDTO;
import pi.model.ObracunatiPorez;
import pi.repository.IzlaznaFaktoraRepository;
import pi.repository.ObracunatiPorezRepository;
import pi.repository.PorezRepository;

@RestController
@RequestMapping(path = "/ObracunatiPorez")
public class ObracunatiPorezi {

	@Autowired
	private ObracunatiPorezRepository OPRepository;

	@Autowired
	private PorezRepository PRepository;

	@Autowired
	private IzlaznaFaktoraRepository IFRepository;

	@GetMapping
	public @ResponseBody List<ObracunatiPorezDTO> readAll() {
		List<ObracunatiPorez> porezi = (List<ObracunatiPorez>) OPRepository.findAll();
		List<ObracunatiPorezDTO> poreziDTO = new ArrayList<>();
		for (ObracunatiPorez obracunatiPorez : porezi) {
			poreziDTO.add(new ObracunatiPorezDTO(obracunatiPorez));
		}
		return poreziDTO;

	}

	@PostMapping
	public @ResponseBody ObracunatiPorez create(@RequestBody ObracunatiPorezDTO dto) {
		ObracunatiPorez c = new ObracunatiPorez();

		c.setIznos(dto.getIznos());
		c.setStopa(dto.getStopa());
		c.setPorez(PRepository.findById(dto.getPorez()).get());
		c.setIzlaznaFaktura(IFRepository.findById(dto.getIzlaznaFaktura()).get());

		return OPRepository.save(c);

	}

	@GetMapping("/{id}")
	public @ResponseBody ObracunatiPorezDTO readOne(@PathVariable(value = "id") Integer id) {
		ObracunatiPorez c = OPRepository.findById(id).get();
		return new ObracunatiPorezDTO(c);
	}

	@PutMapping("/{id}")
	public @ResponseBody ObracunatiPorezDTO update(@PathVariable(value = "id") Integer id,
			@RequestBody ObracunatiPorezDTO dto) {

		ObracunatiPorez c = OPRepository.findById(id).get();

		c.setIznos(dto.getIznos());
		c.setStopa(dto.getStopa());
		c.setPorez(PRepository.findById(dto.getPorez()).get());
		c.setIzlaznaFaktura(IFRepository.findById(dto.getIzlaznaFaktura()).get());

		OPRepository.save(c);
		return new ObracunatiPorezDTO(c);
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ObracunatiPorezDTO delete(@PathVariable(value = "id") Integer id) {
		ObracunatiPorez c = OPRepository.findById(id).get();
		OPRepository.delete(c);
		return new ObracunatiPorezDTO(c);
	}

}
