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

import pi.dto.PoreskaStopaDTO;
import pi.repository.PoreskaStopaRepository;

@RestController
@RequestMapping(path = "/PoreskaStopa")
public class PoreskaStopa {
	@Autowired
	private PoreskaStopaRepository poreskaStopaRepository;

	@GetMapping
	public @ResponseBody List<PoreskaStopaDTO> readAll() {
		List<pi.model.PoreskaStopa> poreskaStopa = (List<pi.model.PoreskaStopa>) poreskaStopaRepository.findAll();
		List<PoreskaStopaDTO> poreskaStopaDTO = new ArrayList<>();
		for (pi.model.PoreskaStopa poreskaStopa2 : poreskaStopa) {
			PoreskaStopaDTO.add(new PoreskaStopaDTO(poreskaStopa2));
		}
		return poreskaStopaDTO;
	}

	@PostMapping
	public @ResponseBody pi.model.PoreskaStopa create (@RequestBody PoreskaStopaDTO dto){
		pi.model.PoreskaStopa ps = new pi.model.PoreskaStopa();
		ps.setIstorijaPoreza(dto.getIstorijaPoreza());
		ps.setIznosStope(dto.getIznosStope());
		ps.setPorez(dto.getPorez());
		return poreskaStopaRepository.save(ps);
	}

	@GetMapping("/{id}")
	public @ResponseBody PoreskaStopaDTO readOne(@PathVariable(value = "id") Integer id) {
		pi.model.PoreskaStopa ps = poreskaStopaRepository.findById(id).get();
		return new PoreskaStopaDTO(ps);

	}

	@PutMapping("/{id}")
	public @ResponseBody PoreskaStopaDTO update(@PathVariable(value = "id") Integer id,
			@RequestBody PoreskaStopaDTO dto) {
		pi.model.PoreskaStopa ps = poreskaStopaRepository.findById(id).get();
		ps.setIstorijaPoreza(dto.getIstorijaPoreza());
		ps.setIznosStope(dto.getIznosStope());
		ps.setPorez(dto.getPorez());
		poreskaStopaRepository.save(ps);
		return new PoreskaStopaDTO(ps);
	}

	@DeleteMapping("/{id}")
	public @ResponseBody PoreskaStopaDTO delete(@PathVariable(value = "id") Integer id) {
		pi.model.PoreskaStopa ps = poreskaStopaRepository.findById(id).get();
		poreskaStopaRepository.delete(ps);
		return new PoreskaStopaDTO(ps);

	}

}
