package src.searches;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedDeque;

import src.Node;
import src.ProductionSystem;
import src.State;
import src.Strategy;

public class DepthFirstSearch implements Strategy {

    private Stack<Node> nodeList = new Stack <>();
	private Set<State> visitedStates = new LinkedHashSet<>();
	private Map<String, Node> closed = new LinkedHashMap<>();

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
			Node node = nodeList.pop();

			if (!visitedStates.contains(node.getState())) {
				visitedStates.add(node.getState());
								
				closed.put(node.getState().toString(), node);

				//System.out.println(node.getState().toString() + " ----> " + visitedStates.size());
				//node.getState().print();
				if (node.getState().equals(goalState))
					return prodSystem.addPathToNode(node, closed);
				else if (visitedStates.size() == 220000)
					return null;
				
				for (Node n : prodSystem.expand(node, closed)){
						nodeList.push(n);
				}
									
			} 
			
			node.clearActions();


		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String seq = "0 0 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14";
		String finalSeq = "1 4 5 6 3 2 8 7 9 0 11 12 13 14 0 0";
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
		Node node = depthFirstSearch.search(seq, 4, 4, finalSeq);
		
		System.out.println(node.getAction().size());
		for (String s : node.getAction()) {
			State state = new State (s, 2, 5);
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
