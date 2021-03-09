package no.hvl.dat102;

public class SpesiellKjedetStruktur<T> {
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	public SpesiellKjedetStruktur() {
		antall = 0;
		start = null;
	}

	public void leggTil(T element) {
       //Legger til foran
		LinearNode<T> nyNode = new LinearNode<T>(element);

		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

	public boolean erTom() {
		return (antall() == 0);
	}

	public int antall() {
		return antall;
	}

	public String toString() {
		String resultat = "";
		LinearNode<T> aktuell = start;
		while (aktuell != null) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getNeste();
		}

		return resultat;
	}

	public void snuKjedetStruktur() {

		LinearNode<T> r, n, s;  // s peker på første noden i strukturen som
								// skal snues(reverseres).
		s = start;
		r = null;   // initier r, den reverserte strukturen,
					// til den tomme listen
		while(s != null){ 		
	     n = s;
		 s = s.getNeste();
		 n.setNeste(r);
		 r = n;
		}
        start = r;
	}// metode
    
	public int finnAntallLike(T el) {
		LinearNode<T> p = start;
		int antallLike = 0;
        while(p != null) {
        	if(el.equals(p)) {
        		antallLike++;
        	}
        	p = p.getNeste();
        }
		return antallLike;
	}

	public void leggTilBak(T el, T nyttElement) {
		/*
		 * som legger til en ny node med elementet nyttElement rett bak noden med
		 * elementet el. Dersom el ikke fins i strukturen, skal den nye noden plasseres
		 * inn helt framme.
		 */

		LinearNode<T> p = start;
		boolean funnet = false;
		LinearNode<T> nyNode = new LinearNode<T>(nyttElement);

		if (p == null) {// Tom struktur
			start = nyNode;
		} else {// Ikke-tom struktur
			while (p != null && !funnet) {
		          if(el.equals(p.getNeste())) {
		        	  funnet = true;
		        	  nyNode.setNeste(p.getNeste());
		        	  p.setNeste(nyNode);
		          }else {
		        	  p = p.getNeste();
		          }
			}
			if(!funnet) {
				nyNode.setNeste(start);
				start = nyNode;
			}
			antall++;
		} // metode
	}

}
