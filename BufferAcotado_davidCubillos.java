package buffer;
/**
 * Clase que implementa un buffer acotado
 * @author david cubillos del toro
 * @version 1.1
 *
 */
public class BufferAcotado<T> {
	private T[] lista; // the queue 
	private int capacidad;
	private int head,cola,elementos ;
	
	/**
	 * CONSTRUCTOR
	 * 
	 * @param capacidad :int capacidad del buffer (numero maximo de elementos que puede contener)
	 * @throws IllegalArgumentException if (!capacidad<=0) // precondition
	 */
	public BufferAcotado(int a) {// porbar si a esto se le puede pasar un int rebosante.
		if (a<=0) throw new IllegalArgumentException ("la capaciad debe ser al menos 1");
		elementos=head=cola=0;
		capacidad=a;
		lista = (T[])new Object[a];
	}
	// llena -la cabeza esta en el objeto mas nuevo 
	//vacio-objeto y cola 
	/**
	 * Inserts the specified element at the end of the Buffer 
	 * if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available
	 * @param  element :T -- the element to insert
	 * @throws IllegalStateException if the buffer is full.
	 * @post   the size of the buffer is increased by 1
	 * @post   the new element becomes the last element of the buffer
	 */
	public void put(T element) {// que la clase no sea del tipo t( instance of T )
		//primera insercion 
		if ( this.isFull()) throw new IllegalStateException();
		
		
			
			elementos+=1;
			lista [this.head]= element ;
			int seguridad =1; 
			if (this.isFull()) {
				seguridad = 0;
				}
			
			if (head== this.capacidad-1) {
				head =0;
			}else {
				head +=1;
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
		if (this.isEmpty())throw new IllegalStateException () ;
		T devolver = this.lista[this.cola];
		elementos-=1;
				

			if (cola== this.capacidad-1) {
				cola =0;
			}else {
				cola +=1;
			}
		
		
		
		return devolver;
	}
	
	/**
	 * This is a query operation that returns the number of elements currently in the buffer
	 * @return :int -- elements.size()
	 */
	public int size() {
		return this.elementos;
	}
	
	/**
	 * This is a query operation that checks if the buffer is full
	 * @return :boolean -- elements.size()==capacidad
	 */
	public boolean isFull() {
		return this.elementos== this.capacidad;
	}
	
	/**
	 * This is a query operation that checks if the buffer is empty
	 * @return :boolean -- elements.size()==0
	 */
	public boolean isEmpty() {
		return this.elementos==0;
	}
}
