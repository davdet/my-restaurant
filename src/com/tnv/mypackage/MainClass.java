package com.tnv.mypackage;

import java.util.ArrayList;

import com.tnv.mypackage.Alimento.Allergene;
import com.tnv.mypackage.Bevanda.Tipo;
import com.tnv.mypackage.Cibo.Cottura;
import com.tnv.mypackage.Cibo.Portata;

public class MainClass {
	
	public static void main(String[] args) {
		
		ArrayList<Cibo> cibi = new ArrayList<Cibo>();
		ArrayList<Bevanda> bevande = new ArrayList<Bevanda>();
		ArrayList<Tavolo> tavoli = Tavolo.inizializzaTavoli(2, 2);
		
		cibi.add(new Cibo(23F, "Tagliata di manzo", false, false, Alimento.setAllergeni(), Portata.SECONDO, Cottura.BASSA));
		bevande.add(new Bevanda(5F, "Media chiara (0,5l)", true, true, Alimento.setAllergeni(Allergene.GLUTINE), true, Tipo.BIRRA));

		Menu menu = new Menu(25);
		MenuFisso menuFisso = new MenuFisso("menu della casa", 20, Rand.getRandomPiatti(menu.menu, 5));
		
		//Alimento.salvaTuttoSuFile(menu.menu);z
		
		Tavolo tavolo = Tavolo.getTavolo("Int2", tavoli);
		tavolo.assegnaTavolo(2);
		tavolo.ordina(menuFisso, 4);
		tavolo.stampaTavolo();
		tavolo.paga();
		
		//menuFisso.stampaMenu();
		
	}

}
