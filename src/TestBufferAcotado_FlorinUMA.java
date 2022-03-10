import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBufferAcotado_FlorinUMA {
	private BufferAcotado<Integer> buffer;

	@BeforeEach
	void setUp() throws Exception {
		buffer = new BufferAcotado<Integer>(10);

	}

	@Test
	void pruebaCrearObjeto() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new BufferAcotado<>(-0));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new BufferAcotado<>(-1));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new BufferAcotado<>(-20));

	}

	@Test
	void pruebaPut() {
		// Rellenamos el buffer
		for (int i = 0; i < 10; i++) {
			buffer.put(i);
		}
		Assertions.assertThrows(IllegalStateException.class, () -> buffer.put(0));

	}

	@Test
	void pruebaGet() {
		Assertions.assertThrows(IllegalStateException.class, () -> buffer.get());
		for (int i = 0; i < 10; i++) {
			buffer.put(i);
		}
		Assertions.assertEquals(0, buffer.get());
		Assertions.assertEquals(1, buffer.get());
		Assertions.assertEquals(2, buffer.get());
		Assertions.assertEquals(3, buffer.get());
		Assertions.assertEquals(4, buffer.get());
		Assertions.assertEquals(5, buffer.get());
		Assertions.assertEquals(6, buffer.get());
		Assertions.assertEquals(7, buffer.get());
		Assertions.assertEquals(8, buffer.get());
		Assertions.assertEquals(9, buffer.get());
	}

	@Test
	void pruebaSize() {
		Assertions.assertEquals(0, buffer.size());
		for (int i = 0; i < 10; i++) {
			buffer.put(i);
		}
		Assertions.assertEquals(10, buffer.size());
		buffer.get();
		Assertions.assertEquals(9, buffer.size());
	}

	@Test
	void pruebaIsFull() {
		for (int i = 0; i < 10; i++) {
			buffer.put(i);
		}
		Assertions.assertTrue(buffer.isFull());
	}

	@Test
	void pruebaIsEmpty() {
		Assertions.assertTrue(buffer.isEmpty());
	}
}
