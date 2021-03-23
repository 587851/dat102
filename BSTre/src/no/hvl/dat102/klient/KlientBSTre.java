package no.hvl.dat102.klient;

import no.hvl.dat102.KjedetBSTre;
import no.hvl.dat102.adt.BSTreADT;

public class KlientBSTre {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KjedetBSTre<Integer> bstre = new KjedetBSTre<Integer>();
		
		bstre.leggTil(7);
		bstre.leggTil(5);
		bstre.leggTil(6);
		bstre.leggTil(4);
		bstre.leggTil(9);
		bstre.leggTil(10);
		bstre.leggTil(8);
		bstre.leggTil(3);
		
//		System.out.println(bstre.hoyde());
//		
//		System.out.println("Min: " + bstre.finnMin());
//		System.out.println("Maks: " + bstre.finnMaks());
//		
//		bstre.fjernMin();
//		bstre.fjernMaks();
//		System.out.println("Min: " + bstre.finnMin());
//		System.out.println("Maks: " + bstre.finnMaks());
//		
//		System.out.println(bstre.finn2(8));
//		System.out.println(bstre.finn2(1000));
//
//		// Tester på sortert utskrift
//		System.out.println("Skriver ut elementene sortert i bs-treet");
//		bstre.visInorden();
//
//		// Tester på om et bestemt element fins
//		int element = 8;
//		System.out.println("\nTester paa om elementet " + element + " fins");
//
//		if (bstre.finn(element) != null) {
//			System.out.println("Elementet " + element + " fins i bs-treet");
//		} else {
//			System.out.println("Elementet " + element + " fins ikke i bs-treet");
//		}
//
//		element = 1;
//		System.out.println("\nTester paa om elementet " + element + " fins");
//
//		if (bstre.finn(element) != null) {
//			System.out.println("Elementet " + element + " fins i bs-treet");
//		} else {
//			System.out.println("Elementet " + element + " fins ikke i bs-treet");
//		}
		
		bstre.skrivVerdier(5, 10);
	}

}
