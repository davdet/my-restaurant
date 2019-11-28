package com.tnv.mypackage;

import java.util.ArrayList;
import java.util.Random;

public class Tavolo {

	private String idTavolo;
	private int nPosti;
	private int nCoperti;
	private ArrayList<Alimento> ordine = new ArrayList<Alimento>();
	private boolean occupato;
	private float totaleOrdine;
	
	public Tavolo() {
		// TODO Auto-generated constructor stub
	}

	public Tavolo(String idTavolo, int nCoperti) {
		super();
		this.idTavolo = idTavolo;
		this.nPosti = nCoperti;
		this.occupato = false;
	}

	/**
	 * Crea un array list con un numero di tavoli definito dall'utente, ognuno dei quali con un numero di posti random tra 2 e 6.
	 * @param tavoliInterni Numero di tavoli all'interno.
	 * @param tavoliEsterni Numero di tavoli all'esterno.
	 * @return Array list Array list dei tavoli.
	 */
	public static ArrayList<Tavolo> inizializzaTavoli(int tavoliInterni, int tavoliEsterni) {
		ArrayList<Tavolo> tavoli = new ArrayList<Tavolo>();
		Random rand = new Random();
		final int postiMin = 2;
		final int postiMax = 6;
		
		for(int i = 0; i < tavoliInterni; i++)
			tavoli.add(new Tavolo("Int" + (i + 1), rand.nextInt((postiMax - postiMin) + 1 ) + postiMin));
		for(int i = 0; i < tavoliEsterni; i++)
			tavoli.add(new Tavolo("Ext" + (i + 1), rand.nextInt((postiMax - postiMin) + 1 ) + postiMin));
		
		return tavoli;
	}
	
	/**
	 * Restituisce un tavolo specifico da un array list di tavoli.
	 * @param idTavolo Id del tavolo desiderato.
	 * @param tavoli Array list dei tavoli.
	 * @return Tavolo desiderato.
	 */
	public static Tavolo getTavolo(String idTavolo, ArrayList<Tavolo> tavoli) {
		for(Tavolo item: tavoli)
			if(idTavolo.equals(item.idTavolo))
				return item;
		
		return null;
	}
	
	/**
	 * Assegna un tavolo impostando il flag occupato a true e il numero di coperti.
	 * @param nCoperti Numero dei coperti.
	 */
	public void assegnaTavolo(int nCoperti) {
		if (!occupato) {
			setOccupato(true);
			if (nCoperti <= getnPosti())
				setnCoperti(nCoperti);
			else
				System.out.println("Al tavolo " + getIdTavolo() + " ci stanno al massimo " + getnPosti() + " persone.");
		} else {
			System.out.println("Tavolo già occupato.");
		}
	}
	
	/**
	 * Stampa a video le informazioni su un tavolo.
	 */
	public void stampaTavolo() {
		System.out.println("Tavolo: " + getIdTavolo() + " - " + getnPosti() + " posti");
		if (isOccupato()) {
			System.out.println("Coperti: " + getnCoperti() + "\n");
			Alimento.stampaElencoAlimenti(getOrdine());
			System.out.println("Totale: " + getTotaleOrdine() + "€");
		} else {
			System.out.println("Il tavolo è libero.");
		}
	}
	
	/**
	 * Emette un ordine relativo ad un tavolo (ordine alla carta + menu fisso) e aggiorna il calcolo del totale per quel tavolo.
	 * @param menu Array list dei piatti del menu.
	 * @param menuFisso Menu fisso.
	 * @param nMenuFissi Numero dei menu fissi da ordinare.
	 * @param listMenu Indici dei piatti da ordinare.
	 */
	public void ordina(ArrayList<Alimento> menu, MenuFisso menuFisso, int nMenuFissi, int... listMenu) {
		for(int item: listMenu) {
			Alimento alimento = menu.get(item);
			ordine.add(alimento);
			setTotaleOrdine(getTotaleOrdine() + alimento.getPrezzo());
		}
		for(int i = 0; i < nMenuFissi; i++) {
			ordine.addAll(menuFisso.getElencoPiattiMenuFisso());
			setTotaleOrdine(getTotaleOrdine() + menuFisso.getPrezzoScontato());
		}
	}
	
	/**
	 * Emette un ordine relativo ad un tavolo (solo ordine alla carta) e aggiorna il calcolo del totale per quel tavolo.
	 * @param menu Array list dei piatti del menu.
	 * @param listMenu Menu fisso.
	 */
	public void ordina(ArrayList<Alimento> menu, int... listMenu) {
		for(int item: listMenu) {
			Alimento alimento = menu.get(item);
			ordine.add(alimento);
			setTotaleOrdine(getTotaleOrdine() + alimento.getPrezzo());
		}
	}
	
	/**
	 * Emette un ordine relativo ad un tavolo (solo ordine menu fisso) e aggiorna il calcolo del totale per quel tavolo.
	 * @param menuFisso Menu fisso.
	 * @param nMenuFissi Numero dei menu fissi da ordinare.
	 */
	public void ordina(MenuFisso menuFisso, int nMenuFissi) {
		for(int i = 0; i < nMenuFissi; i++) {
			ordine.addAll(menuFisso.getElencoPiattiMenuFisso());
			setTotaleOrdine(getTotaleOrdine() + menuFisso.getPrezzoScontato());
		}
	}
	
	/**
	 * Gestisce il pagamento mostrando il totale da pagare, azzerando il totale del conto, settando il tavolo come libero e 
	 * rimuovendo i piatti dall'ordine di quel tavolo.
	 */
	public void paga() {
		System.out.println("Totale da pagare: " + getTotaleOrdine() + "€");
		setTotaleOrdine(0);
		setOccupato(false);
		getOrdine().removeAll(ordine);
	}

	/* G/S */
	public String getIdTavolo() {
		return idTavolo;
	}

	public void setIdTavolo(String idTavolo) {
		this.idTavolo = idTavolo;
	}

	public int getnPosti() {
		return nPosti;
	}

	public void setnPosti(int nCoperti) {
		this.nPosti = nCoperti;
	}

	public ArrayList<Alimento> getOrdine() {
		return ordine;
	}

	public void setOrdine(ArrayList<Alimento> ordine) {
		this.ordine = ordine;
	}

	public boolean isOccupato() {
		return occupato;
	}

	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}

	public float getTotaleOrdine() {
		return totaleOrdine;
	}

	public void setTotaleOrdine(float prezzo) {
		this.totaleOrdine = prezzo;
	}

	public int getnCoperti() {
		return nCoperti;
	}

	public void setnCoperti(int nCoperti) {
		this.nCoperti = nCoperti;
	}
	
}
