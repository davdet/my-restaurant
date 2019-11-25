package com.tnv.mypackage;

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
	
	//restituisce una bevanda random
	public static Bevanda getRandomBevanda() {
		return new Bevanda(7F, "Stout (0,5l)", true, true, Alimento.setAllergeni(Allergene.GLUTINE), true, Tipo.BIRRA);
	}
	
}
