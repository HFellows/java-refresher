package genericSortedLinkedList;


import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class GSLL<G extends Comparable<G>> {
	
	private GSLLNode<G> head;
	private int size;
	
	public GSLL() {
		head = null;
		size = 0;
	}

	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return (0 == size);
	}
	
	
	public void add(G item){
		//if the data is null
		if (null == item){
			NullPointerException p = new NullPointerException("Can't add null to this list");
			throw  p;
		} 
		
		// now we can assume that we're making a node;
		GSLLNode<G> node = new GSLLNode<G>(item);
		size++;
		
		//if the head is empty
		if (null == head){
			head = node;
			return;
		}
		
		//we'll need a reference to the element we need to compare to
		GSLLNode<G> currentNode = head;
		
		//if the head is greater than the new item
		if (head.data.compareTo(item) > 0){
			head = node;
			node.next = currentNode;
			return;
		}
				
		//now we find the first element greater than the new item
		while(null != currentNode.next){ //while the tmp is less than the new item
			if(currentNode.next.data.compareTo(item) > 0){
				break;
			}
			currentNode = currentNode.next;
		}
		
		//we've gotten to the point where TMP is less than / equal to the new item
		insert(currentNode, node);
	}
	
	public G get(int i){
		if (i > size || i < 0){
			return null;
		}
		GSLLNode<G> tmp = head;
		for (int j = 0; j < i; j++) {
			tmp = tmp.next;
		}
		return tmp.data;
	}
	public void map(UnaryOperator<G> lambda){
		GSLLNode<G> currentNode = head;
		while(null != currentNode){
			currentNode.data = lambda.apply(currentNode.data);
			currentNode = currentNode.next;
		}
	}
	
	public synchronized void filter(Predicate<G> lambda){
		GSLLNode<G> currentNode = head;
		head = null;
		size = 0;
		while(null != currentNode){
			if(lambda.test(currentNode.data)){
				this.add(currentNode.data);
			}
			currentNode = currentNode.next;
		}
	}
	
	public void print(){
		System.out.println("- Linked List -");
		GSLLNode<G> tmp = head;
		while(null != tmp){
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
		System.out.println("- - - - - - - -");
	}
		
	private void insert(GSLLNode<G> oldNode, GSLLNode<G> node){
		GSLLNode<G> nextNode = oldNode.next;
		oldNode.next = node;
		node.next = nextNode;
	}
	
}
