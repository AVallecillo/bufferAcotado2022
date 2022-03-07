import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * JUnit tests for class Buffer
 * @author Antonio Vallecillo
 * @version 1.1
 *
 */
public class TestBufferAcotado {
	
	private final int CAPACIDAD = 10;

	private BufferAcotado<Object> b = new BufferAcotado<Object>(CAPACIDAD);
	
	@BeforeEach
	void initBuffer() {
		b = new BufferAcotado<Object>(CAPACIDAD);
	}
	
	@AfterEach 
	void deleteBuffer() {
		b=null;
	}
	
	@Test
	void basicQueries() {
		assertTrue(b.isEmpty());
		assertFalse(b.isFull());
		Object e1 = new Object();
		b.put(e1);
		assertFalse(b.isEmpty());
		if (CAPACIDAD>1) assertFalse(b.isFull()); else assertTrue(b.isFull());
		Object e = b.get();
		assertEquals(e1,e);
		assertTrue(b.isEmpty());
		assertFalse(b.isFull());
	}
	
	@Test
	void CreationError() {
    	assertThrows(IllegalArgumentException.class, ()->{new BufferAcotado<String>(0);});
    	assertThrows(IllegalArgumentException.class, ()->{new BufferAcotado<String>(-1);}); 	
	}
	
	@Test
	public void PruebaPutIncrementSize(){
		int size = b.size();
		b.put(new Object());
		assertEquals(size+1, b.size());
	}
	
	@Test
	public void testPutFullExcepcion(){
		BufferAcotado<Object> q = new BufferAcotado<Object>(1);
		q.put(new Object());
		assertThrows(IllegalStateException.class,()->{q.put(new Object());});	
	}


	//Dequeue
	@Test
	public void testGetDecreasesSize(){
		BufferAcotado<Object> q = new BufferAcotado<Object>(2);
		q.put(new Object());
		int size = q.size();
		q.get();
		assertSame(size-1, q.size());
	}

	@Test
	public void testGetEmpty(){
		BufferAcotado<Object> q = new BufferAcotado<Object>(1);
		assertThrows(IllegalStateException.class,()->{q.get();});	
	}

	@Test
	public void testPutFull(){
		BufferAcotado<Object> q = new BufferAcotado<Object>(1);
		assertTrue(q.isEmpty());
		assertFalse(q.isFull());
		q.put(new Object());
		assertTrue(q.isFull());
		assertFalse(q.isEmpty());
		q.get();
		assertTrue(q.isEmpty());
		assertFalse(q.isFull());
	}

	
	
	//FIFO
	@Test
	public void testSimpleInsertion(){
		b = new BufferAcotado<Object>(2);
		Object objeto = new Object();
		b.put(objeto);
		assertSame(b.get(), objeto);
		assertTrue(b.isEmpty());
	}
	
	@Test
	public void testSimpleOrderedInsertion(){
		b = new BufferAcotado<Object>(3);
	    Object a1 = new Object();
	    Object a2 = new Object();
	    Object a3 = new Object();
	    b.put(a1);
	    b.put(a2);
	    b.put(a3);
	    assertSame(a1,b.get());
	    assertSame(a2,b.get());
	    assertSame(a3,b.get());
	}
	
	@Test
	public void testOrderedInsertion(){
	    Object a1 = new Object();
	    Object a2 = new Object();
	    Object a3 = new Object();
	    b.put(a1);
	    b.put(a2);
	    b.put(a3);
	    assertSame(a1,b.get());
	    assertSame(a2,b.get());
	    assertSame(a3,b.get());
	    b.put(a1);
	    b.put(a2);
	    b.put(a3);
	    assertSame(a1,b.get());
	    assertSame(a2,b.get());
	    assertSame(a3,b.get());
	}
	

}
