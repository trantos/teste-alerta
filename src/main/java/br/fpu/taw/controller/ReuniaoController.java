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

import br.fpu.taw.model.Reuniao;
import br.fpu.taw.service.ReuniaoService;

@RestController
@RequestMapping(value="/api/v1/reuniao")
public class ReuniaoController {
	
	@Autowired
	ReuniaoService reuniaoService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Reuniao>> listar() {
		return new ResponseEntity<>(reuniaoService.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Reuniao> buscarPorId(@PathVariable(required=true) Long id) {
		return new ResponseEntity<>(reuniaoService.buscarPorId(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Reuniao> criar(@RequestBody Reuniao reuniao) {
		return new ResponseEntity<>(reuniaoService.criar(reuniao), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Reuniao> atualizar(@RequestBody Reuniao reuniao) {
		return new ResponseEntity<>(reuniaoService.atualizar(reuniao), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> apagar(@PathVariable Long id) {
		reuniaoService.apagar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
