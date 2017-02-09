import java.util.Arrays;
import java.util.List;

public class State {

	private String[][] grid;
	private int rows;
	private int columns;

	public State (State state) {
		this(state.toString(), state.rows, state.columns);
		
	}
	public State(String sequence, int rows, int columns) {
		grid = new String[rows][columns];
		this.rows = rows;
		this.columns = columns;
		populateGrid(sequence);
	}

	private void populateGrid(String sequence) {
		String[] numbers = sequence.replaceAll("[^-?0-9]+", " ").trim().split(" ");

		int index = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				grid[i][j] = numbers[index];
				index++;
			}
		}
	}

	public String[][] getGrid() {
		return grid;
	}

	public void setGrid(String[][] grid) {
		this.grid = grid;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public String[][] swapElementsInGrid(int row, int col, int row1, int col1) {
		String temp = grid[row][col];
		grid[row][col] = grid[row1][col1];
		grid[row1][col1] = temp;

		return grid;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				s += grid[i][j] + " ";
			}
		}

		return s.trim();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		else if (obj == null || obj.getClass() != this.getClass())
			return false;

		State state = (State) obj;

		return (this.rows == state.rows) && (this.columns == state.columns)
				&& (Arrays.deepEquals(grid, state.grid));
	}

	private void printLine(int num) {
		for (int i = 0; i < num; i++)
			System.out.print("-");
		System.out.println();
	}

	public List<Integer> findNumber(String s) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (s.equals(grid[i][j]))
					return Arrays.asList(i, j);
			}
		}
		
		return null;
	}
	public void print() {
		int numLines = (columns + 1) + (columns * 2) + columns;
		printLine(numLines);

		for (int i = 0; i < rows; i++) {
			System.out.print("|");
			for (int j = 0; j < columns; j++) {
				if (!grid[i][j].equals("0")) {
					System.out.print(" " + grid[i][j] + " |");
				} else {
					System.out.print("  " + " |");

				}
			}
			System.out.print("\n");
			printLine(numLines);
		}

	}
	
	 @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + columns;
	        result = prime * result + rows;
	        result = prime * result + Arrays.deepHashCode(grid);

	        return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		State state = new State("0 1 2 3 4 5 6 7 8 9", 2, 5);
		state.print();
	}

}
