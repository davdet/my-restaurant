package com.tnv.mypackage;

import java.util.ArrayList;

import com.tnv.mypackage.Alimento.Allergene;
import com.tnv.mypackage.Bevanda.Tipo;
import com.tnv.mypackage.Cibo.Cottura;
import com.tnv.mypackage.Cibo.Portata;

public class MainClass {

	public MainClass() {

	}
	
	public static void main(String[] args) {
		//Creare un vettore di alimenti 
		//Assegnare valori via codice (2 elementi: uno cibo e uno bevanda)
		//vedi classe bevanda/cibo/alimento
		ArrayList<Alimento> alimenti = new ArrayList <Alimento>();
		ArrayList<Cibo> cibi = new ArrayList <Cibo>();
		ArrayList<Bevanda> bevande = new ArrayList <Bevanda>();
		
		cibi.add(new Cibo(23F, "Tagliata di manzo", false, false, Alimento.setAllergeni(), Portata.SECONDO, Cottura.BASSA));
		bevande.add(new Bevanda(5F, "Media chiara (0,4l)", true, true, Alimento.setAllergeni(Allergene.GLUTINE), true, Tipo.BIRRA));
		cibi.add(Cibo.getRandomCibo());
		
		Alimento.aggiungiCibi(alimenti, cibi);
		Alimento.aggiungiBevande(alimenti, bevande);
		Alimento.stampaElencoAlimenti(alimenti);
	}

}