package no.hvl.dat102.klient;

import java.util.Random;

import no.hvl.dat102.KjedetBSTre;

public class KlientB {

	public static void main(String[] args) {
		
		Random rng = new Random();
		final int antallNoder = 8192;
		final int antallTrer = 100;
		
		KjedetBSTre<Integer>[] skog = new KjedetBSTre[antallTrer];
		int minstHoyde = maksTeoHoyde(antallNoder);
		int storstHoyde = minTeoHoyde(antallNoder);
		int hoydeSum = 0;
		for (int i = 0; i < skog.length; i++) {
			skog[i] = new KjedetBSTre<Integer>();
			for (int j = 0; j < antallNoder; j++) {
				skog[i].leggTil(rng.nextInt());
			}
			minstHoyde = (int)Math.min(minstHoyde, skog[i].hoyde());
			storstHoyde = (int)Math.max(storstHoyde, skog[i].hoyde());
			hoydeSum += skog[i].hoyde();
		}
		//i)
		System.out.println("Antall noder p� hvert tre: " + skog[0].antall());
		
		//ii)
		System.out.println("Minstre teoretiske h�yde: " + minTeoHoyde(antallNoder));
		
		//iii)
		System.out.println("St�rste teoretiske h�yde: " + maksTeoHoyde(antallNoder));
		
		//iv)
		System.out.println("Minste h�yde i l�p av kj�ringen er: " + minstHoyde);
		
		//v)
		System.out.println("St�rste h�yde i l�p av kj�ringen er: " + storstHoyde);
		
		//vi)
		System.out.println("Gjennomsnitt h�yde er: " + hoydeSum/(double)antallTrer);

	}
	
	private static int maksTeoHoyde(int antallNoder) {
		return antallNoder - 1;
	}
	
	private static int minTeoHoyde(int antallNoder) {
		if(antallNoder == 0) {
			return -1;
		}
		return (int)(Math.log10(antallNoder)/Math.log10(2));
	}

}
