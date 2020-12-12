package nqueens;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class NQueens {

	private Integer noOfQueens;
	private Set<Board> solutions = new TreeSet<Board>();

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

	/**
	 * Returns solutions for N Queens challenge.
	 * 
	 * @return Set of board
	 */
	public Set<Board> getSolutions() {
		if (noOfQueens > 0)
			solve(noOfQueens, 0, solutions, new ArrayList<Queen>());

		return solutions;
	}

	private void solve(int N, int row, Set<Board> solutions, List<Queen> queens) {
		if (queens.size() == N) {
			Set<Queen> copy = new TreeSet<Queen>(queens);
			Board board = new Board(copy);

			generateSolutions(solutions, board);
		} else if (row < N) {
			for (int column = 0; column < N; column++) {
				Queen queen = new Queen(row, column);
				Set<Queen> queenSet = new TreeSet<Queen>(queens);

				if (queen.isSafeFrom(queenSet))
					queens.add(queen);

				solve(N, row + 1, solutions, queens);

				queens.remove(queen);
			}
		}
	}

	private void generateSolutions(Set<Board> solutions, Board board) {
		// 0°
		solutions.add(board);
		solutions.add(board.mirror());

		// 90°
		Board rotated = board.rotate();
		solutions.add(rotated);
		solutions.add(rotated.mirror());

		// 180°
		rotated = board.rotate();
		solutions.add(rotated);
		solutions.add(rotated.mirror());

		// 270°
		rotated = board.rotate();
		solutions.add(rotated);
		solutions.add(rotated.mirror());
	}

}
