package nqueens;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class QueenTest {

	@Test
	public void test_is_same_column() {
		// positive case
		Queen neighbor = new Queen(0, 0);
		Queen queen = new Queen(1, 0);

		assertTrue(queen.isSameColumn(neighbor));

		// negative case
		neighbor = new Queen(0, 1);
		queen = new Queen(1, 0);

		assertFalse(queen.isSameColumn(neighbor));
	}

	@Test
	public void test_is_diagonal() {
		// positive case
		Queen neighbor = new Queen(0, 0);
		Queen queen = new Queen(1, 1);

		assertTrue(queen.isDiagonal(neighbor));
		assertTrue(neighbor.isDiagonal(queen));

		// negative case
		neighbor = new Queen(0, 0);
		queen = new Queen(1, 0);

		assertFalse(queen.isDiagonal(neighbor));
	}

	@Test
	public void test_is_safe() {
		// positive cases
		Queen neighbor = new Queen(0, 0);
		Queen queen = new Queen(2, 1);

		assertTrue(queen.isSafeFrom(neighbor));

		// negative cases
		neighbor = new Queen(0, 0);
		queen = new Queen(1, 0);

		assertFalse(queen.isSafeFrom(neighbor));

		neighbor = new Queen(0, 0);
		queen = new Queen(1, 1);

		assertFalse(queen.isSafeFrom(neighbor));

		neighbor = new Queen(0, 1);
		queen = new Queen(1, 1);

		assertFalse(queen.isSafeFrom(neighbor));
	}

	@Test
	public void test_is_safe_from_neighbors() {
		// positive cases
		Set<Queen> neighbors = new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 0), new Queen(2, 3)));
		Queen queen = new Queen(3, 1);

		assertTrue(queen.isSafeFrom(neighbors));

		neighbors = new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 0), new Queen(2, 3)));
		queen = new Queen(3, 1);

		assertTrue(queen.isSafeFrom(neighbors));

		// negative cases
		neighbors = new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 0), new Queen(2, 3)));
		queen = new Queen(3, 2);

		assertFalse(queen.isSafeFrom(neighbors));

		neighbors = new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 0), new Queen(2, 3)));
		queen = new Queen(3, 3);

		assertFalse(queen.isSafeFrom(neighbors));

		neighbors = new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 0), new Queen(2, 3)));
		queen = new Queen(2, 2);

		assertFalse(queen.isSafeFrom(neighbors));
	}

	@Test
	public void test_is_safe_from_null_neighbors() {
		Set<Queen> neighbors = null;
		Queen queen = new Queen(3, 1);

		assertTrue(queen.isSafeFrom(neighbors));
	}

	@Test
	public void test_is_safe_from_empty_neighbors() {
		Set<Queen> neighbors = new HashSet<Queen>();
		Queen queen = new Queen(3, 1);

		assertTrue(queen.isSafeFrom(neighbors));
	}

}
