/**
 * Clase que implementa un buffer acotado
 * @author Claudia Vega Rodriguez
 *
 */
public class BufferAcotado_ClaudiaVegaRodriguez<T> {
	
	private int capacidad;

	/**
	 * CONSTRUCTOR
	 * @param capacidad :int capacidad del buffer (numero maximo de elementos que puede contener)
	 * @throws IllegalArgumentException if (!capacidad<=0) // precondition
	 */
	public BufferAcotado(int capacidad) {
		capacidad = this.capacidad;
		if (capacidad <= 0) {
			throw new IllegalArgumentException("ERROR. Ese dato no es posible.")
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
		if () {
			throw new IllegalStateException("Error. The Buffer is full.");
		}
	}
	
	/**
	 * Retrieves and removes the head of the Buffer
	 * @return :T -- the element that was at the head of the Buffer
	 * @throws IllegalStateException if the buffer is empty -- precondition
	 * @post   the size of the buffer is decreased by 1
	 * @post   buffer@pre = buffer.prepend(result) 
	 */
	public T get() {
		return null;
	}
	
	/**
	 * This is a query operation that returns the number of elements currently in the buffer
	 * @return :int -- elements.size()
	 */
	public int size() {
		int elements = 0;
		return elements.size();
	}
	
	/**
	 * This is a query operation that checks if the buffer is full
	 * @return :boolean -- elements.size()==capacidad
	 */
	public boolean isFull() {
		boolean elements = false;

		if (elements.size() == capacidad) {
			return true;
		}
		return false;
	}
	
	/**
	 * This is a query operation that checks if the buffer is empty
	 * @return :boolean -- elements.size()==0
	 */
	public boolean isEmpty() {
		boolean elements = false;
		
		if (elements.size()== 0) {
			return true
		}
		return false;
	}
}
