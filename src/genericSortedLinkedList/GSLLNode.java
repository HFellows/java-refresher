package genericSortedLinkedList;

public class GSLLNode<G extends Comparable<G>> {
	GSLLNode<G> next = null;
	G data = null;
	
	public GSLLNode(G data) {
		this.data = data;
	}
	
	public void add(GSLLNode<G> node){
		next = node;
	}
}
