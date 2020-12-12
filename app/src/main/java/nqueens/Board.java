package nqueens;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Board implements Comparable<Board> {

	private Set<Queen> queens = new TreeSet<Queen>();

	/***
	 * Creates a new board.
	 * 
	 * @param queens Set of queens in the board
	 */
	public Board(Set<Queen> queens) {
		this.queens = queens;
	}

	/**
	 * Rotates the board 90 degrees from the center.
	 * 
	 * @return Board a new rotated board
	 */
	public Board rotate() {
		int[][] mat = toMatrix();
		mat = rotateMatrix(mat);

		return fromMatrix(mat);
	}

	/**
	 * Creates a mirror of the board.
	 * 
	 * @return Board a new mirrored board
	 */
	public Board mirror() {
		int[][] mat = toMatrix();
		mat = mirrorMatrix(mat);

		return fromMatrix(mat);
	}

	/**
	 * Shows board configuration.
	 */
	public void display() {
		int[][] matrix = mirrorMatrix(toMatrix());
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1) {
					System.out.print("Q ");
				} else {
					System.out.print("_ ");
				}
			}
			System.out.println("\n");
		}
	}

	/**
	 * Checks if Queens configuration in Board has 3 in same line.
	 * 
	 * @return boolean true if board has 3 queens same in line, false if none
	 */
	// https://stackoverflow.com/questions/39996798/n-queens-with-no-3-queens-on-same-line
	public boolean hasCollinear() {
		if (null == queens)
			return false;

		for (Queen x : queens) {
			for (Queen y : queens) {
				for (Queen z : queens) {
					if (x.equals(y) || x.equals(z) || y.equals(z))
						continue;

					boolean isCollinear = (x.getColumn() - y.getColumn())
							* (x.getRow() - z.getRow()) == (x.getColumn() - z.getColumn()) * (x.getRow() - y.getRow());

					if (isCollinear)
						return true;
				}
			}
		}

		return false;
	}

	private int[][] toMatrix() {
		int[][] matrix = new int[queens.size()][queens.size()];
		// https://stackoverflow.com/questions/7118178/arrays-fill-with-multidimensional-array-in-java
		Arrays.stream(matrix).forEach(a -> Arrays.fill(a, 0));

		for (Queen queen : queens) {
			matrix[queen.getRow()][queen.getColumn()] = 1;
		}

		return matrix;
	}

	private Board fromMatrix(int[][] matrix) {
		Set<Queen> queens = new TreeSet<Queen>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1) {
					queens.add(new Queen(i, j));
				}
			}
		}

		return new Board(queens);
	}

	// https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
	private int[][] rotateMatrix(int mat[][]) {
		int N = mat.length;
		for (int x = 0; x < N / 2; x++) {
			for (int y = x; y < N - x - 1; y++) {
				int temp = mat[x][y];
				mat[x][y] = mat[y][N - 1 - x];
				mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];
				mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];
				mat[N - 1 - y][x] = temp;
			}
		}

		return mat;
	}

	// https://stackoverflow.com/questions/29283760/mirroring-2d-arrays
	private int[][] mirrorMatrix(int mat[][]) {
		for (int j = 0; j < mat.length; ++j) {
			int[] row = mat[j];
			for (int i = 0; i < (row.length / 2); i++) {
				int temp = row[i];
				row[i] = mat[j][row.length - i - 1];
				row[row.length - i - 1] = temp;
			}
		}

		return mat;
	}

	@Override
	public int hashCode() {
		return queens.toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}

	@Override
	public String toString() {
		return queens.toString();
	}

	@Override
	public int compareTo(Board other) {
		return queens.toString().compareTo(other.toString());
	}

	public boolean contains(Queen queen) {
		return queens.contains(queen);
	}

	public void add(Queen queen) {
		queens.add(queen);
	}

	public void remove(Queen queen) {
		queens.add(queen);
	}

	public Set<Queen> getQueens() {
		return queens;
	}

}
