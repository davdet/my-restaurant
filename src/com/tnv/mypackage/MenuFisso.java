package com.tnv.mypackage;

import java.util.ArrayList;
import java.util.Random;

public class MenuFisso {

	private String nomeMenu;
	private int scontoMenu;
	private ArrayList<Alimento> elencoPiattiMenu;
	
	public MenuFisso() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	public static ArrayList<Alimento> getPiattiMenu(ArrayList<Alimento> alimenti) {
		Random rand = new Random();
		ArrayList<Alimento> piatti = new ArrayList<Alimento>();
		final int numeroPortate = 5;
		int randomChoice;
		
		for(int i = 0; i < numeroPortate; i++) {
			randomChoice = rand.nextInt(alimenti.size());
			piatti.add(alimenti.get(randomChoice));
		}
		
		return piatti;
	}
	
	//stampa a video il menu
	public void stampaMenu() {
		System.out.println(getNomeMenu().toUpperCase());
		System.out.println("Prezzo pieno: " + getPrezzoPieno());
		System.out.println("Prezzo scontato del " + getScontoMenu() + "%: " + getPrezzoScontato() + "\n");
		Alimento.stampaElencoAlimenti(elencoPiattiMenu);
	}
	
	//calcola il prezzo pieno del menu
	public Float getPrezzoPieno() {
		Float totale = 0F;
		
		for(Alimento item: elencoPiattiMenu)
			totale = totale + item.getPrezzo();
		
		return totale;
	}
	
	//calcola il prezzo scontato del menu
	public Float getPrezzoScontato() {
		return getPrezzoPieno() - (getPrezzoPieno() * getScontoMenu() / 100);
	}
	
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
