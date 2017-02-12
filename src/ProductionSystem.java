package src;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductionSystem {

	private Move move;

	public ProductionSystem() {
		move = new Move();
	}

	public Set<Node> expand(Node node, Map<String, Node> visited) {
		Set<Node> nodes = new LinkedHashSet<>();

		nodes.addAll(handleNonKnightNodes(node, visited));
		nodes.addAll(handleKnightNodes(node, visited));

		return nodes;
	}

	public Set<Node> handleNonKnightNodes(Node parentNode, Map<String, Node> visited) {
		Set<String> states = new LinkedHashSet<>();
		for (int index : parentNode.getState().getEmptySpaces().keySet()) {
			states.addAll(move.getNonKnightStatesAfterMove(parentNode.getState(), index));
		}

		return createNodesFromStates(parentNode, states, visited);
	}

	public Set<Node> createNodesFromStates(Node parentNode, Set<String> states, Map<String, Node> visited) {
		if (states.isEmpty())
			return null;

		Set<Node> nodes = new LinkedHashSet<>();
		List<String> list = new ArrayList<>(parentNode.getAction());
		for (String state : states) {
			if (visited.get(state) == null) {
				State s = new State(state, parentNode.getState().getRows(), parentNode.getState().getColumns());
				Node node = new Node(s);
				node.setParent(parentNode);
				node.setAction(list);
				node.setAction(state);

				nodes.add(node);
			}
		}

		list.clear();

		return nodes;
	}

	public Set<Node> handleKnightNodes(Node parentNode, Map<String, Node> visited) {
		Set<Node> nodes = new LinkedHashSet<>();

		State state = parentNode.getState();

		for (int i = 0; i < state.getRows() - 1; i++) {
			for (int j = 0; j < state.getColumns(); j++) {
				Set<String> states = move.getKnightStatesAfterMove(state, state.getGrid()[i][j]);

				Set<Node> newNodes = createNodesFromStates(parentNode, states, visited);

				if (newNodes != null && newNodes.size() > 0)
					nodes.addAll(newNodes);
			}
		}

		return nodes;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// State state = new State("1 0 3 6 2 7 5 4 8);

		State state = new State("0 2 4 6 1 7 5 3 0", 3, 3);

		ProductionSystem prod = new ProductionSystem();

		 Node node = new Node(state);
		 node.getState().print();
		//
		 Set<Node> nodes = prod.expand(node, new LinkedHashMap<>());
		//
	    for (Node n : nodes) {
		  n.getState().print();
		// System.out.println(n.getState().toString());
	   }
	}

}
