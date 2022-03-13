import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBufferAcotado_Archerd6
{
	BufferAcotado<Integer> b;
	
	@BeforeEach
	void Configuracion()
	{
		b = new BufferAcotado<Integer>(2);                         // capacidad = 2
	}
	
	@Test
	/**Test de creacion de Buffers*/
	void Creacion()
	{
		// Preconditions:    - IllegalArgumentException if (!capacidad<=0)
		
		// No cumplen
		assertThrows(IllegalArgumentException.class, () -> new BufferAcotado<Integer>(0));
		assertThrows(IllegalArgumentException.class, () -> new BufferAcotado<Integer>(-1));
		assertThrows(IllegalArgumentException.class, () -> new BufferAcotado<Integer>(-88888888));
		// Si cumplen
		assertDoesNotThrow(() -> new BufferAcotado<Integer>(8));
		assertDoesNotThrow(() -> new BufferAcotado<Integer>(88888888));
	}
	
	@Test
	/**Test de insercion en el Buffer*/
	void Insertar()
	{
		/* Preconditiones:    - IllegalStateException if the buffer is full
		 *                    - The size of the buffer is increased by 1
		 *                    - The new element becomes the last element of the buffer
		 */
		assertDoesNotThrow(() -> b.put(8));                        // Insertamos 1
		assertDoesNotThrow(() -> b.put(8));                        // Insertamos 2
		assertThrows(IllegalStateException.class,()-> b.put(88));
	}
	
	@Test
	/**Test de insercion en el Buffer*/
	void Obtener()
	{
		/* Preconditiones:    - IllegalStateException if the buffer is empty
		 *                    - The size of the buffer is decreased by 1
		 */
		b.put(8);                                                  // Insertamos 1
		assertDoesNotThrow(() -> b.get());                         // Obtenemos  1
		assertEquals(0, b.size());
		assertThrows(IllegalStateException.class,()-> b.get());    // No hay ninguno
		assertEquals(0, b.size());
	}
	
	@Test
	/**Test tamaño del Buffer*/
	void Tamaño()
	{
		assertEquals(0, b.size());                                 // Inicialmente 0
		assertEquals(true, b.isEmpty());                           // BufferAcotado.isEmpty()
		b.put(8);
		assertEquals(1, b.size());                                 // Insertamos 1
		b.put(888);                                                // Insertamos 2
		assertEquals(true, b.isFull());                            // BufferAcotado.isFull()
	}
	

}
