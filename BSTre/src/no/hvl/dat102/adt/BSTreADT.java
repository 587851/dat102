package no.hvl.dat102.adt;

import java.util.*;

public interface BSTreADT<T extends Comparable<T>> {
	// Burde hatt javadoc her
	// Anbefaler at du fyller ut med javadoc her som kan vaere en del av 
	// �vingen. Flere metoder m� fylles ut i implementasjonsfilen.
	//Legg merke til at i denne imlementasjonen er det ikke brukt exceptions som
	// vi kunne hatt og som vi har brukt for i flere av de andre samlingene.

	/**
	 * @return antall noder i det bin�re treet
	 */
	public int antall();

	/**
	 * 
	 * @return true hvis dette bin�re treet er tomt og false ellers.
	 */
	public boolean erTom();

	/**
	 * Legger det spesifiserte elementet p� passende plass i dette bin�re s�ketreet.
	 * Like elementer blir lagt til h�yre.
	 * 
	 * @param element - Elementet som skal legges til i det bin�re treet
	 */
	public void leggTil(T element);


	/**
	 * 
	 * @param element - Elementet som skal finnes
	 * @return en referanse til det spesifiserte elementet hvis det fins i dette
	 * bin�re treet ellers returneres null.
	 */
	public T finn(T element);


	/**
	 * @return en referanse til det minste elementet, null hvis treet er tomt.
	 */
	public T finnMin();


	/**
	 * @return en referanse til det st�rste elementet, null hvis treet er tomt.
	 */
	public T finnMaks();

	/************************************************************************
	 * Fjerner et element fra dette treet hvis det fins, ellers returneres null
	 ************************************************************************/

	//public T fjern( T element);
	// Ikke impelmentert

	/**
	 * Fjerner minste elementet fra dette treet hvis det fins, ellers returneres null
	 * @return elementet som fjernes hvis det finnes, ellers returneres null
	 */
	public T fjernMin();

	/**
	 * Fjerner det st�rste elementet fra dette treet hvis det fins, ellers returneres null
	 * @return elementet som fjernes hvis det finnes, ellers returneres null
	 */
	public T fjernMaks();
}
