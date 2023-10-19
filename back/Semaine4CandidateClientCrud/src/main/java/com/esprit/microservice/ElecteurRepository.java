package com.esprit.microservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ElecteurRepository extends JpaRepository<Electeur, Integer> {
	//Requete de recherche d'un electeur par son nom
	//http://localhost:8181/candidats/search/candidatByNom?nom=Sarra
	@Query("select c from Electeur c where c.nom like :nom")
	public Page<Electeur> electeurByNom(@Param("nom") String n, Pageable pageable);
	
}
