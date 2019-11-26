package com.tnv.mypackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Bevanda extends Alimento{

	public enum Tipo{
		VINO("Vino"),
		BIRRA("Birra"),
		BIBITA("Bibita"),
		AMARO("Amaro"),
		CAFFETTERIA("Caffetteria");
		
		private String nome;
		
		private Tipo(String nome) {
			this.nome = nome;
		}
		
		public String getNome() {
			return nome;
		}
	}
	
	Boolean alcolico; //Determina se una bibita è alcolica
	Tipo tipo; //Rappresenta la bevanda scelta
	
	public Bevanda(Float prezzo, String nome, Boolean vegano, Boolean vegetariano,
			ArrayList<Allergene> elencoAllergeni, Boolean alcolico, Tipo tipo) {
		super(prezzo, nome, vegano, vegetariano, elencoAllergeni);
		this.alcolico = alcolico;
		this.tipo = tipo;
	}	
	
	/**
	 * Stampa a video i dati di una bevanda. Richiama il metodo della classe padre per stampare le proprietà comuni
	 * agli oggetti del tipo Cibo.
	 */
	@Override
	public void stampaAlimento() {
		super.stampaAlimento();
		System.out.println("Tipologia: " + getTipo().getNome().toUpperCase());
		System.out.println("Alcolico: " + (getAlcolico() ? "sì" : "no"));
		Alimento.stampaAllergeni(Alimento.getStringaAllergeni(getElencoAllergeni()));
	}
	
	/**
	 * Stampa un array list di bevande.
	 * @param bevande Array list di bevande.
	 */
	public static void stampaElencoBevande(ArrayList<Bevanda> bevande) {
		for(Bevanda item: bevande)
			item.stampaAlimento();
	}
	
	/**
	 * Salva un elemento di tipo Bevanda su file.
	 */
	@Override
	public void salvaSuFile() {
		String path = "alimenti.txt";
		String allergeni = Alimento.getStringaAllergeni(getElencoAllergeni());
		try {
			File file = new File(path);
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(getNome() + " - " + getPrezzo() + "€\n");
			bw.write("Adatto a vegani: " + (getVegano() ? "sì\n" : "no\n"));
			bw.write("Adatto a vegetariani: " + (getVegetariano() ? "sì\n" : "no\n"));
			bw.write("Tipologia: " + getTipo().getNome().toUpperCase() + "\n");
			bw.write("Allergeni: " + (allergeni.isEmpty() ? "--" : allergeni) + "\n\n");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* G/S */
	public Boolean getAlcolico() {
		return alcolico;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setAlcolico(Boolean alcolico) {
		this.alcolico = alcolico;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}
