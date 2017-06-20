package org.anjeco.controller;

import java.util.List;

import org.anjeco.entity.Genero;
import org.anjeco.service.GeneroService;
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
public class GeneroController {
	
	@Autowired
	private GeneroService generoService;	
	
	@GetMapping("genero/{id}")
	public ResponseEntity<Genero> find(@PathVariable("id") Integer id){
		Genero genero= generoService.find(id);
		return new ResponseEntity<Genero>(genero,HttpStatus.OK);
	}
	
	@PostMapping("genero")
	public ResponseEntity<Void> create(@RequestBody Genero genero, UriComponentsBuilder builder){
		boolean flag = generoService.create(genero);
		if(flag==false){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers= new HttpHeaders();
		headers.setLocation(builder.path("/genero/{id}").buildAndExpand(genero.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@GetMapping("generos")
	public ResponseEntity<List<Genero>> read(){
		List<Genero> list = generoService.read();
		return new ResponseEntity<List<Genero>>(list,HttpStatus.OK);
	}
	
	@PutMapping("genero")
	public ResponseEntity<Genero> update(@RequestBody Genero genero){
		generoService.update(genero);
		return new ResponseEntity<Genero>(genero,HttpStatus.OK);
	}
	
	@DeleteMapping("genero/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
		generoService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
