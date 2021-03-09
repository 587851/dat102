package no.hvl.dat102.medlemsInfo;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem { 
	private String navn;
	private MengdeADT<Hobby> hobbyer; 
	private int statusIndeks;

	public Medlem(String navn, MengdeADT<Hobby> hobbyer) {
		this.navn = navn;
		this.hobbyer = hobbyer;
		this.statusIndeks = -1;
	}

	public boolean passerTil(Medlem medlem2) {
		boolean passer = false;
		MengdeADT<Hobby> hobby1 = this.getHobbyer();
		MengdeADT<Hobby> hobby2 = medlem2.getHobbyer();

		if(hobby1.antall() == hobby2.antall()) {
			if(hobby1.equals(hobby1.snitt(hobby2))) {
				passer = true;
			}
		}
		return passer;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}


}
