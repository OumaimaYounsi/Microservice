package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ElecteurService {

	
	@Autowired
	private ElecteurRepository electeurRepository;
	
	
	//Ajouter un candidat
	public Electeur addElecteur(Electeur electeur) {
		return electeurRepository.save(electeur);
	}
	
	
	//Mettre a jour les informations d'un electeur
	public Electeur updateElecteur(int id, Electeur newElecteur) {
		if(electeurRepository.findById(id).isPresent()) {
			Electeur existingElecteur = electeurRepository.findById(id).get();
			existingElecteur.setNom(newElecteur.getNom());
			existingElecteur.setPrenom(newElecteur.getPrenom());
			existingElecteur.setEmail(newElecteur.getEmail());
			
			return electeurRepository.save(existingElecteur);
		}
		else {
			return null;
		}
	}
	
	
	//Supprimer un candidat
	public String deleteElecteur(int id) {
		if(electeurRepository.findById(id).isPresent()) {
			electeurRepository.deleteById(id);
			return "Le Electeur avec l'id " + id + " a ete supprime";
		}
		else {
			return "Le Electeur avec l'id " + id + " n'a pas ete supprime";
		}
	}
	
	
	
	//Obtenir tous les candidats
	public  List<Electeur> GetElecteur() {
		return electeurRepository.findAll();
	}
	
	//Methode additionnelle (Pas dans l'atelier)
	//Chercher un candidat
	public Electeur findElecteur(int id) {
		if(electeurRepository.findById(id).isPresent()) {
			Electeur existingElecteur = electeurRepository.findById(id).get();
			return existingElecteur;
		}
		else {
			return null;
		}
	}
	
	
	
}
