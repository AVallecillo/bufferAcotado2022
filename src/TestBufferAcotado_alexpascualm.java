import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


public class TestBufferAcotado_alexpascualm {
	private BufferAcotado<Integer> cola;
	@BeforeEach
	    public void inicio() {
	    	cola=new BufferAcotado(3);
	    	
	    }
	@Test
	public void putlleno(){
		for (int i = 0; i < 2; i++) {
			cola.put(i);
		}
		assertThrows(IllegalStateException.class, () -> cola.put(0));
	}
	@Test
	public void getvacio() {
		assertThrows(IllegalStateException.class, () -> cola.get());
	}
	@Test
	public void Testget(){
		cola.put(8);
		assert(cola.get()==8);
		cola.put(9);
		assert(cola.get()==9);
		
	}
	
	@Test
	public void Testconstructor() {
		assertThrows(IllegalArgumentException.class, ()->new BufferAcotado(0));
		assertThrows(IllegalArgumentException.class, ()->new BufferAcotado(-5));
	}
	@Test
	public void Testempty() {
		assert(cola.isEmpty());
	}
	

}
