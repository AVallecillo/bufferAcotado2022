import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestBufferAcotado_smv762e {
	
	private BufferAcotado<Integer> ba = new BufferAcotado<>(5);
	
	@Test
	public void bufferIsFull() {
		for (int n = 1; n < 6; n++ ) {
			ba.put(n);
		}
		assertEquals(5, ba.size());
		assertEquals(true, ba.isFull());
	}
	
	@Test
	public void bufferTest() {
		for (int n = 1; n < 6; n++ ) {
			ba.put(n);
		}
		System.out.println(ba.get()); // println utilizado para ver los valores obtenidos
		System.out.println(ba.get());
		assertEquals(3, ba.size());
		assertEquals(false, ba.isEmpty());
		assertEquals(false, ba.isFull());
	}
	
	@Test
	public void bufferIsEmpty() {
		for (int n = 1; n < 6; n++ ) {
			ba.put(n);
		}
		System.out.println(ba.get());
		System.out.println(ba.get());
		System.out.println(ba.get());
		System.out.println(ba.get());
		System.out.println(ba.get());
		assertEquals(0, ba.size());
		assertEquals(true, ba.isEmpty());
	}
	
	@Test
	public void bufferWrongCapacity() {
		assertThrows(IllegalArgumentException.class, () -> new BufferAcotado<>(0));
		assertThrows(IllegalArgumentException.class, () -> new BufferAcotado<>(-5));
	}
	
	@Test
	public void bufferGetEmptyAddFull() {
		assertThrows(IllegalStateException.class, () -> ba.get());
		for (int n = 1; n < 6; n++ ) {
			ba.put(n);
		}
		assertThrows(IllegalStateException.class, () -> ba.put(6));
	}
}
