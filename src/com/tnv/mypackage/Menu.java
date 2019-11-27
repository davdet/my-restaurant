package com.tnv.mypackage;

import java.util.ArrayList;

public class Menu {
	
	String dataAggiornamento = "27/11/2019";
	ArrayList<Alimento> menu = new ArrayList<Alimento>();
	
	public Menu(int numeroPiatti) {
		inizializzaMenu(numeroPiatti);
	}
	
	/**
	 * Inizializza il menu con un numero di piatti random.
	 * @param numeroPiatti numero di piatti random da generare.
	 */
	public void inizializzaMenu(int numeroPiatti) {
		for(int i = 0; i < numeroPiatti; i++) {
			menu.add(Rand.getRandomAlimento());
		}
	}

	/* G/S */
	public String getDataAggiornamento() {
		return dataAggiornamento;
	}
	
	public void setDataAggiornamento(String dataAggiornamento) {
		this.dataAggiornamento = dataAggiornamento;
	}
	
	public ArrayList<Alimento> getMenu() {
		return menu;
	}
	
	public void setMenu(ArrayList<Alimento> menu) {
		this.menu = menu;
	}
	
}
