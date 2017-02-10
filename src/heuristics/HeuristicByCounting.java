package src.heuristics;

import src.State;

public class HeuristicByCounting extends Heuristic{

	@Override 
	public int evaluate(State initialState, State goalState) {
		estimate = 0;
		for (int i=0; i<goalState.getRows(); i++) {
			for (int j=0; j<goalState.getColumns(); j++) {
				if (!goalState.getElement(i, j).equals("0") && 
						!initialState.getElement(i, j).equals(goalState.getElement(i, j)))
					estimate++;
			}
		}
		
		return estimate;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String seq = "2 8 3 1 6 4 0 7 5";
		String finalSeq = "1 2 3 8 0 4 7 6 5";
		Heuristic heuristic = new HeuristicByCounting();
		State initial = new State(seq, 3, 3);
		State goalState = new State(finalSeq, 3, 3);
		
		System.out.println(heuristic.evaluate(initial, goalState));
	}

}
