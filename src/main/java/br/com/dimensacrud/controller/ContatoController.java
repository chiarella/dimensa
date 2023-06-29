package br.com.dimensacrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dimensacrud.dto.ContatoDTO;
import br.com.dimensacrud.service.ContatoService;

@RestController
@RequestMapping(value = "/v1/contato")
public class ContatoController {
	
	@Autowired
	private ContatoService service;
	
	@PostMapping()
	public ResponseEntity<ContatoDTO> save(@RequestBody ContatoDTO contatoDTO) {
	return new ResponseEntity<>(service.save(contatoDTO), HttpStatus.CREATED);
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<ContatoDTO>> findAll() {
	return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{idContato}")
	@ResponseBody
	public ResponseEntity<ContatoDTO> contatoById(@PathVariable Long idContato) {
		Optional<ContatoDTO> optResponse = service.findById(idContato);
	return ResponseEntity.ok(optResponse.get());
	}
	
	@DeleteMapping("/{idContato}")
	@ResponseBody
	public ResponseEntity<String> deleteContatoByIdContato(@PathVariable Long idContato) {
		service.delete(idContato);
	return ResponseEntity.ok("Excluido com sucesso!!!");
	}
	
	@PutMapping("/{idContato}")
	@ResponseBody
	public ResponseEntity<ContatoDTO> updateContato(@RequestBody ContatoDTO contatoDTO, @PathVariable Long idContato) {
		ContatoDTO dto = service.update(contatoDTO, idContato);
	return ResponseEntity.ok(dto);	
	}
	
	@PatchMapping("/{idContato}/{telefone}")
	public ResponseEntity<ContatoDTO> updateTelefone(@PathVariable Long idContato, @PathVariable String telefone) {
		ContatoDTO dto = service.updateTelefone(idContato, telefone);
	return ResponseEntity.ok(dto);	
	} 
	

}
