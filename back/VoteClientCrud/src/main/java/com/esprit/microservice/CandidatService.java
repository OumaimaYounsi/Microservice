package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CandidatService {

	
	@Autowired
	private CandidatRepository candidatRepository;
	
	
	//Ajouter un candidat
	public Candidat addCandidat(Candidat candidat) {
		return candidatRepository.save(candidat);
	}
	
	
	//Mettre a jour les informations d'un candidat
	public Candidat updateCandidat(int id, Candidat newCandidat) {
		if(candidatRepository.findById(id).isPresent()) {
			Candidat existingCandidat = candidatRepository.findById(id).get();
			existingCandidat.setNom(newCandidat.getNom());
			existingCandidat.setPrenom(newCandidat.getPrenom());
			existingCandidat.setEmail(newCandidat.getEmail());
			
			return candidatRepository.save(existingCandidat);
		}
		else {
			return null;
		}
	}
	
	
	//Supprimer un candidat
	public String deleteCandidat(int id) {
		if(candidatRepository.findById(id).isPresent()) {
			candidatRepository.deleteById(id);
			return "Le candidat avec l'id " + id + " a ete supprime";
		}
		else {
			return "Le candidat avec l'id " + id + " n'a pas ete supprime";
		}
	}
	
	
	
	//Obtenir tous les candidats
	public  List<Candidat> GetCandidats() {
		return candidatRepository.findAll();
	}
	
	//Methode additionnelle (Pas dans l'atelier)
	//Chercher un candidat
	public Candidat findCandidat(int id) {
		if(candidatRepository.findById(id).isPresent()) {
			Candidat existingCandidat = candidatRepository.findById(id).get();
			return existingCandidat;
		}
		else {
			return null;
		}
	}
	
	
	
}
