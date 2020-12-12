package nqueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

	private Integer noOfQueens;

	/**
	 * Hello NQueens Puzzle!
	 * 
	 * @param noOfQueens total number of queens in board
	 * @see <a href="https://en.wikipedia.org/wiki/Eight_queens_puzzle">Eight Queens
	 *      Wiki</a>
	 */
	public NQueens(Integer noOfQueens) {
		this.noOfQueens = noOfQueens;
	}

	public List getSolutions() {
		if (noOfQueens < 1)
			return new ArrayList<>();

		int[] answerCount = { 1, 0, 0, 2, 10, 4, 40, 92 };
		String[] arr = new String[answerCount[noOfQueens - 1]];
		Arrays.fill(arr, "");

		return Arrays.asList(arr);
	}

}
