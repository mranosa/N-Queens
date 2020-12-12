package nqueens;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class NQueensTest {

	/**
	 * Should return 0 solution when input is less than 1
	 */
	@Test
	public void test_input() {
		NQueens nQueens = new NQueens(-1);
		Set<Board> solutions = nQueens.getSolutions();

		assertEquals(0, solutions.size());

		nQueens = new NQueens(0);
		solutions = nQueens.getSolutions();

		assertEquals(0, solutions.size());
	}

	/**
	 * Sanity check
	 */
	@Test
	public void test_solution_specifications() {
		int noOfQueens = 8;
		NQueens nQueens = new NQueens(noOfQueens);
		Set<Board> solutions = nQueens.getSolutions();

		for (Board solution : solutions) {
			Set<Queen> queens = solution.getQueens();

			// should have correct number of queens in board
			assertTrue(noOfQueens == queens.size());

			for (Queen i : queens) {
				for (Queen j : queens) {
					if (i == j)
						continue;
					// should have no two queens in the same row
					assertFalse(i.getRow() == j.getRow());

					// should have no two queens in the same column
					assertFalse(i.isSameColumn(j));

					// should have no two queens diagonal each other
					assertFalse(i.isDiagonal(j));
				}
			}
		}
	}

	/**
	 * Ensure all solutions are returned
	 */
	@Test
	public void test_correct_solutions_count() {
		// should have correct number of solutions per number of queens
		@SuppressWarnings("serial")
		Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
			{
				put(1, 1);
				put(2, 0);
				put(3, 0);
				put(4, 2);
				put(5, 10);
				put(6, 4);
				put(7, 40);
				put(8, 92);
			}
		};

		for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
			NQueens nQueens = new NQueens(pair.getKey());
			Set<Board> solutions = nQueens.getSolutions();

			assertEquals((int) pair.getValue(), solutions.size());
		}
	}

	/**
	 * Ensure all solution variants are correct
	 */
	@Test
	public void test_correct_solution_variants() {
		int noOfQueens = 8;
		NQueens nQueens = new NQueens(noOfQueens);
		Set<Board> solutions = nQueens.getSolutions();

		// [[0:5], [1:3], [2:0], [3:4], [4:7], [5:1], [6:6], [7:2]] in 8
		Board solution = new Board(new TreeSet<Queen>(Arrays.asList(new Queen(0, 5), new Queen(1, 3), new Queen(2, 0),
				new Queen(3, 4), new Queen(4, 7), new Queen(5, 1), new Queen(6, 6), new Queen(7, 2))));

		// 0° and mirrored solution should exist
		assertTrue(solutions.contains(solution));
		assertTrue(solutions.contains(solution.mirror()));

		// 90° and mirrored solution should exist
		assertTrue(solutions.contains(solution.rotate()));
		assertTrue(solutions.contains(solution.rotate().mirror()));

		// 180° and mirrored solution should exist
		assertTrue(solutions.contains(solution.rotate().rotate()));
		assertTrue(solutions.contains(solution.rotate().rotate().mirror()));

		// 270° and mirrored solution should exist
		assertTrue(solutions.contains(solution.rotate().rotate().rotate()));
		assertTrue(solutions.contains(solution.rotate().rotate().rotate().mirror()));
	}

}
