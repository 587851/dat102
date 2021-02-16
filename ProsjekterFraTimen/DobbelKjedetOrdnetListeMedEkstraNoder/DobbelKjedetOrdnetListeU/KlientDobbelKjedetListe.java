package no.hvl.dat102;

public class KlientDobbelKjedetListe {

	public static void main(String[] args) {
		String ord[] = { "o", "a", "s", "m", "e", "k", "c" };

		DobbelKjedetOrdnetListe<String> liste = new DobbelKjedetOrdnetListe(new String("AAA"), new String("zzz"));
		// Klienten bør sjekke på at alle veriden ligger innefor grensene
		// Legger data inn i listen
		for (int i = 0; i < ord.length; i++) {
			liste.leggTil(ord[i]);

		}
		// Utskrift foran
		//System.out.println(liste);

		// Utskrift bak
		//System.out.println(liste.tilStrengBaklengs());

		// Slette m som fins
		//liste.fjern("m");

		// Utskrift etter sletting
		//System.out.println(liste);

		// Slette t som ikke fins
		//liste.fjern("t");
		//System.out.println(liste);

	}

}
