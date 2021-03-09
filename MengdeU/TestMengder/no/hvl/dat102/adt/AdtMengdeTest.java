package no.hvl.dat102.adt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.MengdeADT;

public abstract class AdtMengdeTest {

	private MengdeADT<Integer> mengde1;
	private MengdeADT<Integer> mengde2;
	private MengdeADT<Integer> fasitMengde;

	// Test data
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;
	private Integer e6 = 7;

	/**
	 * Opprett en tom mengde for hver test.
	 */

	protected abstract MengdeADT<Integer> reset();

	@BeforeEach
	public final void setup() {
		mengde1 = reset();
		mengde2 = reset();
		fasitMengde = reset();
	}

	@Test
	public final void unionLikt() {
		mengde1.leggTil(e0);
		mengde1.leggTil(e1);
		mengde1.leggTil(e2);

		mengde2.leggTil(e0);
		mengde2.leggTil(e1);
		mengde2.leggTil(e2);

		fasitMengde.leggTil(e0);
		fasitMengde.leggTil(e1);
		fasitMengde.leggTil(e2);

		assertEquals(fasitMengde, mengde1.union(mengde2));
		assertEquals(fasitMengde, mengde2.union(mengde1));
	}

	@Test
	public final void unionUlike() {
		mengde1.leggTil(e0);
		mengde1.leggTil(e1);
		mengde1.leggTil(e2);

		mengde2.leggTil(e3);
		mengde2.leggTil(e4);
		mengde2.leggTil(e5);

		fasitMengde.leggTilAlle(mengde1);
		fasitMengde.leggTilAlle(mengde2);

		assertEquals(fasitMengde, mengde1.union(mengde2));
		assertEquals(fasitMengde, mengde2.union(mengde1));
	}
	@Test
	public final void snittLikt() {
		mengde1.leggTil(e0);
		mengde1.leggTil(e1);
		mengde1.leggTil(e2);

		mengde2.leggTil(e0);
		mengde2.leggTil(e1);
		mengde2.leggTil(e2);
		
		fasitMengde.leggTil(e0);
		fasitMengde.leggTil(e1);
		fasitMengde.leggTil(e2);
		
		assertEquals(fasitMengde, mengde1.snitt(mengde2));
		assertEquals(fasitMengde, mengde2.snitt(mengde1));
	}

	@Test
	public final void snittUlikt() {		
		mengde1.leggTil(e0);
		mengde1.leggTil(e1);
		mengde1.leggTil(e2);

		mengde2.leggTil(e3);
		mengde2.leggTil(e4);
		mengde2.leggTil(e5);
			
		assertEquals(fasitMengde, mengde1.snitt(mengde2));
		assertEquals(fasitMengde, mengde2.snitt(mengde1));
	}

	@Test
	public final void differensLikt() {
		mengde1.leggTil(e0);
		mengde1.leggTil(e1);
		mengde1.leggTil(e2);

		mengde2.leggTil(e0);
		mengde2.leggTil(e1);
		mengde2.leggTil(e2);
		
		assertEquals(fasitMengde, mengde1.differens(mengde2));
		assertEquals(fasitMengde, mengde2.differens(mengde1));

	}

	@Test
	public final void differensUlikt() {
		mengde1.leggTil(e0);
		mengde1.leggTil(e1);
		mengde1.leggTil(e2);

		mengde2.leggTil(e3);
		mengde2.leggTil(e4);
		mengde2.leggTil(e5);
		
		fasitMengde = mengde1;
		assertEquals(fasitMengde, mengde1.differens(mengde2));
		fasitMengde = mengde2	;
		assertEquals(fasitMengde, mengde2.differens(mengde1));

	}

}


