package no.hvl.dat102.tabellMengdeTest;

import no.hvl.dat102.mengde.adt.*;
import no.hvl.dat102.adt.*;
import no.hvl.dat102.mengde.tabell.*;


public class TabellMengdeTest extends AdtMengdeTest {
	@Override
	protected MengdeADT<Integer> reset() {
		return new TabellMengde<Integer>();
	}
}
