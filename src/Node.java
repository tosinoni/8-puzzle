package src;

import java.util.LinkedHashSet;
import java.util.Set;

public class Node {

	private State state;
	private Node parent;
	private Set<String> action;
	private int exactCost;
	private int estimateCost;
	
	public Node (State state) {
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


	public Set<String> getAction() {
		return action;
	}

	public void setAction(Set<String> actions) {
		this.action.addAll(actions);
	}
	public void setAction(String action) {
		this.action.add(action);
	}

	public boolean equals (Object obj) {
		if (this == obj)
			return true;

		else if (obj == null || obj.getClass() != this.getClass())
			return false;

		Node node = (Node) obj;

		return (this.state.equals(node.state)) && (this.action == node.action)
				&& (this.parent.equals(node.parent));
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


	@Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + state.hashCode();
	        result = prime * result + action.hashCode();

	        return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
