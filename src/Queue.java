
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author Jack Maloney
 *
 */


import java.util.NoSuchElementException;

public class Queue<T> {

	private QueueElement<T> head;
	private QueueElement<T> tail;
	
	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
		this.head = null;
		this.tail = null;
	}
	
	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty () {
	    //TODO:
		return (head == null) && (tail == null);
	}
	
	
	/**
	 * Returns the element at the head of the queue
	 */
	public T peek () throws NoSuchElementException {
		if (this.isEmpty()){
			throw new NoSuchElementException("Queue is empty!");
		}else{
			return this.head.getElement();
		}
	}
	
	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException {
		if(this.isEmpty()){
			throw new NoSuchElementException("Queue is empty!");
		}else {
			this.head = head.getNext();
			if (this.head == null){
				this.tail = null;
			}
		}
	}
	
	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (T element) {
		QueueElement<T> newNode = new QueueElement<T>(element, null);
		if (this.head == null){
			this.head = newNode;
			this.tail = newNode;
		}else{
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
		QueueElement<T> current = this.head;
		if (this.isEmpty()){
			System.out.println("The queue is empty.");
		}
		while (current != null){
			System.out.println(current.getElement());
			current = current.getNext();
		}
	}
}
