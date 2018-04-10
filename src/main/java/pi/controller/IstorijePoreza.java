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

import pi.dto.IstorijaPorezaDTO;
import pi.model.IstorijaPoreza;
import pi.repository.IstorijaPorezaRepository;
import pi.repository.PreduzeceRepository;

@RestController
@RequestMapping(path = "/IstorijePoreza")
public class IstorijePoreza {

	@Autowired
	private IstorijaPorezaRepository istorijaPorezaRepository;
	
	@Autowired
	private PreduzeceRepository preduzeceRepository;
	
	@GetMapping
	public @ResponseBody List<IstorijaPorezaDTO> readAll() {
		List<IstorijaPoreza> istorije = (List<IstorijaPoreza>) istorijaPorezaRepository.findAll();
		List<IstorijaPorezaDTO> istorijeDTO = new ArrayList<>();
		for (IstorijaPoreza istorija : istorije) {
			istorijeDTO.add(new IstorijaPorezaDTO(istorija));
		}
		return istorijeDTO;

	}

	@PostMapping
	public @ResponseBody IstorijaPoreza create(@RequestBody IstorijaPorezaDTO dto) {
		IstorijaPoreza c = new IstorijaPoreza();

		c.setDatumPrimene(dto.getDatumPrimene());
		c.setPreduzece(preduzeceRepository.findById(dto.getPreduzece()).get());
		
		return istorijaPorezaRepository.save(c);

	}

	@GetMapping("/{id}")
	public @ResponseBody IstorijaPorezaDTO readOne(@PathVariable(value = "id") Integer id) {
		IstorijaPoreza c = istorijaPorezaRepository.findById(id).get();
		return new IstorijaPorezaDTO(c);
	}

	@PutMapping("/{id}")
	public @ResponseBody IstorijaPorezaDTO update(@PathVariable(value = "id") Integer id, @RequestBody IstorijaPorezaDTO dto) {

		IstorijaPoreza c = istorijaPorezaRepository.findById(id).get();
		c.setId(id);
		c.setDatumPrimene(dto.getDatumPrimene());
		c.setPreduzece(preduzeceRepository.findById(dto.getPreduzece()).get());
		istorijaPorezaRepository.save(c);
		return new IstorijaPorezaDTO(c);
	}

	@DeleteMapping("/{id}")
	public @ResponseBody IstorijaPorezaDTO delete(@PathVariable(value = "id") Integer id) {
		IstorijaPoreza c = istorijaPorezaRepository.findById(id).get();
		istorijaPorezaRepository.delete(c);
		return new IstorijaPorezaDTO(c);
	}

}
