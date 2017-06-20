package org.anjeco.controller;

import java.util.List;

import org.anjeco.entity.BandaIntegrante;
import org.anjeco.service.BandaIntegranteService;
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
public class BandaIntegranteController {

	@Autowired
	private BandaIntegranteService biService;

	@GetMapping("bandaintegrante/{id}")
	public ResponseEntity<BandaIntegrante> find(@PathVariable("id") Integer id) {

		BandaIntegrante bandaIntegrante = biService.find(id);
		return new ResponseEntity<BandaIntegrante>(bandaIntegrante, HttpStatus.OK);

	}

	@PostMapping("bandaintegrante")
	public ResponseEntity<Void> create(@RequestBody BandaIntegrante bandaIntegrante, UriComponentsBuilder builder) {

		boolean flag = biService.create(bandaIntegrante);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/bandaintegrante/{id}").buildAndExpand(bandaIntegrante.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@GetMapping("bandaintegrante")
	public ResponseEntity<List<BandaIntegrante>> read() {

		List<BandaIntegrante> list = biService.read();
		return new ResponseEntity<List<BandaIntegrante>>(list, HttpStatus.OK);

	}

	@PutMapping("bandaintegrante")
	public ResponseEntity<BandaIntegrante> update(@RequestBody BandaIntegrante bandaIntegrante) {

		biService.update(bandaIntegrante);
		return new ResponseEntity<BandaIntegrante>(bandaIntegrante, HttpStatus.OK);

	}
	
	@DeleteMapping("bandaintegrante/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
		
		biService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
}
