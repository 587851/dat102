package no.hvl.dat102.kjedetMengdeTest;
import no.hvl.dat102.mengde.adt.*;
import no.hvl.dat102.adt.*;
import no.hvl.dat102.mengde.kjedet.*;

public class KjedetMengdeTest extends  AdtMengdeTest{
	@Override
	protected MengdeADT<Integer> reset() {
		return new KjedetMengde<Integer>();
	}		
}