package com.tnv.mypackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cibo extends Alimento{
	
	public enum Portata{
		ANTIPASTO("Antipasto"),
		PRIMO("Primo"),
		SECONDO("Secondo"),
		CONTORNO("Contorno"),
		DESSERT("Dessert");
		
		private String nome;

		private Portata(String nome) {
			this.nome = nome;
		}
		
		public String getNome() {
			return nome;
		}
	}
	
	public enum Cottura{
		BASSA("Bassa"),
		MEDIA("Media"),
		ALTA("Alta");
		
		private String nome;
		
		private Cottura(String nome) {
			this.nome = nome;
		}
		
		public String getNome() {
			return nome;
		}
	}
	
	Portata tipoPortata; 
	Cottura tipoCottura;
	
	public Cibo(Float prezzo, String nome, Boolean vegano, Boolean vegetariano,
			ArrayList<Allergene> elencoAllergeni, Portata p) {
		super(prezzo, nome, vegano, vegetariano, elencoAllergeni);
		this.tipoPortata = p;
		this.tipoCottura = Cottura.MEDIA;
	}
	
	public Cibo(Float prezzo, String nome, Boolean vegano, Boolean vegetariano,
			ArrayList<Allergene> elencoAllergeni, Portata p, Cottura c) {
		super(prezzo, nome, vegano, vegetariano, elencoAllergeni);
		this.tipoPortata = p;
		this.tipoCottura = c;
	}

	public Portata getTipoPortata() {
		return tipoPortata;
	}

	public Cottura getTipoCottura() {
		return tipoCottura;
	}

	public void setTipoPortata(Portata tipoPortata) {
		this.tipoPortata = tipoPortata;
	}

	public void setTipoCottura(Cottura tipoCottura) {
		this.tipoCottura = tipoCottura;
	}

	
	//stampa i dati di un cibo a video
	public void stampaAlimento() {
		super.stampaAlimento();
		System.out.println("Tipologia: " + getTipoPortata().getNome().toUpperCase());
		System.out.println("Cottura: " + getTipoCottura().getNome().toUpperCase());
		Alimento.stampaAllergeni(Alimento.getStringaAllergeni(getElencoAllergeni())); //
	}
	
	//stampa l'elenco dei cibi
	public static void stampaElencoCibi(ArrayList<Cibo> cibi) {
		for(Cibo item: cibi)
			item.stampaAlimento();
	}
	
	//restituisce un cibo random
	public static Cibo getRandomCibo() {
		return new Cibo(10F, "Spaghetti alla carbonara", false, false, Alimento.setAllergeni(Allergene.GLUTINE, Allergene.UOVA_E_DERIVATI), Portata.PRIMO);
	}
	
	public static void salvaAlimentoSuFile(Cibo cibo) {
		String path = "alimento.txt";
		String allergeni = Alimento.getStringaAllergeni(cibo.getElencoAllergeni());
		try {
			File file = new File(path);
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(cibo.getNome() + " - " + cibo.getPrezzo() + "€\n");
			bw.write("Adatto a vegani: " + (cibo.getVegano() ? "sì\n" : "no\n"));
			bw.write("Adatto a vegetariani: " + (cibo.getVegetariano() ? "sì\n" : "no\n"));
			bw.write("Tipologia: " + cibo.getTipoPortata().getNome().toUpperCase() + "\n");
			bw.write("Cottura: " + cibo.getTipoCottura().getNome().toUpperCase() + "\n");
			bw.write("Allergeni: " + (allergeni.isEmpty() ? "--" : allergeni) + "\n");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
