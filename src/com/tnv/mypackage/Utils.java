package com.tnv.mypackage;

import java.util.ArrayList;
import java.util.Random;

import com.tnv.mypackage.Alimento.Allergene;
import com.tnv.mypackage.Bevanda.Tipo;
import com.tnv.mypackage.Cibo.Cottura;
import com.tnv.mypackage.Cibo.Portata;

public class Utils {

	//restituisce una bevanda random
	public static Bevanda getRandomBevanda() {
		Random rand = new Random();
		ArrayList<String> nomi = new ArrayList<String>();
		
		nomi.add("Negroni");
		nomi.add("Rosso della casa");
		nomi.add("Caffè");
		nomi.add("Grappa");
		nomi.add("Sambuca");
		nomi.add("Acqua gassata");
				
		return new Bevanda((float) rand.nextInt(91) + 10,
							nomi.get(rand.nextInt(nomi.size())),
							rand.nextBoolean(),
							rand.nextBoolean(),
							Utils.getRandomAllergeni(),
							rand.nextBoolean(),
							Utils.getRandomTipo());
	}
	
	//restituisce un cibo random
	public static Cibo getRandomCibo() {
		Random rand = new Random();
		ArrayList<String> nomi = new ArrayList<String>();
		
		nomi.add("Risotto alla milanese");
		nomi.add("Spaghetti alla carbonara");
		nomi.add("Spaghetti cacio e pepe");
		nomi.add("Grigliata mista");
		nomi.add("Capocollo alla griglia");
		nomi.add("Abbacchio alla romana");
		
		return new Cibo((float) rand.nextInt(91) + 10,
				nomi.get(rand.nextInt(nomi.size())),
				rand.nextBoolean(),
				rand.nextBoolean(),
				Utils.getRandomAllergeni(),
				Utils.getRandomPortata(),
				Utils.getRandomCottura());
	}
	
	//restituisce una lista random di allergeni
	public static ArrayList<Allergene> getRandomAllergeni() {
		Random rand = new Random();
		int n = rand.nextInt(Allergene.values().length/4);
		int i;
		ArrayList<Allergene> allergeni = new ArrayList<Allergene>();
		
		if(n > 0)
			for(i = 0; i < n; i++)
				allergeni.add(Allergene.values()[rand.nextInt(Allergene.values().length)]);
				
		
		return allergeni;
	}
	
	//restituisce un valore random di tipo Portata
	public static Portata getRandomPortata() {
		Random rand = new Random();
		return Portata.values()[rand.nextInt(Portata.values().length)];
	}
	
	//restituisce un valore random di tipo Cottura
	public static Cottura getRandomCottura() {
		Random rand = new Random();
		return Cottura.values()[rand.nextInt(Cottura.values().length)];
	}
	
	//restituisce un valore random di tipo Tipo (class Bevanda)
	public static Tipo getRandomTipo() {
		Random rand = new Random();
		return Tipo.values()[rand.nextInt(Tipo.values().length)];
	}

}
