package com.tnv.mypackage;

import java.util.ArrayList;
import java.util.Random;

public class MenuFisso {

	private String nomeMenu;
	private int scontoMenu;
	private ArrayList<Alimento> elencoPiattiMenu;

	public MenuFisso(String nomeMenu, int scontoMenu, ArrayList<Alimento> elencoPiattiMenu) {
		super();
		this.nomeMenu = nomeMenu;
		this.scontoMenu = scontoMenu;
		this.elencoPiattiMenu = elencoPiattiMenu;
	}
	
	public MenuFisso(ArrayList<Alimento> elencoPiattiMenu) {
		super();
		this.nomeMenu = "Menù del giorno";
		this.scontoMenu = 20;
		this.elencoPiattiMenu = elencoPiattiMenu;
	}

	//prende in ingresso un'array list di alimenti, estrae casualmente numeroPortate alimenti e li restituisce come array list
	/**
	 * Estrae casualmente un numero di piatti definito dall'utente da un array list di alimenti, e li restituisce sotto
	 * forma di array list.
	 * @param alimenti Array list di alimenti di partenza.
	 * @param numeroPiatti Numero di piatti da estrarre.
	 * @return Array list di alimenti.
	 */
	public static ArrayList<Alimento> getPiattiMenu(ArrayList<Alimento> alimenti, final int numeroPiatti) {
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
	 * Stampa a video un oggetto di tipo MenuFisso.
	 */
	public void stampaMenu() {
		System.out.println(getNomeMenu().toUpperCase());
		System.out.println("Prezzo pieno: " + getPrezzoPieno() + "€");
		System.out.println("Prezzo scontato del " + getScontoMenu() + "%: " + getPrezzoScontato() + "€\n");
		Alimento.stampaElencoAlimenti(elencoPiattiMenu);
	}
	
	/**
	 * Calcola il prezzo del menu sommando i prezzi delle varie portate.
	 * @return Prezzo totale (pieno).
	 */
	public Float getPrezzoPieno() {
		Float totale = 0F;
		
		for(Alimento item: elencoPiattiMenu)
			totale = totale + item.getPrezzo();
		
		return totale;
	}
	
	/**
	 * Applica lo sconto al prezzo totale.
	 * @return Prezzo scontato.
	 */
	public Float getPrezzoScontato() {
		return getPrezzoPieno() - (getPrezzoPieno() * getScontoMenu() / 100);
	}
	
	/* G/S */
	public String getNomeMenu() {
		return nomeMenu;
	}

	public void setNomeMenu(String nomeMenu) {
		this.nomeMenu = nomeMenu;
	}

	public int getScontoMenu() {
		return scontoMenu;
	}

	public void setScontoMenu(int scontoMenu) {
		this.scontoMenu = scontoMenu;
	}

	public ArrayList<Alimento> getElencoPiattiMenu() {
		return elencoPiattiMenu;
	}

	public void setElencoPiattiMenu(ArrayList<Alimento> elencoPiattiMenu) {
		this.elencoPiattiMenu = elencoPiattiMenu;
	}

}
