
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBufferAcotado_pablomolinasanchez {

	private BufferAcotado<Integer> buffer;

	@BeforeEach
	void start() throws Exception {
		buffer = new BufferAcotado<Integer>(8);

	}

	@Test
	void testCreaBuffer() {
		 /* @throws IllegalArgumentException if (!capacidad<=0) // precondition*/
		assertThrows(IllegalArgumentException.class, () -> new BufferAcotado<Integer>(0));
		assertThrows(IllegalArgumentException.class, () -> new BufferAcotado<Integer>(-2));
	}
	
	@Test
	void testPut() {

		 /* @post   the size of the buffer is increased by 1*/
		int initialSize = buffer.size();
		buffer.put(7);
		assertEquals(initialSize+1, buffer.size());
		
		/* @throws IllegalStateException if the buffer is full. */
		while(!buffer.isFull()) {
			buffer.put(3);
		}
		assertThrows(IllegalStateException.class, () -> buffer.put(3));
	}
	
	@Test
	void testGet() {
		 /* @throws IllegalStateException if the buffer is empty -- precondition*/
		assertThrows(IllegalStateException.class, () -> buffer.get());
		
		 /* @post   the size of the buffer is decreased by 1*/
		buffer.put(7);
		int initialSize = buffer.size();
		buffer.get();
		assertEquals(initialSize-1, buffer.size());
	}
	
	@Test
	void testSize() {
		/* @return :int -- elements.size()*/
		int contador=0;
		while(contador<=3) {
			buffer.put(contador);
			contador++;
		}
		assertEquals(contador,buffer.size());
	}
	@Test 
	public void testFull() {
		/* @return :boolean -- elements.size()==capacidad*/
		for(int n=0; n<8; n++) {
			buffer.put(n);
		}
		assertTrue(buffer.isFull());
	}

	@Test
	public void testEmpty() {
		/* @return :boolean -- elements.size()==0*/
		assertTrue(buffer.isEmpty());
	}

}
