import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * @author Claudia Vega Rodriguez
 * @version 1.1
 * 
 */
public class TestBufferAcotado_ClaudiaVegaRodriguez {
	
	private BufferAcotado<Integer> buffer = new BufferAcotado<>(10);
	
	@Test
	public void BufferIsFull() {
		for (int i = 1; i<buffer.size(); i++ ) {
			buffer.put(i);
		}
		Assertions.assertEquals(10, buffer.size());
		Assertions.assertEquals(true, buffer.isFull());
		Assertions.assertNotEquals(4, buffer.size());
	}
	
	@Test 
	public void BufferIsEmpty() {
		for (int i = 1; i < buffer.size(); i++) {
			buffer.put(i);
		}
		assertEquals(0, buffer.size());
		assertEquals(true, buffer.isEmpty());
	}

}
