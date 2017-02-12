package src.searches;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import src.Node;
import src.ProductionSystem;
import src.State;
import src.Strategy;
import src.heuristics.Heuristic;
import src.heuristics.HeuristicByAverage;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class AstarSearch implements Strategy {

	private Map<String, Node> open;
	private Map<String, Node> closed;
	private Heuristic heuristic;
	private ProductionSystem prodSystem;

	public AstarSearch(Heuristic heuristic) {
		this.heuristic = heuristic;
		this.prodSystem = new ProductionSystem();
		this.open = new LinkedHashMap<>();
		this.closed = new LinkedHashMap<>();
	}

	public Heuristic getHeuristic() {
		return heuristic;
	}

	public void setHeuristic(Heuristic heuristic) {
		this.heuristic = heuristic;
	}

	@Override
	public Node search(String sequence, int row, int col, String finalSequence) {
		if (sequence != null && !sequence.isEmpty()) {
			prodSystem = new ProductionSystem();
			State state = new State(sequence, row, col);
			Node node = new Node(state);

			State goalState = new State(finalSequence, row, col);
			node.setEstimateCost(heuristic.evaluate(state, goalState));
			open.put(state.toString(), node);
			return treeSearch(goalState);

		}

		return null;
	}

	private Node treeSearch(State goalState) {
		// TODO Auto-generated method stub
		while (!open.isEmpty()) {
			Node node = open.entrySet().iterator().next().getValue();

			if (node.getState().equals(goalState))
				return node;
			//node.getState().print();
			Set<Node> successors = prodSystem.expand(node, closed);
			open.remove(node.getState().toString());
			closed.put(node.getState().toString(), node);

			for (Node n : successors) {
				n.setEstimateCost(heuristic.evaluate(n.getState(),
						goalState));
				n.setExactCost(node.getExactCost() + 1);
				if (open.get(n.getState().toString()) != null) {
					open = updateNodeInMap(n, open);
				} else if (closed.get(n.getState().toString()) != null) {
					closed = updateNodeInMap(n, closed);
				} else {
					open.put(n.getState().toString(), n);
				}
			}
			
			open = sortMap(open);
			closed = sortMap(closed);
		}
		return null;
	}

	public Map<String, Node> updateNodeInMap(Node n, Map<String, Node> map) {
		Node nodeFromMap = map.get(n.getState().toString());

		if (nodeFromMap.getTotalCost() > n.getTotalCost()) {
			map.remove(nodeFromMap.getState().toString());
			map.put(n.getState().toString(), n);
		}
		
		return map;
	}

	private Map<String, Node> sortMap(Map<String, Node> map) {
		List<Map.Entry<String, Node>> entryList = new ArrayList<>(
				map.entrySet());

		Collections.sort(entryList, new Comparator<Map.Entry<String, Node>>() {
			@Override
			public int compare(Map.Entry<String, Node> node,
					Map.Entry<String, Node> node1) {
				return Integer.compare(node.getValue().getTotalCost(), node1
						.getValue().getTotalCost());
			}
		});
		
		Map<String, Node> newMap = new LinkedHashMap<>();
		for (Entry<String, Node> e : entryList) {
			newMap.put(e.getKey(),  e.getValue());
			
		}
		

		return newMap;
	}

	public static void main(String[] args) {

		String seq = "1 0 4 6 2 7 5 3 8";
		String finalSeq = "1 2 3 4 5 6 7 8 0";
		AstarSearch astarSearch = new AstarSearch(new HeuristicByAverage());
		Node node = astarSearch.search(seq, 3, 3, finalSeq);
		
		 
		System.out.println(node.getState());
		//System.out.println(node.getAction());
		
		for (String s : node.getAction()) {
			State state = new State (s, 3, 3);
			 state.print();
		}
	}

}
