package com.serveur.serveurGestBureauOrdre.Entity;




import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Courier {

	@Id
	private String numOrdre;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;
	private String destinataire;
	private String expediteur;
	private String tyype;
	private String fileName;
	
	public Courier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Courier(String numOrdre, Date date, String destinataire, String expediteur, String tyype , String fileName) {
		super();
		this.numOrdre = numOrdre;
		this.date = date;
		this.destinataire = destinataire;
		this.expediteur = expediteur;
		this.tyype = tyype;
		this.fileName = fileName;
	}

	public String getNumOrdre() {
		return numOrdre;
	}

	public void setNumOrdre(String numOrdre) {
		this.numOrdre = numOrdre;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	public String getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}

	public String getTyype() {
		return tyype;
	}

	public void setTyype(String tyype) {
		this.tyype = tyype;
	}

	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Courier [numOrdre=" + numOrdre + ", date=" + date + ", destinataire=" + destinataire + ", expediteur="
				+ expediteur + ", tyype=" + tyype + ", fileName=" + fileName + "]";
	}

	
}
