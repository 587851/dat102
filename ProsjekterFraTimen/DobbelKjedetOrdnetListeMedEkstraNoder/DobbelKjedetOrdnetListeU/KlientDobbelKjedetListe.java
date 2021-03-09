package DobbelKjedetOrdnetListeU;

import no.hvl.dat102.DobbelKjedetOrdnetListe;

public class KlientDobbelKjedetListe {

	public static void main(String[] args) {
		String ord[] = { "o", "a", "s", "m", "e", "k", "c" };

		DobbelKjedetOrdnetListe<String> liste = new DobbelKjedetOrdnetListe(new String("AAA"), new String("zzz"));
		// Klienten bør sjekke på at alle verdier ligger innefor grensene
		// Legger data inn i listen
		for (int i = 0; i < ord.length; i++) {
			liste.leggTil(ord[i]);

		}
		
		System.out.println(liste);

		System.out.println(liste.tilStrengBaklengs());

//		 Slette m som fins
		liste.fjern("m");

		// Utskrift etter sletting
		System.out.println(liste);

		// Slette t som ikke fins
		liste.fjern("t");
		System.out.println(liste);

	}

}
