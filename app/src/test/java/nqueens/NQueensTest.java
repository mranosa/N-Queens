package nqueens;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class NQueensTest {

	/**
	 * Should return 0 solution when input is less than 1
	 */
	@Test
	public void test_input() {
		NQueens nQueens = new NQueens(-1);
		List solutions = nQueens.getSolutions();

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
		// TODO should have correct number of queens in board
		// TODO should have no two queens in the same row
		// TODO should have no two queens in the same column
		// TODO should have no two queens diagonal each other

		fail("Not yet implemented");
	}

	/**
	 * Ensure all solutions are returned
	 */
	@Test
	public void test_correct_solutions_count() {
		// should have correct number of solutions per number of queens
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
			List solutions = nQueens.getSolutions();

			assertEquals((int) pair.getValue(), solutions.size());
		}
	}

	/**
	 * Ensure all returned solutions are correct
	 */
	@Test
	public void test_correct_solutions() {
		// TODO [[0:5], [1:3], [2:0], [3:4], [4:7], [5:1], [6:6], [7:2]] in 8
		// TODO 0° and mirrored solution should exist
		// TODO 90° and mirrored solution should exist
		// TODO 180° and mirrored solution should exist
		// TODO 270° and mirrored solution should exist

		fail("Not yet implemented");
	}

}
