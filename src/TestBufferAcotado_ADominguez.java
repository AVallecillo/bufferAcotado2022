import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * 
 * @author Alejandro Dom�nguez Recio
 *
 */

public class TestBufferAcotado_ADominguez {
	
	private BufferAcotado<Integer> buffer;
	
	
	@BeforeEach
	public void TestBufferAcotado() {
		buffer = new BufferAcotado(5);
		
	}
	
	@Test
	public void TestBufferAcotadoNeg() {
		// Comprobamos que cuando se pretende inicializar un buffer con tama�o <=0 lanza una excepci�n
		assertThrows(IllegalArgumentException.class, () -> new BufferAcotado(-1));
		assertThrows(IllegalArgumentException.class, () -> new BufferAcotado(0));

	}
	
	@Test
	public void TestPut() {
		// Comprobamos que el �ltimo elemento introducido es el �ltimo en la lista
		buffer.put(1);
		assertEquals(1, buffer.get());
		//Probamos teniendo mas de un elemento
		buffer.put(2);
		assertEquals(2, buffer.get());
		
		//Comprobamos que el tama�o se incrementa cuando se le introduce un elemento.
		int tamBefore = buffer.size();
		buffer.put(2);
		assertEquals(tamBefore+1, buffer.size());
		
		// Comprobamos que cuando se pretende introducir un elemento en la lista estando llena nos lanza una excepci�n
		while(!buffer.isFull()) {
			buffer.put(1);
		}
		assertThrows(IllegalStateException.class, () -> buffer.put(1));
	}
	
	@Test
	public void TestGet() {
		// Comprobamos que lanza una excepci�n si queremos obtener un elemento y el buffer est� vac�o
		assertThrows(IllegalStateException.class, () -> buffer.get());
		
		// Comprobamos que el tama�o del buffer decrece al obtener elementos
		buffer.put(2);
		int tamBefore = buffer.size();
		buffer.get();
		assertEquals(tamBefore-1, buffer.size());
		

	}
	
	@Test 
	public void TestIsFull() {
		// Comprobams que cuando el buffer est� lleno nos devuelve true.
		// Tenemos en cuenta que nuestro buffer inicial tiene capacidad para 5 elementos
		for(int n=0; n<5; n++) {
			buffer.put(n);
		}
		assertTrue(buffer.isFull());
		
		//A su vez comprobamos lo inverso, que cuando no est� lleno nos devuelve false
		buffer.get();
		assertFalse(buffer.isFull());
	}

	@Test
	public void TestIsEmpty() {
		// Comprobams que cuando el buffer est� vac�o nos devuelve true.
		// Tenemos en cuenta que nuestro buffer inicialmente est� vac�o
		assertTrue(buffer.isEmpty());
		
		//A su vez comprobamos lo inverso, que cuando el buffer est� lleno devuelve false
		for(int n=0; n<5; n++) {
			buffer.put(n);
		}
		assertFalse(buffer.isEmpty());
	}
}
