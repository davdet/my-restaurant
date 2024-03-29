package com.tnv.mypackage;

import java.util.ArrayList;

public abstract class Alimento {

	protected enum Allergene{
		ARACHIDI_E_DERIVATI("Arachidi e derivati"),
		CROSTACEI("Crostacei"),
		FRUTTA_A_GUSCIO("Frutta a guscio"),
		GLUTINE("Glutine"),
		LATTE_E_DERIVATI("Latte e derivati"),
		LUPINI("Lupini"),
		MOLLUSCHI("Molluschi"),
		SENAPE("Senape"),
		PESCE("Pesce"),
		SEDANO("Sedano"),
		SESAMO("Sesamo"),
		ANIDRIDE_SOLFOROSA_E_SOLFITI("Anidride solforosa e solfiti"),
		SOIA("Soia"),
		UOVA_E_DERIVATI("Uova e derivati");
		
		private String nome;
		
		private Allergene(String nome) {
			this.nome = nome;
		}
		
		public String getNome() {
			return nome;
		}
	}
	
	private Float prezzo; // prezzo del piatto
	private String nome; // nome del piatto
	private Boolean vegano; // true se il piatto è adatto ai vegani
	private Boolean vegetariano; // true se il piatto è adatto ai vegetariani
	private ArrayList<Allergene> elencoAllergeni = new ArrayList<Allergene>(); // elenco degli allergeni dell'alimento
	
//	public Alimento() {
//		super();
//	}

	public Alimento(Float prezzo, String nome, Boolean vegano, Boolean vegetariano,
			ArrayList<Allergene> elencoAllergeni) {
		super();
		this.prezzo = prezzo;
		this.nome = nome;
		this.vegano = vegano;
		this.vegetariano = vegetariano;
		this.elencoAllergeni = elencoAllergeni;
	}
	
	/**
	 * Riceve in ingresso uno o più allergeni e compone un array list di allergeni.
	 * @param list Allergeni in ingresso.
	 * @return Array list di allergeni.
	 */
	public static ArrayList<Allergene> setAllergeni(Allergene... list) {
		ArrayList<Allergene> allergeni = new ArrayList<Allergene>();
		
		for(Allergene item: list)
			allergeni.add(item);
		
		return allergeni;
	}
	
	/**
	 * Trasforma un array list di allergeni in una stringa attingendo dalla proprietà nome della enum Allergene.
	 * @param elencoAllergeni Array list di allergeni.
	 * @return Stringa di allergeni.
	 */
	public static String getStringaAllergeni(ArrayList<Allergene> elencoAllergeni) {
		ArrayList<String> allergeni = new ArrayList<String>();
		
		for(Allergene item: elencoAllergeni) {
			allergeni.add(item.getNome());
		}
		
		return allergeni.toString().replace("[", "").replace("]", ""); // rimpiazza le parentesi quadre con un carattere vuoto
	}
	
	/**
	 * Aggiunge gli elementi di un array list di tipo Cibo ad un array list di alimenti.
	 * @param alimenti Array list di alimenti.
	 * @param cibi Array list di tipo Cibo.
	 */
	public static void aggiungiCibi(ArrayList<Alimento> alimenti, ArrayList<Cibo> cibi) {
		for(Cibo item: cibi)
			alimenti.add(item);
	}
	
	/**
	 * Aggiunge gli elementi di un array list di tipo Bevanda ad un array list di alimenti.
	 * @param alimenti Array list di alimenti.
	 * @param bevande Array list di tipo Bevanda.
	 */
	public static void aggiungiBevande(ArrayList<Alimento> alimenti, ArrayList<Bevanda> bevande) {
		for(Bevanda item: bevande)
			alimenti.add(item);
	}
	
	/**
	 * Stampa a video i dati di un alimento. Soggetto ad override dalle classi Cibo e Bevanda.
	 */
	public void stampaAlimento() {
		System.out.println(getNome() + " - " + getPrezzo() + "€");
		System.out.println("Adatto a vegani: " + (getVegano() ? "sì" : "no"));
		System.out.println("Adatto a vegetariani: " + (getVegetariano() ? "sì" : "no"));
	}
	
	/**
	 * Stampa a video un array list di alimenti.
	 * @param alimenti Array list di alimenti
	 */
	public static void stampaElencoAlimenti(ArrayList<Alimento> alimenti) {
		for(Alimento item: alimenti) {
			item.stampaAlimento();
		}		
	}
	
	/**
	 * Stampa una stringa di allergeni o, nel caso di una stringa vuota, i caratteri "--".
	 * @param allergeni Stringa di allergeni.
	 */
	public static void stampaAllergeni(String allergeni) {
		System.out.println("Allergeni: " + (allergeni.isEmpty() ? "--" : allergeni) + "\n"); // se la stringa è vuota stampa "--", altrimenti il suo contenuto
	}
	
	/**
	 * Metodo astratto soggetto ad override nelle classi Cibo e Bevanda.
	 */
	public abstract void salvaSuFile();
	
	/**
	 * Salva un array list di alimenti su un file.
	 * @param alimenti Array list di alimenti.
	 */
	public static void salvaTuttoSuFile(ArrayList<Alimento> alimenti) {
		for(Alimento item: alimenti)
			item.salvaSuFile();
	}

	/* G/S */	
	protected Float getPrezzo() {
		return prezzo;
	}
	
	public String getNome() {
		return nome;
	}

	public Boolean getVegano() {
		return vegano;
	}

	public Boolean getVegetariano() {
		return vegetariano;
	}

	public ArrayList<Allergene> getElencoAllergeni() {
		return elencoAllergeni;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setVegano(Boolean vegano) {
		this.vegano = vegano;
	}

	public void setVegetariano(Boolean vegetariano) {
		this.vegetariano = vegetariano;
	}

	public void setElencoAllergeni(ArrayList<Allergene> elencoAllergeni) {
		this.elencoAllergeni = elencoAllergeni;
	}
	
}
