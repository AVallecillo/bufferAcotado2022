import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase que implementa un buffer acotado
 * 
 * @author Antonio Vallecillo, Florin Babusca Voicu
 * @version 1.1
 *
 */
public class BufferAcotado_FlorinUMA<T> {

	private int capacidad;
	private Queue<T> elementos;

	/**
	 * CONSTRUCTOR
	 * 
	 * @throws IllegalArgumentException if (!capacidad<=0) // precondition
	 */
	public BufferAcotado_FlorinUMA(int capacidad) {
		if (capacidad > 0) {
			this.capacidad = capacidad;
			elementos = new LinkedList<T>();
		} else {
			throw new IllegalArgumentException("La capacidad NO puede ser negativa");
		}
	}

	/**
	 * Inserts the specified element at the end of the Buffer if it is possible to
	 * do so immediately without violating capacity restrictions, returning true
	 * upon success and throwing an IllegalStateException if no space is currently
	 * available
	 * 
	 * @param element :T -- the element to insert
	 * @throws IllegalStateException if the buffer is full.
	 * @post the size of the buffer is increased by 1
	 * @post the new element becomes the last element of the buffer
	 */
	public void put(T element) {
		if (elementos.size() < this.capacidad) {
			elementos.add(element);
		} else {
			throw new IllegalStateException("El buffer esta lleno");
		}
	}

	/**
	 * Retrieves and removes the head of the Buffer
	 * 
	 * @return :T -- the element that was at the head of the Buffer
	 * @throws IllegalStateException if the buffer is empty -- precondition
	 * @post the size of the buffer is decreased by 1
	 * @post buffer@pre = buffer.prepend(result)
	 */
	public T get() {
		T valor = elementos.poll();
		if (valor == null) {
			throw new IllegalStateException("El buffer esta vacio");
		}
		return valor;

	}

	/**
	 * This is a query operation that returns the number of elements currently in
	 * the buffer
	 * 
	 * @return :int -- elements.size()
	 */
	public int size() {
		return elementos.size();
	}

	/**
	 * This is a query operation that checks if the buffer is full
	 * 
	 * @return :boolean -- elements.size()==capacidad
	 */
	public boolean isFull() {
		return (capacidad == elementos.size());
	}

	/**
	 * This is a query operation that checks if the buffer is empty
	 * 
	 * @return :boolean -- elements.size()==0
	 */
	public boolean isEmpty() {
		return elementos.isEmpty();
	}
}
