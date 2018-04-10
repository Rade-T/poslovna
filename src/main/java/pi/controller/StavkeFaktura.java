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

import pi.dto.StavkeFaktureDTO;
import pi.model.StavkeFakture;
import pi.repository.IzlaznaFaktoraRepository;
import pi.repository.RobaUslugaRepository;
import pi.repository.StavkeFaktureRepository;

@RequestMapping(path = "/stavkeFakutra")
public class StavkeFaktura {

	@Autowired
	private StavkeFaktureRepository stavkefakturaRepository;
	
	@Autowired
	private IzlaznaFaktoraRepository IFRepo;
	
	@Autowired
	private RobaUslugaRepository RURepo;

	@GetMapping
	public @ResponseBody List<StavkeFaktureDTO> readAll() {
		List<StavkeFakture> fakture = (List<StavkeFakture>) stavkefakturaRepository.findAll();
		List<StavkeFaktureDTO> faktureDTO = new ArrayList<>();
		for (StavkeFakture faktura : fakture) {
			faktureDTO.add(new StavkeFaktureDTO(faktura));
		}
		return faktureDTO;

	}

	@PostMapping
	public @ResponseBody StavkeFakture create(@RequestBody StavkeFaktureDTO dto) {
		StavkeFakture f = new StavkeFakture();

		f.setKolicina(dto.getKolicina());
		f.setCenaPoJediniciMere(dto.getCenaPoJediniciMere());
		f.setRabat(dto.getRabat());
		f.setOsnovica(dto.getOsnovica());
		f.setPdvIznos(dto.getPdvIznos());
		f.setUkupanIznos(dto.getUkupanIznos());
		f.setPdv(dto.getPdv());
		f.setIzlaznaFaktura( IFRepo.findById(dto.getIzlaznaFaktura()).get() );
		f.setRobaUsluga( RURepo.findById(dto.getRobaUsluga()).get() );

		return stavkefakturaRepository.save(f);

	}

	@GetMapping("/{id}")
	public @ResponseBody StavkeFaktureDTO readOne(@PathVariable(value = "id") Integer id) {
		StavkeFakture f = stavkefakturaRepository.findById(id).get();
		return new StavkeFaktureDTO(f);
	}

	@PutMapping("/{id}")
	public @ResponseBody StavkeFaktureDTO update(@PathVariable(value = "id") Integer id,
			@RequestBody StavkeFaktureDTO dto) {

		StavkeFakture f = stavkefakturaRepository.findById(id).get();

		f.setKolicina(dto.getKolicina());
		f.setCenaPoJediniciMere(dto.getCenaPoJediniciMere());
		f.setRabat(dto.getRabat());
		f.setOsnovica(dto.getOsnovica());
		f.setPdvIznos(dto.getPdvIznos());
		f.setUkupanIznos(dto.getUkupanIznos());
		f.setPdv(dto.getPdv());
		f.setIzlaznaFaktura( IFRepo.findById(dto.getIzlaznaFaktura()).get() );
		f.setRobaUsluga( RURepo.findById(dto.getRobaUsluga()).get() );

		stavkefakturaRepository.save(f);
		return new StavkeFaktureDTO(f);
	}

	@DeleteMapping("/{id}")
	public @ResponseBody StavkeFaktureDTO delete(@PathVariable(value = "id") Integer id) {
		StavkeFakture f = stavkefakturaRepository.findById(id).get();
		stavkefakturaRepository.delete(f);
		return new StavkeFaktureDTO(f);
	}

}
