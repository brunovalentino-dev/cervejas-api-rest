package com.bvalentino.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bvalentino.apirest.model.Cerveja;
import com.bvalentino.apirest.repository.CervejaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Cervejas API REST")
@CrossOrigin(origins = "*")
public class CervejasController {
	
	@Autowired
	private CervejaRepository cervejaRepository;
	
	@GetMapping("/cervejas")
	@ApiOperation(value = "Retorna uma lista com as cervejas cadastradas")
	public List<Cerveja> listaCervejas() {
		return cervejaRepository.findAll();
	}
	
	@GetMapping("/cervejas/{id}")
	@ApiOperation(value = "Retorna uma cerveja cadastrada, a partir de seu ID")
	public Optional<Cerveja> buscaCerveja(@PathVariable(value = "id") Long id) {
		return cervejaRepository.findById(id);
	}
	
	@PostMapping("/cervejas/novo")
	@ApiOperation(value = "Salva uma nova cerveja")
	public Cerveja salvaCerveja(@RequestBody Cerveja cerveja) {
		return cervejaRepository.save(cerveja);
	}
	
	@DeleteMapping("/cervejas")
	@ApiOperation(value = "Exclui uma cerveja cadastrada")
	public void deletaCerveja(@RequestBody Cerveja cerveja) {
		cervejaRepository.delete(cerveja);
	}
	
	@PutMapping("/cervejas")
	@ApiOperation(value = "Atualiza uma cerveja cadastrada")
	public Cerveja atualizaCerveja(@RequestBody Cerveja cerveja) {
		return cervejaRepository.save(cerveja);
	}
	
}
