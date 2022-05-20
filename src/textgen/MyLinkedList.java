package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		// TODO: Implement this method
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if(element == null) {
			throw new NullPointerException();
		}
		LLNode<E> node = new LLNode<E>(element);
		node.next = tail;
		node.prev = tail.prev;
		node.prev.next = node;
		tail.prev = node;
		
		size +=1;
		// TODO: Implement this method
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index)
	{
		LLNode<E> node = head.next;
		if(index == -1 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		for(int i =0 ; i <index;i++) {
			node = node.next;
		}
		// TODO: Implement this method.
		return node.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		LLNode<E> node = new LLNode<E>(element);
		LLNode<E> spot = head.next;
		if(element == null) {
			throw new NullPointerException();
		}
		if(index >= 0 && index < size) {
			for(int i =0 ; i <index;i++) {
				spot = spot.next;
			}
			node.next = spot;
			node.prev = spot.prev;
			spot.prev.next = node;
			spot.prev = node;
			size +=1;
		}
		else if(size == 0 && index == 0) {
			node.next = tail;
			node.prev = head;
			head.next = node;
			tail.prev = node;
			size +=1;
		}
		
		else {
			throw new IndexOutOfBoundsException();
		}

		// TODO: Implement this method
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		LLNode<E> spot = head.next;

		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		for(int i =0 ; i<index;i++) {
			spot = spot.next;
		}
		spot.next.prev = spot.prev;
		spot.prev.next = spot.next;
		spot.next = null;
		spot.prev = null;
		size -=1;
		
		// TODO: Implement this method
		return spot.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		LLNode<E> node = new LLNode<E>(element);
		LLNode<E> spot = head.next;
		if(index == -1 || index >= size && index != 0) {
			throw new IndexOutOfBoundsException();
		}
		if(element == null) {
			throw new NullPointerException();
		}
		for(int i =0 ; i <index;i++) {
			spot = spot.next;
		}
		node.next = spot.next;
		node.prev = spot.prev;
		spot.prev.next = node;
		spot.next.prev = node;
		spot.next = null;
		spot.prev = null;
		
		// TODO: Implement this method
		return spot.data;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
