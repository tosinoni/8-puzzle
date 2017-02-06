import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch implements Strategy {

    private Stack<Node> nodeList = new Stack<>();
	private List<State> visitedStates = new ArrayList<>();
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

				if (node.getState().equals(goalState))
					return node;
				
				populateNodeList(node);
				
			}

		}
		return null;
	}
	
	public void populateNodeList(Node node) {
		Set<Node> newNodes = prodSystem.expand(node);
		
		for (Node n : newNodes) {
			if (!nodeList.contains(n) && !visitedStates.contains(n.getState())){
				nodeList.push(n);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String seq = "7 2 4 5 0 6 3 1";
		String finalSeq = "1 2 3 4 5 6 7 0";
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
		Node node = depthFirstSearch.search(seq, 2, 4, finalSeq);
		
		System.out.println(node.getState());
		System.out.println(node.getAction());
		
		String[] parts = node.getAction().split("-");
		 
		System.out.println(parts.length);
		 for (int i=0; i<parts.length; i++) {
			 State state = new State (parts[i], 2, 4);
			 state.print();
		 }
	}

}
