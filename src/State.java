package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class State {

	private String[][] grid;
	private int rows;
	private int columns;
	private List<String> tiles;
    private Map<Integer, List<Integer>> emptySpaces;
	public State (State state) {
		this(state.toString(), state.rows, state.columns);
		
	}
	public State(String sequence, int rows, int columns) {
		tiles = new ArrayList<>();
		grid = new String[rows][columns];
		this.rows = rows;
		this.columns = columns;
		this.emptySpaces = new LinkedHashMap<>();
		populateGrid(sequence.trim());
	}

	private void populateGrid(String sequence) {
		String[] numbers = sequence.replaceAll("[^-?0-9]+", " ").trim().split(" ");

		int index = 0;
		int emptySpaceIndex = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				grid[i][j] = numbers[index];
				tiles.add(numbers[index]);
				
				if (grid[i][j].equals("0")) {
					emptySpaces.put(emptySpaceIndex, Arrays.asList(i,j, tiles.size() - 1));
					emptySpaceIndex++;
				}
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

	public String swapElementsInGrid(int index, String elementA, int indexB, String elementB) {
		
		tiles.set(index, elementB);
		tiles.set(indexB, elementA);
		
		String s = toString();
		tiles.set(index, elementA);
		tiles.set(indexB, elementB);

		return s;
	}

	public List<String> getTiles() {
		return tiles;
	}
	public void setTiles(List<String> tiles) {
		this.tiles = tiles;
	}
	
	
	public Map<Integer, List<Integer>> getEmptySpaces() {
		return emptySpaces;
	}
	public String toString() {
		String s = "";
		for (String tile : tiles) {
				s += tile + " ";
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
	
	public List<Integer> findNumber(int index) {
		return emptySpaces.get(index);
	}
	
	public String getElement(int i, int j) {
		if (i >= 0 && i<rows && j>=0 && j < columns) 
			return grid[i][j];
		
		return null;
	}
	
	public int getIndex(String s) {
		return tiles.indexOf(s);
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
		State state = new State("1 0 4 6 2 7 5 3", 2, 4);
		state.print();
	}
	

}
