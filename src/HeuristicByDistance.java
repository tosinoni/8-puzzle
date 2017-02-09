package src;

import java.util.List;

public class HeuristicByDistance extends Heuristic {

	@Override 
	public int evaluate(State initialState, State goalState) {
		estimate = 0;
		for (int i=0; i<goalState.getRows(); i++) {
			for (int j=0; j<goalState.getColumns(); j++) {
				String initialStateValue = initialState.getElement(i, j);
				if (!initialStateValue.equals("0") && 
						!initialStateValue.equals(goalState.getElement(i, j))) {

					List<Integer> goalStateCord = goalState.findNumber(initialStateValue);
					estimate += Math.abs(i - goalStateCord.get(0));
					estimate += Math.abs(j - goalStateCord.get(1));
				}
			}
		}
		
		return estimate;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String seq = "5 0 8 4 2 1 7 3 6";
				String finalSeq = "1 2 3 4 5 6 7 8 0";
				Heuristic heuristic = new HeuristicByDistance();
				State initial = new State(seq, 3, 3);
				State goalState = new State(finalSeq, 3, 3);
				
				System.out.println(heuristic.evaluate(initial, goalState));
	}

}
