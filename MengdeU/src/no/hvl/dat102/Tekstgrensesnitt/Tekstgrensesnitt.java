package no.hvl.dat102.Tekstgrensesnitt;

import java.util.Scanner;

import no.hvl.dat102.medlemmer.tabell.Datakontakt;
import no.hvl.dat102.medlemsInfo.Hobby;
import no.hvl.dat102.medlemsInfo.Medlem;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Tekstgrensesnitt{ // Klasse for inn/ut terminal
	//Hvis du vil lage meny,kan du også legge det inn i Tekstgrensesnitt

	// leser opplysningene om et medlem fra tastatur
	public static Medlem lesMedlem(){
		Scanner scanner = new Scanner(System.in);
		MengdeADT<Hobby> hobbyer = new KjedetMengde<Hobby>();

		System.out.print("Navn: ");
		String navn = scanner.nextLine();

		System.out.println("\nHvilke hobbyer har " + navn + "? Skriv Z for å avslutte");
		String svar = "";
		while(!svar.equals("Z")) {
			svar = scanner.nextLine();
			Hobby hobby = new Hobby(svar);
			hobbyer.leggTil(hobby);
		}
		scanner.close();

		Medlem medlem = new Medlem(navn, hobbyer);
		return medlem;
	} 


	// Skriver ut hobbylisten for et medlem
	public static void skrivHobbyListe(Medlem medlem) { 
		System.out.println("Alle hobbyene til " + medlem.getNavn()); 
		String utskrift = "<";

		for(int i = 0; i < medlem.getHobbyer().antall() ; i++) {
			utskrift += medlem.getHobbyer().fjernTilfeldig();

			if( i == medlem.getHobbyer().antall()-1) {
				utskrift += ">";
			}else {
				utskrift += ", ";
			}//else			
		}	//if

		utskrift += ">";
		System.out.println(utskrift);
	}//skrivHobbyListe


	public static void skrivParListe (Datakontakt arkiv){
		System.out.println("PAR: \n--------------------------");
		int antall = 0;
		for(int i = 0; i < arkiv.antall(); i++) {
			if(arkiv.getTabell()[i].getStatusIndeks() > -1) {
				System.out.println(arkiv.getTabell()[i].getNavn() + " og " + arkiv.getTabell()[arkiv.getTabell()[i].getStatusIndeks()].getNavn());
				antall++;
			}
		}
		System.out.println("--------------------------\nAntall par funnet: " + antall);


	}

	public void meny() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Opprett arkiv: Skriv 1 for standarstørrelse og 2 for valgfri størrelse");
	
		boolean opprettet = false;
		Datakontakt arkiv = null;

		while(!opprettet) {
			int arkivType = Integer.parseInt(scan.nextLine());
			switch(arkivType) {
			case 1:
				arkiv = new Datakontakt();
				opprettet = true;
				break;
			case 2:
				System.out.println("Størrelse: ");
				arkiv = new Datakontakt(Integer.parseInt(scan.nextLine()));
				opprettet = true;
				break;

			default:
				System.out.println("Ikke gyldig valg, prøv på nytt");
			}//switch
		}//while

		boolean ferdig = false;

		while(!ferdig) {
			System.out.println("1. Opprett medlem og legg til i arkiv "
					+ "\n2. Skriver ut alle hobbyene til et medlem "
					+ "\n3. Skriver ut alle par i arkivet"
					+ "\n4. Avslutt");
			int arkivType = Integer.parseInt(scan.nextLine());
			switch(arkivType) {
			case 1:
				Medlem medlem = lesMedlem();
				arkiv.leggTilMedlem(medlem);
				break;
			case 2:
				for(int i = 0; i < arkiv.antall(); i++) {
					System.out.println(i+1 +". " + arkiv.getTabell()[i]);
				System.out.print("Skriv nummeret til medlemmet du ønsker å få vite hobbyene til: ");
				skrivHobbyListe(arkiv.getTabell()[Integer.parseInt(scan.nextLine()) - 1]);
				}
				break;
			case 3:
				skrivParListe(arkiv);
				break;
			case 4:
				ferdig = true;
				break;
			default:
				System.out.println("Ikke gyldig valg, prøv på nytt");
			}//switch
		}//while


		scan.close();
	}
	/* skriver ut på skjermen en oversikt over medlemmer som er koblet til hverandre i medlemstabellen til enhver tid.
	 * Et slikt par skal kun vises én gang på utskriftlisten. Metoden skriver også ut antall par som er funnet.
	 */

}
