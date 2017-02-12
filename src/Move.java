package src;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Move {

	public boolean isNorth(State state, int num) {
		if (state == null)
			return false;
		return (state.findNumber(num).get(0) - 1) >= 0;
	}

	public boolean isSouth(State state, int num) {
		if (state == null)
			return false;
		return (state.findNumber(num).get(0) + 1) < state.getRows();
	}

	public boolean isEast(State state, int num) {
		if (state == null)
			return false;
		
		return (state.findNumber(num).get(1) + 1) < state.getColumns();
	}

	public boolean isWest(State state, int num) {
		if (state == null)
			return false;
		int column = state.findNumber(num).get(1);
		return (column - 1) >= 0;
	}

	public boolean isNorthEast(State state, int num) {
		return isNorth(state, num) && isEast(state, num);
	}

	public boolean isNorthWest(State state, int num) {
		return isNorth(state, num) && isWest(state, num);
	}

	public boolean isSouthEast(State state, int num) {
		return isSouth(state, num) && isEast(state, num);
	}

	public boolean isSouthWest(State state, int num) {
		return isSouth(state, num) && isWest(state, num);
	}

	public boolean isKnightMoveSouthEast(State state, String num) {
		if (state == null)
			return false;

		List<Integer> list = state.findNumber(num);
		int col = list.get(1);
		int row = list.get(0);

		return (row + 2) < state.getRows() && (col + 1) < state.getColumns() && 
				!state.getGrid()[row + 2][col + 1].equals("0")&& !state.getGrid()[row][col].equals("0");
	}
	
	public boolean isKnightMoveSouthEast1(State state, String num) {
		if (state == null)
			return false;

		List<Integer> list = state.findNumber(num);
		int col = list.get(1);
		int row = list.get(0);

		return (row + 1) < state.getRows() && (col + 2) < state.getColumns() && 
				!state.getGrid()[row + 1][col + 2].equals("0") && !state.getGrid()[row][col].equals("0");
	}

	public boolean isKnightMoveSouthWest(State state, String num) {
		if (state == null)
			return false;

		List<Integer> list = state.findNumber(num);
		int col = list.get(1);
		int row = list.get(0);

		return (row + 2) < state.getRows() && (col - 1) >= 0 && 
				!state.getGrid()[row + 2][col - 1].equals("0") && !state.getGrid()[row][col].equals("0");
	}
	
	public boolean isKnightMoveSouthWest1(State state, String num) {
		if (state == null)
			return false;

		List<Integer> list = state.findNumber(num);
		int col = list.get(1);
		int row = list.get(0);

		return (row + 1) < state.getRows() && (col - 2) >= 0 && 
				!state.getGrid()[row + 1][col - 2].equals("0") && !state.getGrid()[row][col].equals("0");
	}

	public String north(State s, int num) {
		if (isNorth(s, num)) {
			List<Integer> emptySpace = s.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);

			String elementA = "0";
			int index = emptySpace.get(2);
			String elementB = s.getElement(row - 1, col);
			int indexB = s.getIndex(elementB);
			
			return s.swapElementsInGrid(index, elementA, indexB, elementB);
		}

		return null;
	}

	public String south(State s, int num) {
		if (isSouth(s, num)) {
			List<Integer> emptySpace = s.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			
			String elementA = "0";
			int index = emptySpace.get(2);
			String elementB = s.getElement(row + 1, col);
			int indexB = s.getIndex(elementB);
			
			return s.swapElementsInGrid(index, elementA, indexB, elementB);
		}

		return null;
	}

	public String east(State s, int num) {
		if (isEast(s, num)) {
			List<Integer> emptySpace = s.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			
			String elementA = "0";
			int index = emptySpace.get(2);
			String elementB = s.getElement(row, col + 1);
			int indexB = s.getIndex(elementB);
			
			return s.swapElementsInGrid(index, elementA, indexB, elementB);
		}

		return null;
	}

	public String west(State s, int num) {
		if (isWest(s, num)) {
			List<Integer> emptySpace = s.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			
			String elementA = "0";
			int index = emptySpace.get(2);
			String elementB = s.getElement(row, col - 1);
			int indexB = s.getIndex(elementB);
			
			return s.swapElementsInGrid(index, elementA, indexB, elementB);
		}

		return null;
	}

	public String northEast(State s, int num) {

		if (isNorthEast(s, num)) {
			List<Integer> emptySpace = s.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			
			String elementA = "0";
			int index = emptySpace.get(2);
			String elementB = s.getElement(row - 1, col + 1);
			int indexB = s.getIndex(elementB);
			
			return s.swapElementsInGrid(index, elementA, indexB, elementB);
		}

		return null;
	}

	public String northWest(State s, int num) {
		if (isNorthWest(s, num)) {
			List<Integer> emptySpace = s.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			
			String elementA = "0";
			int index = emptySpace.get(2);
			String elementB = s.getElement(row - 1, col - 1);
			int indexB = s.getIndex(elementB);
			
			return s.swapElementsInGrid(index, elementA, indexB, elementB);
		}

		return null;
	}

	public String southEast(State s, int num) {
		if (isSouthEast(s, num)) {
			List<Integer> emptySpace = s.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			
			String elementA = "0";
			int index = emptySpace.get(2);
			String elementB = s.getElement(row + 1, col + 1);
			int indexB = s.getIndex(elementB);
			
			return s.swapElementsInGrid(index, elementA, indexB, elementB);
		}

		return null;
	}

	public String southWest(State s, int num) {
		if (isSouthWest(s, num)) {
			List<Integer> emptySpace = s.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			
			String elementA = "0";
			int index = emptySpace.get(2);
			String elementB = s.getElement(row + 1, col - 1);
			int indexB = s.getIndex(elementB);
			
			return s.swapElementsInGrid(index, elementA, indexB, elementB);
		}

		return null;
	}

	public String knightSouthEast(State s, String num) {

		if (isKnightMoveSouthEast(s, num)) {
			List<Integer> emptySpace = s.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			
			String elementA = num;
			int index = s.getIndex(elementA);
			String elementB = s.getElement(row + 2, col + 1);
			int indexB = s.getIndex(elementB);

			return s.swapElementsInGrid(index, elementA, indexB, elementB);
		}

		return null;
	}
	
	public String knightSouthEast1(State s, String num) {
		
		if (isKnightMoveSouthEast1(s, num)) {
			List<Integer> emptySpace = s.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			
			String elementA = num;
			int index = s.getIndex(elementA);
			String elementB = s.getElement(row + 1, col + 2);
			int indexB = s.getIndex(elementB);
			
			return s.swapElementsInGrid(index, elementA, indexB, elementB);
		}

		return null;
	}

	public String knightSouthWest(State s, String num) {

		if (isKnightMoveSouthWest(s, num)) {
			List<Integer> emptySpace = s.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			
			String elementA = num;
			int index = s.getIndex(elementA);
			String elementB = s.getElement(row + 2, col - 1);
			int indexB = s.getIndex(elementB);
			
			return s.swapElementsInGrid(index, elementA, indexB, elementB);
		}

		return null;
	}
	
	public String knightSouthWest1(State s, String num) {
		if (isKnightMoveSouthWest1(s, num)) {
			List<Integer> emptySpace = s.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			
			String elementA = num;
			int index = s.getIndex(elementA);
			String elementB = s.getElement(row + 1, col - 2);
			int indexB = s.getIndex(elementB);
			
			return s.swapElementsInGrid(index, elementA, indexB, elementB);
		}

		return null;
	}
	
	public Set<String> getNonKnightStatesAfterMove(State state, int num) {
		Set<String> states = new LinkedHashSet<>();
		
		states.add(north(state, num));
		states.add(south(state, num));
		states.add(east(state, num));
		states.add(west(state, num));
		states.add(northEast(state, num));
		states.add(northWest(state, num));
		states.add(southEast(state, num));
		states.add(southWest(state, num));
		
		states.removeAll(Collections.singleton(null));
		return states;
	}
	
	public Set<String> getKnightStatesAfterMove(State state, String num) {
		Set<String> states = new LinkedHashSet<>();
		
		states.add(knightSouthEast(state, num));
		states.add(knightSouthEast1(state, num));
		states.add(knightSouthWest(state, num));
		states.add(knightSouthWest1(state, num));

		states.removeAll(Collections.singleton(null));
		return states;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		State state = new State("0 1 0 4 6 2 7 5 3", 3, 3);

		Move move = new Move();
		state.print();
		//System.out.println(move.getNonKnightStatesAfterMove(state, "01"));

		//System.out.println(move.isKnightMoveSouthWest(state, "7"));
//		for (String s : move.getNonKnightStatesAfterMove(state, 1)) {
//			State state1 = new State(s, 3, 3);
//
//			state1.print();
//		}
//		move.knightSouthEast(state, "2");
//		state.print();
		
		for (int i=0; i<state.getRows() - 1; i++) {
			for (int j=0; j<state.getColumns(); j++){
				Set<String> states = move.getKnightStatesAfterMove(state, state.getGrid()[i][j]);
				
				for (String s : states){
					State state1 = new State(s, 3, 3);
					state1.print();
				}
			}
		}

	}

}
