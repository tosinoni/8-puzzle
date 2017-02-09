import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ProductionSystem {
    
	private Move move;
	
	public ProductionSystem () {
		move = new Move();
	}
	
	public Set<Node> expand(Node node) {
		Set<Node> nodes = new LinkedHashSet<>();
		
		nodes.addAll(handleNonKnightNodes(node));
		nodes.addAll(handleKnightNodes(node));

		return nodes;
	}
	
	public Set<Node> handleNonKnightNodes(Node parentNode) {		
		List<State> states = move.getNonKnightStatesAfterMove(parentNode.getState());
		
		return createNodesFromStates(parentNode, states);
	}
	
	public Set<Node> createNodesFromStates (Node parentNode, List<State> states) {
		if (states.isEmpty()) return null;
		
		Set<Node> nodes = new LinkedHashSet<>();
         
		for (State state : states) {
			Node node = new Node(state);
			node.setParent(parentNode);
			

			node.setAction(parentNode.getAction() + " - " + state.toString());
			
			nodes.add(node);
		}
		
		return nodes;
	}
	
	public Set<Node> handleKnightNodes(Node parentNode) {
		Set<Node> nodes = new LinkedHashSet<>();
		
		State state = parentNode.getState();
		
		for (int i=0; i<state.getRows() - 1; i++) {
			for (int j=0; j<state.getColumns(); j++){
				List<State> states = move.getKnightStatesAfterMove(state, state.getGrid()[i][j]);
				
				Set<Node> newNodes = createNodesFromStates(parentNode, states);
				
				if(newNodes != null && newNodes.size() > 0)
					nodes.addAll(newNodes);
			}
		}

		return nodes;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		State state = new State("1 2 4 6 0 5 7 3 8", 3, 3);
		
		State state = new State("1 0 4 6 2 7 5 3 8", 3, 3);

		ProductionSystem prod = new ProductionSystem();
		
		Node node = new Node(state);
		node.getState().print();
		
		Set<Node> nodes = prod.expand(node);
		
		for (Node n : nodes) {
			n.getState().print();
		}
	}

}
