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
	
	//stampa i dati di una bevanda a video
	public void stampaAlimento() {
		super.stampaAlimento();
		System.out.println("Tipologia: " + getTipo().getNome().toUpperCase());
		System.out.println("Alcolico: " + (getAlcolico() ? "sì" : "no"));
		Alimento.stampaAllergeni(Alimento.getStringaAllergeni(getElencoAllergeni()));
	}
	
	//stampa l'elenco delle bevande
	public static void stampaElencoBevande(ArrayList<Bevanda> bevande) {
		for(Bevanda item: bevande)
			item.stampaAlimento();
	}
	
	//salva i dati di una bevanda sul file alimenti.txt
	public static void salvaAlimentoSuFile(Bevanda bevanda) {
		String path = "alimenti.txt";
		String allergeni = Alimento.getStringaAllergeni(bevanda.getElencoAllergeni());
		try {
			File file = new File(path);
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(bevanda.getNome() + " - " + bevanda.getPrezzo() + "€\n");
			bw.write("Adatto a vegani: " + (bevanda.getVegano() ? "sì\n" : "no\n"));
			bw.write("Adatto a vegetariani: " + (bevanda.getVegetariano() ? "sì\n" : "no\n"));
			bw.write("Tipologia: " + bevanda.getTipo().getNome().toUpperCase() + "\n");
			bw.write("Allergeni: " + (allergeni.isEmpty() ? "--" : allergeni) + "\n\n");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//salva tutte le bevande presenti nell'array list nel file alimenti.txt
	public static void salvaTuttiAlimentiSuFile(ArrayList<Bevanda> bevande) {
		for(Bevanda item: bevande) {
			Bevanda.salvaAlimentoSuFile(item);
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
