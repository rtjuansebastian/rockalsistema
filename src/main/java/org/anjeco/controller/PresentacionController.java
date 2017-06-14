package org.anjeco.controller;

import java.util.List;

import org.anjeco.entity.Presentacion;
import org.anjeco.service.PresentacionService;
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
public class PresentacionController {
	
	@Autowired
	private PresentacionService presentacionService;
	
	@GetMapping("presentacion/{id}")
	public ResponseEntity<Presentacion> find(@PathVariable Integer id){
		
		Presentacion presentacion=presentacionService.find(id);
		return new ResponseEntity<Presentacion>(presentacion,HttpStatus.OK);
		
	}
	
	@PostMapping("presentacion")
	public ResponseEntity<Void> create(@RequestBody Presentacion presentacion, UriComponentsBuilder builder){
		
		boolean flag= presentacionService.create(presentacion);
		if(flag==false){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers= new HttpHeaders();
		headers.setLocation(builder.path("/presentacion/{id}").buildAndExpand(presentacion.getId()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		
	}
	
	@GetMapping("presentaciones")
	public ResponseEntity<List<Presentacion>> read(){
		
		List<Presentacion> list=presentacionService.read();
		return new ResponseEntity<List<Presentacion>>(list,HttpStatus.OK);
		
	}
	
	@PutMapping("presentacion")
	public ResponseEntity<Presentacion> update(@RequestBody Presentacion presentacion){
		
		presentacionService.update(presentacion);
		return new ResponseEntity<Presentacion>(presentacion,HttpStatus.OK);
		
	}
	
	@DeleteMapping("presentacion/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
		
		presentacionService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
}
