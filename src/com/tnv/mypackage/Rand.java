package com.tnv.mypackage;

import java.util.ArrayList;
import java.util.Random;

import com.tnv.mypackage.Alimento.Allergene;
import com.tnv.mypackage.Bevanda.Tipo;
import com.tnv.mypackage.Cibo.Cottura;
import com.tnv.mypackage.Cibo.Portata;

public class Rand {

	/**
	 * Genera una bevanda random.
	 * @return Oggetto di tipo Bevanda.
	 */
	public static Bevanda getRandomBevanda() {
		Random rand = new Random();
		ArrayList<String> nomi = new ArrayList<String>();
		
		nomi.add("Negroni");
		nomi.add("Rosso della casa");
		nomi.add("Caffè");
		nomi.add("Grappa");
		nomi.add("Sambuca");
		nomi.add("Acqua gassata");
		nomi.add("Coca Cola");
		nomi.add("Red Bull");
		nomi.add("Birra");
		nomi.add("Bianco della casa");
				
		return new Bevanda((float) rand.nextInt(91) + 10,
							nomi.get(rand.nextInt(nomi.size())),
							rand.nextBoolean(),
							rand.nextBoolean(),
							Rand.getRandomAllergeni(),
							rand.nextBoolean(),
							Rand.getRandomTipo());
	}
	
	/**
	 * Genera un cibo random.
	 * @return Oggetto di tipo Cibo.
	 */
	public static Cibo getRandomCibo() {
		Random rand = new Random();
		ArrayList<String> nomi = new ArrayList<String>();
		
		nomi.add("Risotto alla milanese");
		nomi.add("Spaghetti alla carbonara");
		nomi.add("Spaghetti cacio e pepe");
		nomi.add("Grigliata mista");
		nomi.add("Capocollo alla griglia");
		nomi.add("Abbacchio alla romana");
		nomi.add("Cassoeula");
		nomi.add("Salumi della casa");
		nomi.add("Brasato al barolo");
		nomi.add("Bollito con mostarda");
		nomi.add("Tiramisù");
		
		return new Cibo((float) rand.nextInt(91) + 10,
				nomi.get(rand.nextInt(nomi.size())),
				rand.nextBoolean(),
				rand.nextBoolean(),
				Rand.getRandomAllergeni(),
				Rand.getRandomPortata(),
				Rand.getRandomCottura());
	}
	
	/**
	 * Genera un array list di allergeni random.
	 * @return Array list di allergeni.
	 */
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
	
	/**
	 * Genera un elemento ti tipo Portata random.
	 * @return Elemento di tipo Portata.
	 */
	public static Portata getRandomPortata() {
		Random rand = new Random();
		return Portata.values()[rand.nextInt(Portata.values().length)];
	}
	
	/**
	 * Genera un elemento ti tipo Cottura random.
	 * @return Elemento di tipo Cottura.
	 */
	public static Cottura getRandomCottura() {
		Random rand = new Random();
		return Cottura.values()[rand.nextInt(Cottura.values().length)];
	}
	
	/**
	 * Genera un elemento ti tipo Tipo random.
	 * @return Elemento di tipo Tipo.
	 */
	public static Tipo getRandomTipo() {
		Random rand = new Random();
		return Tipo.values()[rand.nextInt(Tipo.values().length)];
	}

	/**
	 * Estrae casualmente un numero di piatti definito dall'utente da un array list di alimenti, e li restituisce sotto
	 * forma di array list.
	 * @param alimenti Array list di alimenti di partenza.
	 * @param numeroPiatti Numero di piatti da estrarre.
	 * @return Array list di alimenti.
	 */
	public static ArrayList<Alimento> getRandomPiatti(ArrayList<Alimento> alimenti, final int numeroPiatti) {
		Random rand = new Random();
		ArrayList<Alimento> piatti = new ArrayList<Alimento>();
		int randomChoice;
		
		for(int i = 0; i < numeroPiatti; i++) {
			randomChoice = rand.nextInt(alimenti.size());
			piatti.add(alimenti.get(randomChoice));
		}
		
		return piatti;
	}

	/**
	 * Restituisce un cibo o una bevanda.
	 * @return Oggetto di tipo Cibo o Bevanda.
	 */
	public static Alimento getRandomAlimento() {
		Random rand = new Random();
		int n = rand.nextInt(2) + 1;
		if(n == 1)
			return getRandomCibo();
		else
			return getRandomBevanda();
	}

}
