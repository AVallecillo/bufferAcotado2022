import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 * Test del BufferAcotado
 * @author Hugo Avalos de Rorthais
 *
 */

public class TestBufferAcotado_hugoavalos01 {

	private BufferAcotado<Integer> b = new BufferAcotado<>(5);

	@Test
	void crear() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new BufferAcotado<>(-5));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new BufferAcotado<>(0));
	}

	@Test
	void putIsFull() {
		// Se lanza la excepcion si el buffer esta lleno
		for (int i = 0; i < b.size(); i++) {
			b.put(i);
		}
		Assertions.assertThrows(IllegalStateException.class, () -> b.put(1));
	}

	@Test
	void put() {
		//El último elemento que se introduce es ultimo
		b.put(3);
		Assertions.assertEquals(3, b.get());
		
		//El tamaño aumenta al introducir un elemento
		int sizeB = b.size();
		b.put(3);
		Assertions.assertEquals(sizeB+1, b.size());
	}

	@Test
	void get() {
		//Si esta vacio, lanza una excepcion
		Assertions.assertThrows(IllegalStateException.class, () -> b.get());
		
		//Se decrementa el tamaño al hacer un get
		b.put(3);
		int sizeB = b.size();
		b.get();
		Assertions.assertEquals(sizeB-1, b.size());
		
	}
	
	@Test
	void isFull() {
		//Comprobamos que devuelve true cuando está lleno, y false cuando no
		for (int i = 0; i < b.size(); i++) {
			b.put(i);
		}
		
		Assertions.assertTrue(b.isFull());
		
		b.get();
		Assertions.assertFalse(b.isFull());
	}
	
	@Test
	void isEmpty() {
		//Comprobamos que devuelve true cuando está vacio, y false cuando no
		Assertions.assertTrue(b.isEmpty());
		
		b.put(3);
		Assertions.assertFalse(b.isEmpty());
	}
}
