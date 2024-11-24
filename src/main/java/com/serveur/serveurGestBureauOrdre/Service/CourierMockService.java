package com.serveur.serveurGestBureauOrdre.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.serveur.serveurGestBureauOrdre.Entity.Courier;

public class CourierMockService implements ICourierService {

	private List<Courier> couriers;
	
	public CourierMockService() {
		couriers = new ArrayList<Courier>();
		
		couriers.add( new Courier("1",Date.valueOf("2024-08-26"), "de", "exp", "courierDep" , ""));
		couriers.add( new Courier("2",Date.valueOf("2024-08-26"), "dest", "exp", "courierDep", "" ));
		couriers.add( new Courier("3",Date.valueOf("2024-08-26"), "dest", "exp", "courierDep", ""));
	}
	@Override
	public List<Courier> getCourier() {
		return couriers;
	}

	@Override
	public void addCourier(Courier courier) {
		couriers.add(courier);
		
	}

	@Override
	public void updateCourier(Courier updatedCourier) {
	    for (int i = 0; i < couriers.size(); i++) {
	        if (couriers.get(i).getNumOrdre().equals(updatedCourier.getNumOrdre())) {
	            couriers.set(i, updatedCourier); // Remplace l'élément existant par la version mise à jour
	            break;
	        }
	    }
	}

	@Override
	public void deleteCourier(String numOrdre) {
		 couriers.removeIf(courier -> courier.getNumOrdre().equals(numOrdre));
	}
	@Override
	public List<Courier> searchCouriers(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}
	public Courier getCourierByNumOrdre(String numOrdre) {
		// TODO Auto-generated method stub
		return null;
	}

}

