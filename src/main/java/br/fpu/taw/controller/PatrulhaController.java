package br.fpu.taw.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.fpu.taw.model.Patrulha;
import br.fpu.taw.service.PatrulhaService;

@RestController
@RequestMapping(value="/api/v1/patrulha")
public class PatrulhaController {
	
	@Autowired
	PatrulhaService patrulhaService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Patrulha>> listar() {
		return new ResponseEntity<>(patrulhaService.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Patrulha> buscarPorId(@PathVariable(required=true) Long id) {
		return new ResponseEntity<>(patrulhaService.buscarPorId(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Patrulha> criar(@RequestBody Patrulha patrulha) {
		return new ResponseEntity<>(patrulhaService.criar(patrulha), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Patrulha> atualizar(@RequestBody Patrulha patrulha) {
		return new ResponseEntity<>(patrulhaService.atualizar(patrulha), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> apagar(@PathVariable Long id) {
		patrulhaService.apagar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
