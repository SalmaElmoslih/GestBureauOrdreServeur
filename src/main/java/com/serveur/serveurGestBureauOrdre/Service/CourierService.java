package com.serveur.serveurGestBureauOrdre.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.serveur.serveurGestBureauOrdre.Entity.Courier;
import com.serveur.serveurGestBureauOrdre.Repository.CourierRepository;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;


import java.net.MalformedURLException;

@Service 
@Primary
public class CourierService implements ICourierService{

	  @Autowired
	private CourierRepository courierRep;
	
	@Override
	public List<Courier> getCourier() {
		
		return courierRep.findAll();
	}

	@Override
	public void addCourier(Courier courier) {
		courierRep.save(courier);
		
	}

	@Override
	public void updateCourier(Courier courier) {
		courierRep.save(courier);
		
	}

	@Override
	public void deleteCourier(String numOrdre) {
		Courier courier = new Courier();
		courier.setNumOrdre(numOrdre);
		courierRep.delete(courier);
		
	}

	@Override
	public List<Courier> searchCouriers(String searchTerm) {
		
		 return courierRep.searchCouriers(searchTerm);
	}

	public Courier getCourierByNumOrdre(String numOrdre) {
		  return courierRep.findByNumOrdre(numOrdre);
	}

	
}
