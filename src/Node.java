package src;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Node {

	public static int nodeCount = 0;
	private State state;
	private Node parent;
	private Set<String> action;
	private int exactCost;
	private int estimateCost;
	private int index;
	private int parentIndex;

	public Node(State state) {
		this.state = state;
		this.action = new LinkedHashSet<>();
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Set<String> getAction() {
		return action;
	}

	public void setAction(Set<String> actions) {
		this.action = actions;
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

		return (this.state.equals(node.state)) && (this.action.equals(node.action)) && (this.parent == node.parent)
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
	
	public static void increaseNodeCount() {
		nodeCount++;
	}
	
	
	public int getParentIndex() {
		return parentIndex;
	}

	public void setParentIndex(int parentIndex) {
		this.parentIndex = parentIndex;
	}

	public static int getNodeCount() {
		return nodeCount;
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
