package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Node {

	private State state;
	private Node parent;
	private List<String> action;
	private int exactCost;
	private int estimateCost;

	public Node(State state) {
		this.state = state;
		this.action = new ArrayList<>();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parentNode) {
		this.parent = parentNode;
	}

	public List<String> getAction() {
		return action;
	}

	public void setAction(List<String> actions) {
		action = new ArrayList<>(actions);
	}
	
	public void setAction(String s) {
		this.action.add(s);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		else if (obj == null || obj.getClass() != this.getClass())
			return false;

		Node node = (Node) obj;

		return (this.state.equals(node.state)) && (this.action.equals(node.action)) && (this.parent.equals(node.parent))
				&& (this.exactCost == node.exactCost) && (this.estimateCost == node.estimateCost);
	}

	public int getExactCost() {
		return exactCost;
	}

	public int getTotalCost() {
		return exactCost + estimateCost;
	}

	public void setExactCost(int exactCost) {
		this.exactCost = exactCost;
	}

	public int getEstimateCost() {
		return estimateCost;
	}

	public void setEstimateCost(int estimateCost) {
		this.estimateCost = estimateCost;
	}

	public void clearActions () {
		action.clear();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + state.hashCode();
		result = prime * result + action.hashCode();
		result = prime * result + Integer.hashCode(exactCost);
		result = prime * result + Integer.hashCode(estimateCost);

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
