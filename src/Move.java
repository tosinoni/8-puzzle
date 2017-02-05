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
				!state.getGrid()[row + 2][col + 1].equals("0");
	}
	
	public boolean isKnightMoveSouthEast1(State state, String num) {
		if (state == null)
			return false;

		List<Integer> list = state.findNumber(num);
		int col = list.get(1);
		int row = list.get(0);

		return (row + 1) < state.getRows() && (col + 2) < state.getColumns() && 
				!state.getGrid()[row + 1][col + 2].equals("0");
	}

	public boolean isKnightMoveSouthWest(State state, String num) {
		if (state == null)
			return false;

		List<Integer> list = state.findNumber(num);
		int col = list.get(1);
		int row = list.get(0);

		return (row + 2) < state.getRows() && (col - 1) >= 0 && 
				!state.getGrid()[row + 2][col - 1].equals("0");
	}
	
	public boolean isKnightMoveSouthWest1(State state, String num) {
		if (state == null)
			return false;

		List<Integer> list = state.findNumber(num);
		int col = list.get(1);
		int row = list.get(0);

		return (row + 1) < state.getRows() && (col - 2) >= 0 && 
				!state.getGrid()[row + 1][col - 2].equals("0");
	}

	public State north(State state) {
		if (isNorth(state)) {
			List<Integer> emptySpace = state.findNumber("0");
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			state.swapElementsInGrid(row, col, row - 1, col);

			return state;
		}

		return null;
	}

	public State south(State state) {
		if (isSouth(state)) {
			List<Integer> emptySpace = state.findNumber("0");
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			state.swapElementsInGrid(row, col, row + 1, col);

			return state;
		}

		return null;
	}

	public State east(State state) {
		if (isEast(state)) {
			List<Integer> emptySpace = state.findNumber("0");
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			state.swapElementsInGrid(row, col, row, col + 1);

			return state;
		}

		return null;
	}

	public State west(State state) {
		if (isWest(state)) {
			List<Integer> emptySpace = state.findNumber("0");
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			state.swapElementsInGrid(row, col, row, col - 1);

			return state;
		}

		return null;
	}

	public State northEast(State state) {
		if (isNorthEast(state)) {
			List<Integer> emptySpace = state.findNumber("0");
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			state.swapElementsInGrid(row, col, row - 1, col + 1);

			return state;
		}

		return null;
	}

	public State northWest(State state) {
		if (isNorthWest(state)) {
			List<Integer> emptySpace = state.findNumber("0");
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			state.swapElementsInGrid(row, col, row - 1, col - 1);

			return state;
		}

		return null;
	}

	public State southEast(State state) {
		if (isSouthEast(state)) {
			List<Integer> emptySpace = state.findNumber("0");
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			state.swapElementsInGrid(row, col, row + 1, col + 1);

			return state;
		}

		return null;
	}

	public State southWest(State state) {
		if (isSouthWest(state)) {
			List<Integer> emptySpace = state.findNumber("0");
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			state.swapElementsInGrid(row, col, row + 1, col - 1);

			return state;
		}

		return null;
	}

	public State knightSouthEast(State state, String num) {
		if (isKnightMoveSouthEast(state, num)) {
			List<Integer> emptySpace = state.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			state.swapElementsInGrid(row, col, row + 2, col + 1);

			return state;
		}

		return null;
	}
	
	public State knightSouthEast1(State state, String num) {
		if (isKnightMoveSouthEast1(state, num)) {
			List<Integer> emptySpace = state.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			state.swapElementsInGrid(row, col, row + 1, col + 2);

			return state;
		}

		return null;
	}

	public State knightSouthWest(State state, String num) {
		if (isKnightMoveSouthWest(state, num)) {
			List<Integer> emptySpace = state.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			state.swapElementsInGrid(row, col, row + 2, col - 1);

			return state;
		}

		return null;
	}
	
	public State knightSouthWest1(State state, String num) {
		if (isKnightMoveSouthWest1(state, num)) {
			List<Integer> emptySpace = state.findNumber(num);
			int row = emptySpace.get(0);
			int col = emptySpace.get(1);
			state.swapElementsInGrid(row, col, row + 1, col - 2);

			return state;
		}

		return null;
	}
	
	public List<State> getNonKnightStatesAfterMove(State state) {
		List<State> states = new ArrayList<>();
		
		states.add(north(new State(state)));
		states.add(south(new State(state)));
		states.add(east(new State(state)));
		states.add(west(new State(state)));
		states.add(northEast(new State(state)));
		states.add(northWest(new State(state)));
		states.add(southEast(new State(state)));
		states.add(southWest(new State(state)));
		
		states.removeAll(Collections.singleton(null));
		return states;
	}
	
	public List<State> getKnightStatesAfterMove(State state, String num) {
		List<State> states = new ArrayList<>();
		
		states.add(knightSouthEast(new State(state), num));
		states.add(knightSouthEast1(new State(state), num));
		states.add(knightSouthWest(new State(state), num));
		states.add(knightSouthWest1(new State(state), num));

		states.removeAll(Collections.singleton(null));
		return states;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		State state = new State("7 2 4 5 0 6 8 3 1", 3, 3);

		Move move = new Move();

		//System.out.println(move.isNorthEast(state));

		//System.out.println(move.isKnightMoveSouthWest(state, "7"));
		for (State s : move.getNonKnightStatesAfterMove(state)) {
			s.print();
		}
//		move.knightSouthEast(state, "2");
//		state.print();

	}

}
