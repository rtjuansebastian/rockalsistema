package org.anjeco.controller;

import java.util.List;

import org.anjeco.entity.Edicion;
import org.anjeco.service.EdicionService;
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
public class EdicionController {

	@Autowired
	private EdicionService edicionService;

	@GetMapping("edicion/{id}")
	public ResponseEntity<Edicion> find(@PathVariable("id") Integer id) {

		Edicion edicion = edicionService.find(id);
		return new ResponseEntity<Edicion>(edicion,HttpStatus.OK);

	}
	
	@PostMapping("edicion")
	public ResponseEntity<Void> create(@RequestBody Edicion edicion, UriComponentsBuilder builder){
		
		boolean flag= edicionService.create(edicion);
		if(flag==false){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers= new HttpHeaders();
		headers.setLocation(builder.path("/edicion/{id}").buildAndExpand(edicion.getId()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		
	}
	
	@GetMapping("ediciones")
	public ResponseEntity<List<Edicion>> read(){
		
		List<Edicion> list=edicionService.read();
		return new ResponseEntity<List<Edicion>>(list,HttpStatus.OK);
		
	}
	
	@PutMapping("edicion")
	public ResponseEntity<Edicion> update(@RequestBody Edicion edicion){
		
		edicionService.update(edicion);
		return new ResponseEntity<Edicion>(edicion, HttpStatus.OK);
		
	}

	@DeleteMapping("edicion")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		edicionService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	
}
