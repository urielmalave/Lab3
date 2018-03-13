package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.util.NoSuchElementException;

import linkedLists.LinkedList;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 
	
	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		// TODO Auto-generated method stub
		if(length==0){
			first = (SNode<E>) nuevo;
			last = (SNode<E>) nuevo;
		}else{
		 ((SNode<E>)nuevo).setNext(first);
		 first = (SNode<E>) nuevo;
		}
		length++; 
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		// TODO Auto-generated method stub
		if(target==last){
			((SNode<E>) target).setNext((SNode<E>)nuevo);
			last = (SNode<E>)nuevo;
		}else{
			((SNode<E>) nuevo).setNext(((SNode<E>)target).getNext());
			((SNode<E>) target).setNext(((SNode<E>)nuevo));
		}
		length++; 
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		// TODO Auto-generated method stub
		if(target==first){
			((SNode<E>) nuevo).setNext(first);
			first=(SNode<E>) nuevo;
		} else{
			SNode<E> current = first;
			for(int i=0; i<length; i++){
				if(current.getNext()==target){
					((SNode<E>) current).setNext(((SNode<E>)nuevo));
					((SNode<E>) nuevo).setNext(((SNode<E>)target));
				}
			}
			
		}
		length++; 	
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return first;
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(target == last)
			throw new NoSuchElementException("getNodeAfter(...) : target is the last node."); 
		else
			return ((SNode<E>) target).getNext();

	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(target == first)
			throw new NoSuchElementException("getNodeBefore(...) : target is the first node."); 
		else{
			SNode<E> current = first;
			for (int i = 0; i<length; i++){
				if(current.getNext()==target)
					return current;
				current = current.getNext();
			}
		}
		return null;

	}

	public int length() {
		// TODO Auto-generated method stub
		return length;
	}

	public void removeNode(Node<E> target) {
		// TODO Auto-generated method stub
		if(target==first)
			first = first.getNext();
		else{
			SNode<E> current = first;
			for (int i = 0; i<length-1; i++){
				if(current.getNext()==target){		
					if(target==last){
						current.setNext(null);
						last=current;
					}else{
						current.setNext(((SNode<E>)target).getNext());
					}
				}
				current = current.getNext();
			}
		}
		target.setElement(null);
		((SNode<E>)target).setNext(null);
		
		length--; 

	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}

}
