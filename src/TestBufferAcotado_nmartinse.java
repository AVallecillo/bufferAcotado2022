/**
 * @author Nerea
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class TestBufferAcotado_nmartinse {

	BufferAcotado<Integer> b;

	@BeforeEach
	public void init() {
		b = new BufferAcotado<>(2);
	}

	/**
	 * Test para probar que se lanza la excepción IllegalArgumentException si se
	 * instancia un objeto con una capacidad igual o menor que 0
	 */

	@Test
	public void test_BufferAcotado() {
		assertThrows(IllegalArgumentException.class, () -> new BufferAcotado<>(0));
		assertThrows(IllegalArgumentException.class, () -> new BufferAcotado<>(-5));
	}

	/**
	 * Test para comporar que se lanza la expcepción IllegalArgumentException si se
	 * intenta añadir un elemento a un buffer lleno
	 */
	@Test
	public void test_put_bufferLleno() {
		b.put(3);
		b.put(4);
		assertThrows(IllegalStateException.class, () -> b.put(5));
	}

	/**
	 * Test para comprobar que el tamaño se incremeta si añadimos un elemento al
	 * buffer
	 */
	@Test
	public void test_put_incrementSize() {
		int pre = b.size();
		b.put(3);
		assertEquals(pre + 1, b.size());
	}

	/**
	 * Test para probar que el ultimo elemento añadido esta al final de la cola
	 */
	@Test
	public void test_put_lastElement() {
		b.put(3);
		b.put(4);
		b.get();
		assertEquals(4, b.get());
	}
	
	@Test
	public void test_get_bufferVacio() {
		assertThrows(IllegalStateException.class, () -> b.get());
	}
	
	@Test
	public void test_get_decreasedSize() {
		b.put(3);
		int pre = b.size();
		b.get();
		assertEquals(pre - 1, b.size());
	}
	
	@Test
	public void test_size() {
		assertEquals(0, b.size());
		b.put(2);
		b.put(3);
		assertEquals(2, b.size());
		b.get();
		assertEquals(1, b.size());
	}
	
	@Test
	public void test_isFull() {
		assertFalse(b.isFull());
		b.put(2);
		b.put(3);
		assertTrue(b.isFull());
		b.get();
		assertFalse(b.isFull());
	}
	
	@Test
	public void test_isEmpty() {
		assertTrue(b.isEmpty());
		b.put(3);
		assertFalse(b.isEmpty());
		b.get();
		assertTrue(b.isEmpty());
	}
}