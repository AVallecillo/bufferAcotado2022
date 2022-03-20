

/**
 * Clase que implementa un buffer acotado.
 * @author Alejandro Pascual
 * @version 1.0
 *
 */
public class BufferAcotado_alexpascualm<T> {
	public class Node<T>{
		private T element;
		private Node<T> next; //referencia al siguiente nodo
		
		public Node(T it, Node<T> nextval){
			element = it;
			next = nextval;
		}
		
		public Node<T> setProximo(Node<T> nextval) { 
			return next = nextval;
			}
		public Node<T> Proximo(){
			return next;
			}
		public T setActual(T it) {
			return element = it;
			}
		public T Actual() {
			return element;
			}
	}
	private Node<T> cabeza, cola;
	private int capacidad;
	private int cantidad;

	/**
	 * CONSTRUCTOR
	 * @param capacidad :int capacidad del buffer (numero maximo de elementos que puede contener)
	 * @throws IllegalArgumentException if (!capacidad<=0) // precondition
	 */
	public BufferAcotado_alexpascualm(int cap) {
		if(!(cap<=0)) {
			capacidad=cap;
			cantidad=0;
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Inserts the specified element at the end of the Buffer 
	 * if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available
	 * @param  element :T -- the element to insert
	 * @throws IllegalStateException if the buffer is full.
	 * @post   the size of the buffer is increased by 1
	 * @post   the new element becomes the last element of the buffer
	 */
	public void put(T element) {
		if(this.size()==capacidad) {
			throw new IllegalStateException();
		}
		Node<T> newnode = new Node<T>(element,null);
		if (cabeza == null) {
			cabeza = cola = newnode;
			}
		else {
			cola = cola.setProximo(newnode); 
		}
		cantidad++;
	}
	
	/**
	 * Retrieves and removes the head of the Buffer
	 * @return :T -- the element that was at the head of the Buffer
	 * @throws IllegalStateException if the buffer is empty -- precondition
	 * @post   the size of the buffer is decreased by 1
	 * @post   buffer@pre = buffer.prepend(result) 
	 */
	public T get() {
		if (this.size()==0) {
			throw new IllegalStateException();
		}
		else {
			T valor=cabeza.Actual();
			cabeza = cabeza.Proximo();
			if (cabeza == null) {
				cola = null;
			}
			capacidad--;
			return valor;
		}
	}
	
	/**
	 * This is a query operation that returns the number of elements currently in the buffer
	 * @return :int -- elements.size()
	 */
	public int size() {
		return cantidad;
	}
	
	/**
	 * This is a query operation that checks if the buffer is full
	 * @return :boolean -- elements.size()==capacidad
	 */
	public boolean isFull() {
		if(this.size()==capacidad) {
			return true;
		}else {
		return false;
		}
	}
	
	/**
	 * This is a query operation that checks if the buffer is empty
	 * @return :boolean -- elements.size()==0
	 */
	public boolean isEmpty() {
		if(this.size()==0) {
			return true;
		}else {
		return false;
		}
	}
}