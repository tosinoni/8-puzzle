package src;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import src.heuristics.HeuristicByAverage;
import src.heuristics.HeuristicByCounting;
import src.heuristics.HeuristicByDistance;
import src.searches.AstarSearch;
import src.searches.BreadthFirstSearch;
import src.searches.DepthFirstSearch;

public class PuzzleUI {

	public void handleBreadthFirstSearch(String sequence, int row, int col) {

	}

	public static boolean isCoordinateValid(String[] coordinates) {
		try {
			return coordinates.length == 2 && Integer.parseInt(coordinates[0]) >= 0
					&& Integer.parseInt(coordinates[1]) >= 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	private static String getGoalState (int num) {
		String s = "";
		for (int i=0; i<num; i++) {
			s += i + " ";
		}
		
		return s.trim();
	}

	public static boolean isSequenceValid(String seq, int num) {
		if (seq == null || seq.isEmpty())
			return false;

		String[] coordinates = seq.replaceAll("[^0-9]+", " ").split(" ");
		return coordinates.length == num;
	}

	public static void printSearchOptions(Scanner sc, String sequence, int row, int col) {
		System.out.println("1. Breadth First Search");
		System.out.println("2. Depth First Search");
		System.out.println("3. A star Search");

		System.out.println("Please enter the search you want to perform: ");

		String finalSeq = getGoalState(row * col);
		Node node;
		String search = sc.nextLine();
		if (search.equals("1")) {
			BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
			node = breadthFirstSearch.search(sequence, row, col, finalSeq);
		} else if (search.equals("2")) {
			DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
			node = depthFirstSearch.search(sequence, row, col, finalSeq);
		} else {
			node = printHeuristicSearchOptions(sc, sequence, row, col);
		}

		for (String s : node.getAction()) {
			State state = new State(s, row, col);
			state.print();
		}
	}

	public static Node printHeuristicSearchOptions(Scanner sc, String sequence, int row, int col) {
		System.out.println("1. Heuristic By Counting Tiles");
		System.out.println("2. Heuristic By Distance");
		System.out.println("3. Heuristic By Average");
		
		
		System.out.println("Please enter the heuristic search you want to do: ");

		String finalSeq = getGoalState(row * col);

		String heuristic = sc.nextLine();
		AstarSearch astarSearch;
		if (heuristic.equals("1")) {
			astarSearch = new AstarSearch(new HeuristicByCounting());
		} else if (heuristic.equals("2")) {
			astarSearch = new AstarSearch(new HeuristicByDistance());
		} else {
			astarSearch = new AstarSearch(new HeuristicByAverage());
		}

		return astarSearch.search(sequence, row, col, finalSeq);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean repeat = true;
		String seq = null;
		int rows;
		int cols;

		while (repeat) {
			System.out.println("Please enter the number of rows and columns in the format: row x col: ");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();

			String[] coordinates = input.replaceAll("[^-?0-9]+", " ").split(" ");

			if (isCoordinateValid(coordinates)) {
				rows = Integer.parseInt(coordinates[0]);
				cols = Integer.parseInt(coordinates[1]);

				boolean sequenceValid = false;
				while (!sequenceValid) {
					System.out.println(
							"Please enter the sequence or initial state for the board. Use 0 to signify empty space: ");
					seq = sc.nextLine();
					sequenceValid = isSequenceValid(seq, rows * cols);
				}

				boolean searchRequested = true;

				while (searchRequested) {
					System.out.println("1. Yes");
					System.out.println("2. No");
					System.out.println("Do you want to perform a search? : ");

					input = sc.nextLine();

					if (input.equals("1"))
						printSearchOptions(sc, seq, rows, cols);
					else
						searchRequested = false;

				}

				System.out.println("1. Yes");
				System.out.println("2. No");
				System.out.println("Do you want to Exit? : ");
				if (input.equals("1")){
					sc.close();
					repeat = false;
				}
			}
		}

		System.exit(0);
	}

}
