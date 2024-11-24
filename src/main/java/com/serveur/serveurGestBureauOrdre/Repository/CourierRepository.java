package com.serveur.serveurGestBureauOrdre.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.serveur.serveurGestBureauOrdre.Entity.Courier;

public interface CourierRepository extends JpaRepository<Courier , String>{

	Courier findByNumOrdre(String numOrdre);
	
	@Query("SELECT c FROM Courier c WHERE c.numOrdre LIKE %:searchTerm% OR c.destinataire LIKE %:searchTerm% OR c.expediteur LIKE %:searchTerm% OR c.tyype LIKE %:searchTerm%")
    List<Courier> searchCouriers(String searchTerm);
}
