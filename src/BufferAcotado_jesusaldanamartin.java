import java.util.LinkedList;
import java.util.Queue;

/**
	 * Clase que implementa un buffer acotado
	 * @author Jesus Aldana Martin
	 * @version 1.1
	 *
	 */

	public class BufferAcotado_jesusaldanamartin<T> {
		
		private int capacidad, tam;
		private Queue<T> buffer;
		

		/**
		 * CONSTRUCTOR
		 * @param capacidad :int capacidad del buffer (numero maximo de elementos que puede contener)
		 * @throws IllegalArgumentException if (!capacidad<=0) // precondition
		 */
		
		public BufferAcotado_jesusaldanamartin(int capacidad) {
			if(capacidad <= 0) {
				throw new IllegalArgumentException("El buffer debe tener al menos un elemento");
			}
			buffer = new LinkedList<T>();
			this.capacidad = capacidad;
			
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
			if(isFull() == true) {
				throw new IllegalStateException("Buffer lleno o inexistente");
			}

			buffer.add(element);
			tam = tam +1;
			
		}
		
		/**
		 * Retrieves and removes the head of the Buffer
		 * @return :T -- the element that was at the head of the Buffer
		 * @throws IllegalStateException if the buffer is empty -- precondition
		 * @post   the size of the buffer is decreased by 1
		 * @post   buffer@pre = buffer.prepend(result) 
		 */
		public T get() {
			if(isEmpty() == true) {
				throw new IllegalStateException("Buffer vacio");
			}
			tam = tam-1;
			return buffer.poll();
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
			if(buffer.size() == capacidad) {
				return true;
			}			
			return false;
		}
		
		/**
		 * This is a query operation that checks if the buffer is empty
		 * @return :boolean -- elements.size()==0
		 */
		public boolean isEmpty() {
			if(buffer.size() == 0) {
				return true;
			}
			return false;
		}
	}
