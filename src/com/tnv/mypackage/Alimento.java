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
	
	private Float prezzo; //Prezzo del piatto
	private String nome; //Nome del piatto
	private Boolean vegano; //True se il piatto è adatto ai vegani
	private Boolean vegetariano; //True se il piatto è adatto ai vegetariani
	private ArrayList<Allergene> elencoAllergeni = new ArrayList<Allergene>(); //Elenco degli allergeni dell'alimento
	
	public Alimento() {
		super();
	}

	public Alimento(Float prezzo, String nome, Boolean vegano, Boolean vegetariano,
			ArrayList<Allergene> elencoAllergeni) {
		super();
		this.prezzo = prezzo;
		this.nome = nome;
		this.vegano = vegano;
		this.vegetariano = vegetariano;
		this.elencoAllergeni = elencoAllergeni;
	}
	
	//setta gli allergeni per una singola portata (utilizzata dai costruttori di cibi e bevande)
	public static ArrayList<Allergene> setAllergeni(Allergene... list) {
		ArrayList<Allergene> allergeni = new ArrayList <Allergene>();
		
		for(Allergene item: list)
			allergeni.add(item);
		
		return allergeni;
	}

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
	
	//Trasforma l'array list degli allergeni in una stringa attingendo dalla proprietà nome della enum Allergene
	public static String getStringaAllergeni(ArrayList<Allergene> elencoAllergeni) {
		ArrayList<String> allergeni = new ArrayList<String>();
		
		for(Allergene item: elencoAllergeni) {
			allergeni.add(item.getNome());
		}
		
		return allergeni.toString().replace("[", "").replace("]", ""); //rimpiazza le parentesi quadre con un carattere vuoto
	}
	
	//aggiunge i cibi all'array list degli alimenti
	public static void aggiungiCibi(ArrayList<Alimento> alimenti, ArrayList<Cibo> cibi) {
		for(Cibo item: cibi)
			alimenti.add(item);
	}
	
	//aggiunge le bevande all'array list degli alimenti
	public static void aggiungiBevande(ArrayList<Alimento> alimenti, ArrayList<Bevanda> bevande) {
		for(Bevanda item: bevande)
			alimenti.add(item);
	}
	
	//stampa i dati di un alimento a video
	public void stampaAlimento() {
		System.out.println(this.getNome() + " - " + this.getPrezzo() + "€");
		System.out.println("Adatto a vegani: " + (this.getVegano() ? "sì" : "no"));
		System.out.println("Adatto a vegetariani: " + (this.getVegetariano() ? "sì" : "no"));
	}
	
	//stampa l'elenco degli alimenti (sia bevande che cibi)
	public static void stampaElencoAlimenti(ArrayList<Alimento> alimenti) {
		for(Alimento item: alimenti) {
			item.stampaAlimento();
		}		
	}
	
	//stampa la lista degli allergeni
	public static void stampaAllergeni(String allergeni) {
		System.out.println("Allergeni: " + (allergeni.isEmpty() ? "--" : allergeni) + "\n"); //se la stringa è vuota stampa "--", altrimenti il suo contenuto
	}
	
	//restituisce un alimento (cibo o bevanda) random
	public static Alimento getRandomAlimento() {
		return Cibo.getRandomCibo();
		//return Bevanda.getRandomBevanda();
	}
	
	//restituisce un elenco di allergeni random
	public static ArrayList<Allergene> getRandomAllergeni() {		
		return Alimento.setAllergeni(Allergene.ANIDRIDE_SOLFOROSA_E_SOLFITI, Allergene.GLUTINE);
	}
	
	public static void salvaAlimentoSuFile() {
		
	}
	
}
