import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * @author Juan Carlos Ruiz Ruiz
 */
class TestBufferAcotado_JuanCarlosRuizRuiz {
	BufferAcotado<Integer> b;
	
	@BeforeEach
	void setUp() throws Exception {
		b = new BufferAcotado<Integer>(3);
	}
	/*
	 * Comprobamos si se cumple la
	 * precondition del constructor
	 */
	@Test
	void preConditionTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new BufferAcotado<Integer>(-1));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new BufferAcotado<Integer>(0));

	}

	@Test
	void putTest() {
		for(int n = 0; n < 3; n++) {
			b.put(n);
		}
		
		Assertions.assertEquals(3, b.size());
		Assertions.assertThrows(IllegalStateException.class, () -> b.put(4));
		
	}
	
	@Test
	void getExceptionTest() {
		Assertions.assertThrows(IllegalStateException.class, () -> b.get());
	}
	
	@Test
	void getTest() {
		b.put(1);
		Assertions.assertEquals(1, b.size());
		b.get();
		Assertions.assertEquals(0, b.size());
	}
	
	@Test
	void isFullTest() {
		for (int n = 1; n <= 3; n++ ) {
			b.put(n);
		}
		Assertions.assertEquals(3, b.size());
		Assertions.assertTrue(b.isFull());
	}
	
	@Test
	void isEmptyTest() {
		for (int n = 1; n < 3; n++ ) {
			b.put(n);
		}
		Assertions.assertFalse(b.isEmpty());
	}

}
