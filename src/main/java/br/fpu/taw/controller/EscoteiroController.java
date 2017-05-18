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

import br.fpu.taw.model.Escoteiro;
import br.fpu.taw.service.EscoteiroService;

@RestController
@RequestMapping(value="/api/v1/escoteiro")
public class EscoteiroController {
	
	@Autowired
	EscoteiroService escoteiroService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Escoteiro>> listar() {
		return new ResponseEntity<>(escoteiroService.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{registro}", method = RequestMethod.GET)
	public ResponseEntity<Escoteiro> buscarPorId(@PathVariable(required=true) String registro) {
		return new ResponseEntity<>(escoteiroService.buscarPorRegistro(registro), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Escoteiro> criar(@RequestBody Escoteiro patrulha) {
		return new ResponseEntity<>(escoteiroService.criar(patrulha), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Escoteiro> atualizar(@RequestBody Escoteiro patrulha) {
		return new ResponseEntity<>(escoteiroService.atualizar(patrulha), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{registro}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> apagar(@PathVariable String registro) {
		escoteiroService.apagar(registro);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
