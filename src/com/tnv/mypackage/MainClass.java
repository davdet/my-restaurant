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
		ArrayList<Alimento> alimenti = new ArrayList<Alimento>();
		ArrayList<Cibo> cibi = new ArrayList<Cibo>();
		ArrayList<Bevanda> bevande = new ArrayList<Bevanda>();
		
		cibi.add(new Cibo(23F, "Tagliata di manzo", false, false, Alimento.setAllergeni(), Portata.SECONDO, Cottura.BASSA));
		bevande.add(new Bevanda(5F, "Media chiara (0,5l)", true, true, Alimento.setAllergeni(Allergene.GLUTINE), true, Tipo.BIRRA));
		
		for(int i = 0; i < 20; i++)
			alimenti.add(Alimento.getRandomAlimento());
		
		MenuFisso menu = new MenuFisso("menu della casa", 20, MenuFisso.getPiattiMenu(alimenti, 7));
		
		Alimento.salvaTuttoSuFile(alimenti);
		
		menu.stampaMenu();
		
	}

}
