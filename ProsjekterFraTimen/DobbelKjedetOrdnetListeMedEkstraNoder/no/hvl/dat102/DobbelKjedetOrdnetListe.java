package no.hvl.dat102;

public class DobbelKjedetOrdnetListe<T extends Comparable<T>> implements DobbelKjedetOrdnetListeADT<T> {
	private DobbelNode<T> foerste;
	private DobbelNode<T> siste;
	private int antall;

	public DobbelKjedetOrdnetListe(T minVerdi, T maksVerdi) {
		foerste = new DobbelNode<T>(minVerdi);
		siste = new DobbelNode<T>(maksVerdi);
		foerste.setNeste(siste);
		siste.setForrige(foerste);
		antall = 0;	

	}

	@Override
	public void leggTil(T el) {
		DobbelNode<T> nyNode = new DobbelNode<T>(el);
		DobbelNode<T> aktuell = foerste.getNeste();

		while(el.compareTo(aktuell.getElement()) > 0) {
			aktuell = aktuell.getNeste();
		}
		nyNode.setNeste(aktuell);
		nyNode.setForrige(aktuell.getForrige());
		aktuell.getForrige().setNeste(nyNode);
		aktuell.setForrige(nyNode);
		antall++;
	}

	@Override
	public T fjern(T el) {
		T resultat = null;
		DobbelNode<T> aktuell = foerste;
		if (erTom())
			throw new EmptyCollectionException("dobbelkjedet ordnet liste er tom");

		while(el.compareTo(aktuell.getElement()) > 0 && el != null) {
			aktuell = aktuell.getNeste();
		}
		if(el.equals(aktuell.getElement())) {
			resultat = aktuell.getElement();
			aktuell.getForrige().setNeste(aktuell.getNeste());
			aktuell.getNeste().setForrige(aktuell.getForrige());
			antall--;
		}
		return resultat;

	}

	/*
	 * Returnerer referansen til noden hvis el fins, ellers returneres
	 * null-referansen
	 */
	private DobbelNode<T> finn(T el) {
		DobbelNode<T> aktuell = foerste.getNeste();
		// TODO
		return null;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);

	}

	@Override
	public int antall() {
		return antall;
	}

	public String toString() {
		String resultat = "";
		DobbelNode<T> aktuell = foerste.getNeste();
		while (aktuell != siste) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getNeste();
		}

		return resultat;
	}

	public String tilStrengBaklengs() {
		String resultat = "";
		DobbelNode<T> aktuell = siste.getForrige();
		while (aktuell != foerste) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getForrige();
		}

		return resultat;
	}

}