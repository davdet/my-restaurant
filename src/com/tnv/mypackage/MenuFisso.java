package com.tnv.mypackage;

import java.util.ArrayList;

public class MenuFisso{

	private String nomeMenu;
	private int scontoMenu;
	private ArrayList<Alimento> elencoPiattiMenuFisso = new ArrayList<Alimento>();

	public MenuFisso(String nomeMenu, int scontoMenu, ArrayList<Alimento> elencoPiattiMenuFisso) {
		super();
		this.nomeMenu = nomeMenu;
		this.scontoMenu = scontoMenu;
		this.elencoPiattiMenuFisso = elencoPiattiMenuFisso;
	}
	
	public MenuFisso(ArrayList<Alimento> elencoPiattiMenuFisso) {
		super();
		this.nomeMenu = "Menù del giorno";
		this.scontoMenu = 20;
		this.elencoPiattiMenuFisso = elencoPiattiMenuFisso;
	}

	/**
	 * Stampa a video un oggetto di tipo MenuFisso.
	 */
	public void stampaMenu() {
		System.out.println(getNomeMenu().toUpperCase());
		System.out.println("Prezzo pieno: " + getPrezzoPieno() + "€");
		System.out.println("Prezzo scontato del " + getScontoMenu() + "%: " + getPrezzoScontato() + "€\n");
		Alimento.stampaElencoAlimenti(elencoPiattiMenuFisso);
	}
	
	/**
	 * Calcola il prezzo del menu sommando i prezzi delle varie portate.
	 * @return Prezzo totale (pieno).
	 */
	public Float getPrezzoPieno() {
		Float totale = 0F;
		
		for(Alimento item: elencoPiattiMenuFisso)
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

	public ArrayList<Alimento> getElencoPiattiMenuFisso() {
		return elencoPiattiMenuFisso;
	}

	public void setElencoPiattiMenuFisso(ArrayList<Alimento> elencoPiattiMenuFisso) {
		this.elencoPiattiMenuFisso = elencoPiattiMenuFisso;
	}

}
