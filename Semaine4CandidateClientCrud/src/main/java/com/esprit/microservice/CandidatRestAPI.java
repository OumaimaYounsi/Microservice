package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/candidats")
public class CandidatRestAPI {
	
	private String title = "Hello; I'm the candidate Microservice for Week 3";
	
	@Autowired
	private CandidatService candidatService;
	
	//http://localhost:8181/hello
	//Resultat -> Message: Hello; I'm the candidate Microservice for Week 3
	//Execution URL: http://localhost:8282/api/candidats/hello
	@RequestMapping("/hello")
	public String sayHello(){
		System.out.println(title);
		return title;
	}
	
	//Configuration de la methode POST
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat){
		return new ResponseEntity<>(candidatService.addCandidat(candidat), HttpStatus.OK);
	}
	
	
	
	//Configuration de la methode PUT
	//Execution URL: http://localhost:8282/api/candidats/1
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Candidat> updateCandidat(@PathVariable(value = "id") int id,
			@RequestBody Candidat candidat){
		return new ResponseEntity<>(candidatService.updateCandidat(id, candidat), HttpStatus.OK);
	}
	
	//Configuation de la methode Delete
	//Execution URL: http://localhost:8282/api/candidats/{id}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Candidat> deleteCandidat(@PathVariable(value = "id") int id){
		candidatService.deleteCandidat(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	//Additional (Optionnel) - N'existe pas dans l'atelier
	//Configuration de la methode GET All
	//Execution URL: http://localhost:8282/api/candidats/
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Candidat> getAllCandidats(){
		return candidatService.GetCandidats();
	}
	
	
	//Additional (Optionnel) - N'existe pas dans l'atelier
	//Configuration de la methode de recherche GET specifique avec PathParam
	//il faut que les noms des methodes ici Candidat Resst API) et celles dans CandidatService n'aient pas le meme nom, sinon ca degere une erreue de mapping
	//Execution URL: http://localhost:8282/api/candidats
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Candidat> searchCandidat(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(candidatService.findCandidat(id) , HttpStatus.OK);
	}
	
	
	

}
