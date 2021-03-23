package no.hvl.dat102;

import java.util.Iterator;

import no.hvl.dat102.adt.BSTreADT;

//********************************************************************
// KjedetBinærSøkeTre.java        
//
//********************************************************************

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>,Iterable<T> {

	private int antall;
	/**
	 * @return the rot
	 */
	public BinaerTreNode<T> getRot() {
		return rot;
	}

	/**
	 * @param rot the rot to set
	 */
	public void setRot(BinaerTreNode<T> rot) {
		this.rot = rot;
	}

	private BinaerTreNode<T> rot;

	/******************************************************************
	 * Oppretter et tomt binært søketre.
	 ******************************************************************/
	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	/******************************************************************
	 * Oppretter et binært søketre med en node..
	 ******************************************************************/
	public KjedetBSTre(T element) {
		rot = new BinaerTreNode<T>(element);
		antall = 1;
	}


	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		rot = leggTilRek(rot, element);
		antall++;
	}

	private BinaerTreNode<T> leggTilRek(BinaerTreNode<T> p, T element) {
		if (p == null)
			return new BinaerTreNode<T>(element);
		if (p.getElement().compareTo(element) > 0) {
			p.setVenstre(leggTilRek(p.getVenstre(), element));
			return p;
		}else
			p.setHoyre(leggTilRek(p.getHoyre(), element));
		return p;
	}

	/******************************************************************
	 * Legger det spesifiserte elementet på passende plass i dette binære søketreet.
	 * Like elementer blir lagt til høyre.
	 ******************************************************************/

	public void leggTil2(T element) {
		// 
	}

	/******************************************************************
	 * Fjerner noden med minste verdi fra dette binære søketreet.
	 *********************************************************************/
	@Override
	public T fjernMin() {
		T element = null;
		if (rot == null)
			return null;
		if (rot.getVenstre() == null) {
			element = rot.getElement();
			rot = rot.getHoyre();
		}
		else {
			BinaerTreNode<T> prev = rot;
			BinaerTreNode<T> el = rot.getVenstre();
			while(el.getVenstre() != null) {
				prev = el;
				el = el.getVenstre();
			}
			element = el.getElement();
			prev.setVenstre(el.getHoyre());	
		}
		antall--;
		return element;
	}//

	/******************************************************************
	 * Fjerner noden med største verdi fra dette binære søketreet.
	 ******************************************************************/
	@Override
	public T fjernMaks() {
		T element = null;
		if (rot == null)
			return null;
		if (rot.getHoyre() == null) {
			element = rot.getElement();
			rot = rot.getVenstre();
		}
		else {
			BinaerTreNode<T> prev = rot;
			BinaerTreNode<T> el = rot.getHoyre();
			while(el.getHoyre() != null) {
				prev = el;
				el = el.getHoyre();
			}
			element = el.getElement();
			prev.setHoyre(el.getVenstre());	
		}
		antall--;
		return element;
	}//

	/******************************************************************
	 * Returnerer det minste elementet i dette binære søketreet.
	 ******************************************************************/
	@Override
	public T finnMin() {
		T element = null;
		if (rot == null)
			return null;
		else {
			BinaerTreNode<T> el = rot;
			while(el.getVenstre() != null) {
				el = el.getVenstre();
			}
			element = el.getElement();
		}
		return element;

	}//

	/******************************************************************
	 * Returnerer det største elementet i dette binære søketreet.
	 ******************************************************************/
	@Override
	public T finnMaks() {
		T element = null;
		if (rot == null)
			return null;
		else {
			BinaerTreNode<T> el = rot;
			while(el.getHoyre() != null) {
				el = el.getHoyre();
			}
			element = el.getElement();
		}
		return element;
	}//

	/*******************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det finst i dette
	 * BS-treet, null ellers. Bruk av rekursjon /
	 ******************************************************************************/
	@Override
	public T finn(T element) {
		// Søk med rekursiv hjelpemetode
		return finnRek(element, rot);
	}

	private T finnRek(T element, BinaerTreNode<T> t) {
		if (t == null)
			return null;
		if (t.getElement().compareTo(element) > 0)
			return finnRek(element, t.getVenstre());
		else if (t.getElement().compareTo(element) <  0) {
			return finnRek(element, t.getHoyre());
		}
		return t.getElement();
	}

	/************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * BS-treet, null ellers. Uten bruk av rekursjon. /
	 ************************************************************************/
	public T finn2(T element) {
		if (rot == null)
			return null;
		BinaerTreNode<T> t = rot;
		boolean kanFinnes = true;
		while(t.getElement().compareTo(element) != 0 && kanFinnes) {
			if(t.getElement().compareTo(element) < 0) {
				if (t.getHoyre() != null)
					t = t.getHoyre();
				else
					kanFinnes = false;
			}
			else if(t.getElement().compareTo(element) > 0) {
				if (t.getVenstre() != null)
					t = t.getVenstre();
				else
					kanFinnes = false;
			}
		}
		if (!kanFinnes)
			return null;
		return t.getElement();
	}

	public void visInorden() {
		visInorden(rot);
		System.out.println();
	}

	private void visInorden(BinaerTreNode<T> p) {
		if (p != null) {
			visInorden(p.getVenstre());
			System.out.print(" " + p.getElement());
			visInorden(p.getHoyre());
		}  
	}

	@Override
	public Iterator<T> iterator() {
		return new InordenIterator<T>(rot);

	}

	public int hoyde() {
		return hoydeRek(rot);
	}

	private int hoydeRek(BinaerTreNode<T> t) {
		if(t == null)
			return -1;
		return (int)Math.max(hoydeRek(t.getVenstre()), hoydeRek(t.getHoyre())) + 1;
	}
	public void skrivVerdier(T nedre, T ovre) {
		skrivVerdierRek(rot, nedre, ovre);
	}

	private void skrivVerdierRek(BinaerTreNode<T> t, T min, T maks) {
		if(t != null) {
			if (t.getElement().compareTo(min) >= 0)
				skrivVerdierRek(t.getVenstre(), min, maks);
			if((t.getElement().compareTo(min) >= 0) && (t.getElement().compareTo(maks) <= 0)){
				System.out.println(t.getElement() + " ");
			}
			if (t.getElement().compareTo(maks) <= 0)
				skrivVerdierRek(t.getHoyre(), min, maks);
		}
	}

}// class
