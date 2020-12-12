package nqueens;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class BoardTest {

	@Test
	public void test_same_board() {
		// positive case
		Board b1 = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 0), new Queen(2, 3))));
		Board b2 = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(1, 0), new Queen(0, 2), new Queen(2, 3))));

		assertTrue(b1.equals(b2));

		// negative case
		b1 = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 0), new Queen(2, 3))));
		b2 = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(1, 0), new Queen(0, 1), new Queen(2, 3))));

		assertFalse(b1.equals(b2));
	}

	@Test
	public void test_unique_board_in_board_set() {
		Board b1 = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 0), new Queen(2, 3))));
		Board b2 = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 0), new Queen(2, 3))));
		Set<Board> boards = new TreeSet<Board>(Arrays.asList(b1, b2));

		assertTrue(boards.size() == 1);

		b1 = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 0), new Queen(2, 3))));
		b2 = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(2, 0), new Queen(2, 3))));
		boards = new TreeSet<Board>(Arrays.asList(b1, b2));

		assertTrue(boards.size() == 2);
	}

	@Test
	public void test_board_exists_in_board_set() {
		// positive case
		Board board = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 0), new Queen(2, 3))));
		Board b1 = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 0), new Queen(2, 3))));
		Board b2 = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 4), new Queen(3, 5))));
		Board b3 = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 1), new Queen(2, 3))));
		Set<Board> boards = new TreeSet<Board>(Arrays.asList(b1, b2, b3));

		assertTrue(boards.size() == 3);
		assertTrue(boards.contains(board));

		// negative case
		board = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 0), new Queen(3, 3))));
		assertFalse(boards.contains(board));
	}

	@Test
	public void test_queen_exists_in_board() {
		// positive case
		Queen queen = new Queen(0, 2);
		Board board = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 0), new Queen(2, 3))));

		assertTrue(board.contains(queen));

		// negative case
		queen = new Queen(0, 4);

		assertFalse(board.contains(queen));
	}

	@Test
	public void test_rotate_board() {
		// positive case
		Board board = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 0), new Queen(1, 1), new Queen(2, 2))));
		Board rotated = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 1), new Queen(2, 0))));

		assertTrue(rotated.equals(board.rotate()));

		// negative case
		board = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 0), new Queen(1, 1), new Queen(2, 1))));
		rotated = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 1), new Queen(2, 0))));

		assertFalse(rotated.equals(board.rotate()));
	}

	@Test
	public void test_mirror_board() {
		// positive case
		Board board = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 0), new Queen(1, 1), new Queen(2, 0))));
		Board mirror = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 2), new Queen(1, 1), new Queen(2, 2))));

		assertTrue(mirror.equals(board.mirror()));

		// negative case
		board = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 0), new Queen(1, 1), new Queen(2, 1))));

		assertFalse(mirror.equals(board.mirror()));
	}

	@Test
	public void test_has_collinear() {
		Set<Queen> queens = null;
		Board board = new Board(queens);

		assertFalse(board.hasCollinear());

		// [[0:4], [1:1], [2:3], [3:5], [4:7], [5:2], [6:0], [7:6]]
		queens = new TreeSet<Queen>(Arrays.asList(new Queen(0, 4), new Queen(1, 1), new Queen(2, 3), new Queen(3, 5),
				new Queen(4, 7), new Queen(5, 2), new Queen(6, 0), new Queen(7, 6)));
		board = new Board(queens);

		assertTrue(board.hasCollinear());

		// [[0:5], [1:1], [2:6], [3:0], [4:3], [5:7], [6:4], [7:2]]
		queens = new TreeSet<Queen>(Arrays.asList(new Queen(0, 5), new Queen(1, 1), new Queen(2, 6), new Queen(3, 0),
				new Queen(4, 3), new Queen(5, 7), new Queen(6, 4), new Queen(7, 2)));
		board = new Board(queens);

		assertFalse(board.hasCollinear());
	}

}