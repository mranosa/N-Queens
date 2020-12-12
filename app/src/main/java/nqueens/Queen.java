package nqueens;

import java.util.Set;

public class Queen implements Comparable<Queen> {
	private int row;
	private int column;

	/**
	 * Long live the Queen!
	 * 
	 * @param row    x position in board
	 * @param column y position in board
	 */
	public Queen(int row, int column) {
		this.row = row;
		this.column = column;
	}

	/**
	 * Checks if queen is safe from neighbors.
	 * 
	 * @param neighbors Set of nearby queens to be checked against
	 * @return true if safe, false if not
	 */
	public boolean isSafeFrom(Set<Queen> neighbors) {
		if (null == neighbors)
			return true;

		for (Queen neighbor : neighbors)
			if (!isSafeFrom(neighbor))
				return false;

		return true;
	}

	/**
	 * Checks if queen is safe from neighbors.
	 * 
	 * @param neighbor nearby queen to be checked against
	 * @return true if safe, false if not
	 */
	public boolean isSafeFrom(Queen neighbor) {
		return !isDiagonal(neighbor) && !isSameColumn(neighbor);
	}

	/**
	 * Checks if queen is in diagonal with neighbor
	 * 
	 * @param neighbor nearby queen to be checked against
	 * @return true if diagonal, false if not
	 */
	public boolean isDiagonal(Queen neighbor) {
		double rise = column - neighbor.getColumn();
		double run = row - neighbor.getRow();
		double slope = rise / run;

		return 1 == Math.abs(slope);
	}

	/**
	 * Checks if queen is in line with neighbor
	 * 
	 * @param neighbor nearby queen to be checked against
	 * @return true if in line, false if not
	 */
	public boolean isSameColumn(Queen neighbor) {
		return column == neighbor.column;
	}

	@Override
	public String toString() {
		return "[" + row + ":" + column + "]";
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}

	@Override
	public int compareTo(Queen other) {
		return row != other.row ? Integer.compare(row, other.row) : Integer.compare(column, other.column);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

}
