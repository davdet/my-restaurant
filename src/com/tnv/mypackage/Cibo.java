package com.tnv.mypackage;

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
		System.out.println("Tipologia: " + this.getTipoPortata().getNome().toUpperCase());
		System.out.println("Cottura: " + this.getTipoCottura().getNome().toUpperCase());
		Alimento.stampaAllergeni(this.getStringaAllergeni(getElencoAllergeni())); //
	}
	
	//stampa l'elenco dei cibi
	public static void stampaElencoCibi(ArrayList<Cibo> cibi) {
		for(Cibo item: cibi)
			item.stampaAlimento();
	}
	
	public static Cibo getRandomCibo() {
		return new Cibo(10F, "Spaghetti alla carbonara", false, false, Alimento.setAllergeni(Allergene.GLUTINE, Allergene.UOVA_E_DERIVATI), Portata.PRIMO);
	}
	
}
