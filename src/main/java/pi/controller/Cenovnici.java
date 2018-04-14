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
import pi.model.Cenovnik;
import pi.repository.CenovnikRepository;
import pi.repository.PreduzeceRepository;

@RestController
@RequestMapping(path = "/Cenovnici")
public class Cenovnici {

	@Autowired
	private CenovnikRepository cenovnikRepository;
	
	@Autowired
	private PreduzeceRepository PRepo;

	@GetMapping
	public @ResponseBody List<CenovnikDTO> readAll() {
		List<Cenovnik> cenovnici = (List<Cenovnik>) cenovnikRepository.findAll();
		List<CenovnikDTO> cenovniciDTO = new ArrayList<>();
		for (Cenovnik Cenovnik : cenovnici) {
			cenovniciDTO.add(new CenovnikDTO(Cenovnik));
		}
		return cenovniciDTO;

	}

	@PostMapping
	public @ResponseBody Cenovnik create(@RequestBody CenovnikDTO dto) {
		Cenovnik c = new Cenovnik();

		c.setDatumPrimene(dto.getDatumPrimene());
		try {
			c.setPreduzece(PRepo.findById(dto.getPreduzece()).get());
		} catch (Exception e) {
			c.setPreduzece(null);
		}

		return cenovnikRepository.save(c);

	}

	@GetMapping("/{id}")
	public @ResponseBody CenovnikDTO readOne(@PathVariable(value = "id") Integer id) {
		Cenovnik c = cenovnikRepository.findById(id).get();
		return new CenovnikDTO(c);
	}

	@PutMapping("/{id}")
	public @ResponseBody CenovnikDTO update(@PathVariable(value = "id") Integer id, @RequestBody CenovnikDTO dto) {

		Cenovnik c = cenovnikRepository.findById(id).get();
		c.setDatumPrimene(dto.getDatumPrimene());
		c.setPreduzece(PRepo.findById(dto.getPreduzece()).get());
		cenovnikRepository.save(c);
		return new CenovnikDTO(c);
	}

	@DeleteMapping("/{id}")
	public @ResponseBody CenovnikDTO delete(@PathVariable(value = "id") Integer id) {
		Cenovnik c = cenovnikRepository.findById(id).get();
		cenovnikRepository.delete(c);
		return new CenovnikDTO(c);
	}

}
