import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBufferAcotado_jesusaldanamartin {

	
	/**
	 * 
	 * @author Jesús Aldana
	 *
	 */
		
		
		private BufferAcotado_jesusaldanamartin<Object> Buffer;
		private int capacidad = 5;
		
		/**
		 * Creamos el Buffer antes de cada prueba
		 */
		@BeforeEach
		void initialize() {
			Buffer = new BufferAcotado_jesusaldanamartin<Object>(capacidad);
		}
		
		@Test
		void TestBufferAcotado() {
			
			assertThrows(IllegalArgumentException.class, ()-> new BufferAcotado_jesusaldanamartin<Integer>(-1));
			assertThrows(IllegalArgumentException.class, ()-> new BufferAcotado_jesusaldanamartin<Integer>(0));
	
		}
		
				
		@Test
		public void TestPut() {
			for(int i = 0;i<capacidad;i++) {
				Buffer.put(i);
			}
			int tam = Buffer.size();
			assertEquals(capacidad, Buffer.size());
			assertEquals(tam+1, Buffer.size()+1);
			assertThrows(IllegalStateException.class, ()-> Buffer.put(2));
	
		}
		
		@Test
		public void TestGet() {
			
			int tam = Buffer.size();
			
			assertEquals(tam-1, Buffer.size()-1);
			assertThrows(IllegalStateException.class, ()-> Buffer.get());
		}
		
				
		@Test
		public void TestIsFull() {
			
			for(int i = 0;i<capacidad;i++) {
				Buffer.put(i);
			}
			assertTrue(Buffer.isFull());
			assertFalse(Buffer.isEmpty());


		}
		
		@Test
		public void TestIsEmpty() {
			Buffer.put(1);
			assertFalse(Buffer.isEmpty());	
			assertFalse(Buffer.isFull());

			}

}


