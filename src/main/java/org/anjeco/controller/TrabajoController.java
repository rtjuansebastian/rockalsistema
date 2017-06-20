package org.anjeco.controller;

import java.util.List;

import org.anjeco.entity.Trabajo;
import org.anjeco.service.TrabajoService;
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
public class TrabajoController {

	@Autowired
	private TrabajoService trabajoService;

	@GetMapping("trabajo/{id}")
	public ResponseEntity<Trabajo> find(@PathVariable("id") Integer id) {

		Trabajo trabajo = trabajoService.find(id);
		return new ResponseEntity<Trabajo>(trabajo, HttpStatus.OK);

	}

	@PostMapping("trabajo")
	public ResponseEntity<Void> create(@RequestBody Trabajo trabajo, UriComponentsBuilder builder) {

		boolean flag = trabajoService.create(trabajo);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/trabajo/{id}").buildAndExpand(trabajo.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@GetMapping("trabajos")
	public ResponseEntity<List<Trabajo>> read() {
		List<Trabajo> list = trabajoService.read();
		return new ResponseEntity<List<Trabajo>>(list, HttpStatus.OK);
	}

	@PutMapping("trabajo")
	public ResponseEntity<Trabajo> update(@RequestBody Trabajo trabajo) {

		trabajoService.update(trabajo);
		return new ResponseEntity<Trabajo>(trabajo, HttpStatus.OK);
	}

	@DeleteMapping("trabajo/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {

		trabajoService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}
}
