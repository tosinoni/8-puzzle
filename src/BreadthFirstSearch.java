import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;


public class BreadthFirstSearch implements Strategy{

	private ProductionSystem prodSystem;
	private Queue<Node> nodeList = new ConcurrentLinkedQueue<>();
	private Set<State> visitedStates = new LinkedHashSet<>();
	
	@Override
	public Node search(String sequence, int row, int col, String finalSequence) {
		// TODO Auto-generated method stub
		
		if (sequence != null && !sequence.isEmpty()) {
			prodSystem = new ProductionSystem();
			State state = new State(sequence, row, col);
			Node node = new Node(state);
			node.setAction(state.toString());
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

				if (node.getState().equals(goalState))
					return node;

				nodeList.addAll(prodSystem.expand(node));

			}

		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String seq = "1 0 4 6 2 7 5 3 8";
		String finalSeq = "1 2 3 4 0 5 6 7 8";
		BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
		Node node = breadthFirstSearch.search(seq, 3, 3, finalSeq);
		
		 
		System.out.println(node.getState());
		System.out.println(node.getAction());
		String[] parts = node.getAction().split("-");
		 
		System.out.println(parts.length);
		 for (int i=0; i<parts.length; i++) {
			 State state = new State (parts[i], 3, 3);
			 state.print();
		 }

	}

}
