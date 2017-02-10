package src.searches;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedDeque;

import src.Node;
import src.ProductionSystem;
import src.State;
import src.Strategy;

public class DepthFirstSearch implements Strategy {

    private Deque<Node> nodeList = new ArrayDeque <>();
	private Set<State> visitedStates = new LinkedHashSet<>();
	private ProductionSystem prodSystem;
	
	@Override
	public Node search(String sequence, int row, int col, String finalSequence) {
		if (sequence != null && !sequence.isEmpty()) {
			prodSystem = new ProductionSystem();
			State state = new State(sequence, row, col);
			Node node = new Node(state);
			
			nodeList.add(node);
			
			State goalState = new State(finalSequence, row, col);
			return treeSearch(goalState);

		}
		
		return null;	
	}
	
	private Node treeSearch(State goalState) {
		// TODO Auto-generated method stub
		while (!nodeList.isEmpty()) {
			Node node = nodeList.poll();

			if (!visitedStates.contains(node.getState())) {
				visitedStates.add(node.getState());
				
					System.out.println(node.getState().toString() + " ----> " + visitedStates.size());
				//node.getState().print();
				if (node.getState().equals(goalState))
					return node;
				
				for (Node n : prodSystem.expand(node)){
					if (!visitedStates.contains(n.getState()))
						nodeList.push(n);
				}
				
					
			}

		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String seq = "1 0 4 6 2 7 5 3 8";
		String finalSeq = "1 0 6 2 4 7 5 3 8";
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
		Node node = depthFirstSearch.search(seq, 3, 3, finalSeq);
		
		System.out.println(node.getState());
		for (String s : node.getAction()) {
			State state = new State (s, 3, 3);
			 state.print();
		}		
//		String[] parts = node.getAction().split("-");
//		 
//		System.out.println(parts.length);
//		 for (int i=0; i<parts.length; i++) {
//			 State state = new State (parts[i], 3, 3);
//			 state.print();
//		 }
	}

}
