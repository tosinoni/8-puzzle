import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Move {

	public boolean isNorth(State state) {
		if (state == null)
			return false;
		return (state.findNumber("0").get(0) - 1) >= 0;
	}

	public boolean isSouth(State state) {
		if (state == null)
			return false;
		return (state.findNumber("0").get(0) + 1) < state.getRows();
	}

	public boolean isEast(State state) {
		if (state == null)
			return false;
		
		return (state.findNumber("0").get(1) + 1) < state.getColumns();
	}

	public boolean isWest(State state) {
		if (state == null)
			return false;
		int column = state.findNumber("0").get(1);
		return (column - 1) >= 0;
	}

	public boolean isNorthEast(State state) {
		return isNorth(state) && isEast(state);
	}

	public boolean isNorthWest(State state) {
		return isNorth(state) && isWest(state);
	}

	public boolean isSouthEast(State state) {
		return isSouth(state) && isEast(state);
	}

	public boolean isSouthWest(State state) {
		return isSouth(state) && isWest(state);
	}

	public boolean isKnightMoveSouthEast(State state, String num) {
		if (state == null)
			return false;

		List<Integer> list = state.findNumber(num);
		int col = list.get(1);
		int row = list.get(0);

		return (row + 2) < state.getRows() && (col + 1) < state.getColumns() && 
				!state.getGrid()[row + 2][col + 1].equals("0") && !state.getGrid()[row][col].equals("0");
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

	public State north(State state) {
		if (isNorth(state)) {
			State newState = new State(state);
			List<Integer> emptySpace = newState.findNumber("0");
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			newState.swapElementsInGrid(row, col, row - 1, col);

			return newState;
		}

		return null;
	}

	public State south(State s) {
		State newState = new State(s);

		if (isSouth(newState)) {
			List<Integer> emptySpace = newState.findNumber("0");
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			newState.swapElementsInGrid(row, col, row + 1, col);

			return newState;
		}

		return null;
	}

	public State east(State s) {
		State newState = new State(s);
		if (isEast(newState)) {
			List<Integer> emptySpace = newState.findNumber("0");
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			newState.swapElementsInGrid(row, col, row, col + 1);

			return newState;
		}

		return null;
	}

	public State west(State s) {
		State newState = new State(s);

		if (isWest(newState)) {
			List<Integer> emptySpace = newState.findNumber("0");
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			newState.swapElementsInGrid(row, col, row, col - 1);

			return newState;
		}

		return null;
	}

	public State northEast(State s) {
		State newState = new State(s);

		if (isNorthEast(newState)) {
			List<Integer> emptySpace = newState.findNumber("0");
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			newState.swapElementsInGrid(row, col, row - 1, col + 1);

			return newState;
		}

		return null;
	}

	public State northWest(State s) {
		State newState = new State(s);

		if (isNorthWest(newState)) {
			List<Integer> emptySpace = newState.findNumber("0");
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			newState.swapElementsInGrid(row, col, row - 1, col - 1);

			return newState;
		}

		return null;
	}

	public State southEast(State s) {
		State newState = new State(s);

		if (isSouthEast(newState)) {
			List<Integer> emptySpace = newState.findNumber("0");
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			newState.swapElementsInGrid(row, col, row + 1, col + 1);

			return newState;
		}

		return null;
	}

	public State southWest(State s) {
		State newState = new State(s);

		if (isSouthWest(newState)) {
			List<Integer> emptySpace = newState.findNumber("0");
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			newState.swapElementsInGrid(row, col, row + 1, col - 1);

			return newState;
		}

		return null;
	}

	public State knightSouthEast(State s, String num) {
		State newState = new State(s);

		if (isKnightMoveSouthEast(newState, num)) {
			List<Integer> emptySpace = newState.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			newState.swapElementsInGrid(row, col, row + 2, col + 1);

			return newState;
		}

		return null;
	}
	
	public State knightSouthEast1(State s, String num) {
		State newState = new State(s);

		if (isKnightMoveSouthEast1(newState, num)) {
			List<Integer> emptySpace = newState.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			newState.swapElementsInGrid(row, col, row + 1, col + 2);

			return newState;
		}

		return null;
	}

	public State knightSouthWest(State s, String num) {
		State newState = new State(s);

		if (isKnightMoveSouthWest(newState, num)) {
			List<Integer> emptySpace = newState.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			newState.swapElementsInGrid(row, col, row + 2, col - 1);

			return newState;
		}

		return null;
	}
	
	public State knightSouthWest1(State s, String num) {
		State newState = new State(s);

		if (isKnightMoveSouthWest1(newState, num)) {
			List<Integer> emptySpace = newState.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			newState.swapElementsInGrid(row, col, row + 1, col - 2);

			return newState;
		}

		return null;
	}
	
	public List<State> getNonKnightStatesAfterMove(State state) {
		List<State> states = new ArrayList<>();
		
		states.add(north(state));
		states.add(south(state));
		states.add(east(state));
		states.add(west(state));
		states.add(northEast(state));
		states.add(northWest(state));
		states.add(southEast(state));
		states.add(southWest(state));
		
		states.removeAll(Collections.singleton(null));
		return states;
	}
	
	public List<State> getKnightStatesAfterMove(State state, String num) {
		List<State> states = new ArrayList<>();
		
		states.add(knightSouthEast(state, num));
		states.add(knightSouthEast1(state, num));
		states.add(knightSouthWest(state, num));
		states.add(knightSouthWest1(state, num));

		states.removeAll(Collections.singleton(null));
		return states;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		State state = new State("8 1 0 4 6 2 7 5 3", 3, 3);

		Move move = new Move();
		state.print();
		System.out.println(move.getNonKnightStatesAfterMove(state).size());

		//System.out.println(move.isKnightMoveSouthWest(state, "7"));
//		for (State s : move.getNonKnightStatesAfterMove(state)) {
//			s.print();
//		}
//		move.knightSouthEast(state, "2");
//		state.print();
		
		for (int i=0; i<state.getRows() - 1; i++) {
			for (int j=0; j<state.getColumns(); j++){
				List<State> states = move.getKnightStatesAfterMove(state, state.getGrid()[i][j]);
				
				for (State s : states) s.print();
			}
		}

	}

}
