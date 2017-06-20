package org.anjeco.controller;

import java.util.List;

import org.anjeco.entity.Banda;
import org.anjeco.service.BandaService;
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
public class BandaController {
	
	@Autowired
	private BandaService bandaService;
	
	@GetMapping("banda/{id}")
	public ResponseEntity<Banda> find(@PathVariable("id") Integer id){
		
		Banda banda=bandaService.find(id);
		return new ResponseEntity<Banda>(banda,HttpStatus.OK);
		
	}
	
	@PostMapping("banda")
	public ResponseEntity<Void> create(@RequestBody Banda banda, UriComponentsBuilder builder){
		boolean flag= bandaService.create(banda);
		if(flag==false){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers= new HttpHeaders();
		headers.setLocation(builder.path("/banda/{id}").buildAndExpand(banda.getId()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("bandas")
	public ResponseEntity<List<Banda>> read(){
		List<Banda> list= bandaService.read();
		return new ResponseEntity<List<Banda>>(list,HttpStatus.OK);
	}
	
	@PutMapping("banda")
	public ResponseEntity<Banda> update(@RequestBody Banda banda){
		bandaService.update(banda);
		return new ResponseEntity<Banda>(banda,HttpStatus.OK);
	}
	
	@DeleteMapping("banda/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
		bandaService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
