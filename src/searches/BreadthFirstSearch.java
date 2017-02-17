package src.searches;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import src.Node;
import src.ProductionSystem;
import src.State;
import src.Strategy;


public class BreadthFirstSearch implements Strategy{

	private ProductionSystem prodSystem;
	private Queue<Node> nodeList = new ConcurrentLinkedQueue<>();
	private Set<State> visitedStates = new LinkedHashSet<>();
	private Map<String, Node> closed = new LinkedHashMap<>();
	
	@Override
	public Node search(String sequence, int row, int col, String finalSequence) {
		// TODO Auto-generated method stub
		
		if (sequence != null && !sequence.isEmpty()) {
			prodSystem = new ProductionSystem();
			State state = new State(sequence, row, col);
			Node node = new Node(state);
			
			node.setParent(null);

			nodeList.add(node);
			
			State goalState = new State(finalSequence, row, col);
			return treeSearch(goalState);

		}
		return null;
	}
	
	public Node treeSearch(State goalState) {

		while (!nodeList.isEmpty()) {
			Node node = nodeList.poll();

			if (!visitedStates.contains(node.getState())) {
				visitedStates.add(node.getState());
				closed.put(node.getState().toString(), node);
//				System.out.println(node.getState() + "  ======== " + visitedStates.size());
				//node.getState().print();
				if (node.getState().equals(goalState) || visitedStates.size() == 300000)
					return prodSystem.addPathToNode(node, closed);

				nodeList.addAll(prodSystem.expand(node, closed));

			}

		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String seq = "1 2 3 4 0 6 5 8 7 9";
		String finalSeq = "1 2 3 4 5 6 7 8 9 0";
		BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
		Node node = breadthFirstSearch.search(seq, 2, 5, finalSeq);
		
		 
		System.out.println(node.getState());
		//System.out.println(node.getAction());
		
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
