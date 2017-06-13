package org.anjeco.controller;

import java.util.List;

import org.anjeco.entity.Integrante;
import org.anjeco.service.IntegranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("rockalsistema")
public class IntegranteController {

	@Autowired
	private IntegranteService integranteService;

	@GetMapping("integrante/{id}")
	public ResponseEntity<Integrante> find(@PathVariable("id") Integer id) {
		Integrante integrante = integranteService.find(id);
		return new ResponseEntity<Integrante>(integrante, HttpStatus.OK);
	}
	
	@PostMapping("integrante")
	public ResponseEntity<Void>Create(@RequestBody Integrante integrante, UriComponentsBuilder builder){
		boolean flag=integranteService.create(integrante);
		if(flag==false){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers= new HttpHeaders();
		headers.setLocation(builder.path("/integrante/{id}").buildAndExpand(integrante.getId()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}	
	
	@GetMapping("integrantes")
	public ResponseEntity<List<Integrante>>read(){
		List<Integrante> integrantes = integranteService.read();
		return new ResponseEntity<List<Integrante>>(integrantes,HttpStatus.OK);
	}
	
	@PutMapping("integrante")
	public ResponseEntity<Integrante>update(@RequestBody Integrante integrante){
		integranteService.update(integrante);
		return new ResponseEntity<Integrante>(integrante,HttpStatus.OK);
	}
	
	@DeleteMapping()
	public ResponseEntity<Void>delete(@PathVariable("id") Integer id){
		integranteService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
