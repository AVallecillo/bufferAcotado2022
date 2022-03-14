import java.util.ArrayList;

/**
 * Clase que implementa un buffer acotado
 * @author Alejandro Domínguez Recio
 * @version 1.1.1
 *
 */
public class BufferAcotado_ADominguez<T> {
	
	private int capacidadActual;
	

	private ArrayList<Integer> buffer;
	
	/**
	 * CONSTRUCTOR
	 * @param capacidad :int capacidad del buffer (numero maximo de elementos que puede contener)
	 * @throws IllegalArgumentException if (!capacidad<=0) // precondition
	 */
	public BufferAcotado_ADominguez(int capacidad) {
		if (capacidad <= 0) {
			throw new IllegalArgumentException("El tamaño inicial del buffer no puede ser <= 0");
		}
		buffer = new ArrayList(capacidad);
		capacidadActual = capacidad;
		
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
		if(capacidadActual==0) {
			throw new IllegalStateException("El buffer esta lleno");
		}
		buffer.add((Integer) element);
		capacidadActual--;
	}
	
	/**
	 * Retrieves and removes the head of the Buffer
	 * @return :T -- the element that was at the head of the Buffer
	 * @throws IllegalStateException if the buffer is empty -- precondition
	 * @post   the size of the buffer is decreased by 1
	 * @post   buffer@pre = buffer.prepend(result) 
	 */
	public int get() {
		if(buffer.size()==0) {
			throw new IllegalStateException("El buffer esta vacío");
		}
		int T = buffer.get(buffer.size()-1);
		buffer.remove(buffer.size()-1);
		capacidadActual++;
		return T;
	}
	
	/**
	 * This is a query operation that returns the number of elements currently in the buffer
	 * @return :int -- elements.size()
	 */
	public int size() {
		return buffer.size();
	}
	
	/**
	 * This is a query operation that checks if the buffer is full
	 * @return :boolean -- elements.size()==capacidad
	 */
	public boolean isFull() {
		boolean full = false;
		if(capacidadActual==0) {
			full = true;
		}
		return full;
	}
	
	/**
	 * This is a query operation that checks if the buffer is empty
	 * @return :boolean -- elements.size()==0
	 */
	public boolean isEmpty() {
		boolean empty = false;
		if((buffer.size()==0)) {
			empty = true;
		}
		return empty;
		
	}
}
