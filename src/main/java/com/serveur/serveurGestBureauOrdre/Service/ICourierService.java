package com.serveur.serveurGestBureauOrdre.Service;

import java.util.List;

import com.serveur.serveurGestBureauOrdre.Entity.Courier;

public interface ICourierService {
	List<Courier> getCourier();
	
	void addCourier (Courier courier);
	
	void updateCourier (Courier courier);
	
	void deleteCourier (String numOrdre );

	List<Courier> searchCouriers(String searchTerm);

	
	Courier getCourierByNumOrdre(String numOrdre);
}
