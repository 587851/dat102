package no.hvl.dat102.medlemmer.tabell;

import no.hvl.dat102.medlemsInfo.Medlem;

public class Datakontakt {

	private Medlem [] tabell;
	private int antall;

	public Datakontakt(int storrelse) {
		tabell = new Medlem[storrelse];
		antall = 0;
	}

	public Datakontakt() {
		tabell = new Medlem[100];
		antall = 0;
	}

	public int antall() {
		return antall;
	}
	
	public Medlem[] getTabell() {
		return tabell;
	}

	//Legger til en person i medlemstabellen hvis det er plass
	public boolean leggTilMedlem(Medlem person) {
		boolean lagtTil = false;
		if(antall < tabell.length) {
			tabell[antall] = person;
			lagtTil = true;
			antall++;
		}//if
		return lagtTil;
	}//leggTilMedlem


	//Finner indeksen til en person hvis han/hun er i tabellen
	public int finnMedlemsIndeks(Medlem person) {
		int indeks = -1;
		int i = 0;

		while(i < tabell.length && indeks == -1) {
			if(tabell[i].equals(person)) {
				indeks = i;
			}//if
		}//while

		return indeks;
	}//finnMedlemsIndeks

	//Finner det første medlemmet som har samme hobbyer som person medlemmet og som ikke er koblet opp med noen andre. 
	//Oppdaterer begge sin statusindeks til den andres indeks. Hvis ingen parter er funnet, settes statusindeks til -1.
	public boolean finnPartnerFor(Medlem person) {
		boolean funnet = false;
		int i = 0;

		while(i < tabell.length && !funnet ) {
			if(person.passerTil(tabell[i])) {
				if(person != tabell[i] && tabell[i].getStatusIndeks() == -1) {
					funnet = true;
					person.setStatusIndeks(i);
					tabell[i].setStatusIndeks(finnMedlemsIndeks(person));
				}//if
			}//if
			i++;
		}//while

		if(!funnet) {
			person.setStatusIndeks(-1);
		}//if
		return funnet;
	}


	public void tilbakestillStatusIndeks(Medlem person) {
		int indeks = finnMedlemsIndeks(person);
		int sI = person.getStatusIndeks();
		
		if(indeks != -1){
			if(sI > -1 && sI < tabell.length) {
				tabell[sI].setStatusIndeks(-1);
				person.setStatusIndeks(-1);
			}//if
		}//if
	}//tilbakestillStatusIndeks
}
