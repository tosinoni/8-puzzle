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
	
	public List<Node> handleNonKnightNodes(Node parentNode) {		
		List<State> states = move.getNonKnightStatesAfterMove(parentNode.getState());
		
		return createNodesFromStates(parentNode, states);
	}
	
	public List<Node> createNodesFromStates (Node parentNode, List<State> states) {
		if (states.isEmpty()) return null;
		
		List<Node> nodes = new ArrayList<>();

		for (State state : states) {
			Node node = new Node(state);
			node.setParent(parentNode);
			node.setAction(parentNode.getAction() + " - " + state);
			
			nodes.add(node);
		}
		
		return nodes;
	}
	
	public List<Node> handleKnightNodes(Node parentNode) {
		List<Node> nodes = new ArrayList<>();
		
		State state = parentNode.getState();
		
		for (int i=0; i<state.getRows() - 1; i++) {
			for (int j=0; j<state.getColumns(); j++){
				List<State> states = move.getKnightStatesAfterMove(state, state.getGrid()[i][j]);
				
				List<Node> newNodes = createNodesFromStates(parentNode, states);
				
				if(newNodes != null && newNodes.size() > 0)
					nodes.addAll(newNodes);
			}
		}

		return nodes;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		State state = new State("7 2 4 5 0 6 8 3 1", 3, 3);
		ProductionSystem prod = new ProductionSystem();
		
		Node node = new Node(state);
		
		Set<Node> nodes = prod.expand(node);
		
		for (Node n : nodes) {
			n.getState().print();
		}
	}

}
