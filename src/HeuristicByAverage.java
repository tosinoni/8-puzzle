package src;

import java.util.List;

public class HeuristicByAverage extends Heuristic {

	private HeuristicByCounting heuristicByCounting;
	private HeuristicByDistance HeuristicByDistance;

	public HeuristicByAverage() {
		heuristicByCounting = new HeuristicByCounting();
		HeuristicByDistance = new HeuristicByDistance();
	}

	@Override
	public int evaluate(State initialState, State goalState) {
		estimate = (heuristicByCounting.evaluate(initialState, goalState)
				+ HeuristicByDistance.evaluate(initialState, goalState)) / 2;

		return estimate;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String seq = "5 0 8 4 2 1 7 3 6";
				String finalSeq = "1 2 3 4 5 6 7 8 0";
				Heuristic heuristic = new HeuristicByAverage();
				State initial = new State(seq, 3, 3);
				State goalState = new State(finalSeq, 3, 3);
				
				System.out.println(heuristic.evaluate(initial, goalState));
	}
}
