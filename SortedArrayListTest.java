package assign03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * For testing the SortedArrayList class.
 * 
 * @author VANY NGUYEN and BROOKE GRIFFIN
 * @version 09-17-2026
 */
public class SortedArrayListTest {
	private SortedArrayList<Integer> list;
	
	@BeforeEach
	void setUp() {
		list = new SortedArrayList<>();
	}
	
	/*
	 * Tests
	 */
	@Test
	public void newListEmpty() {
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}
	
	@Test
	public void minThrowsWhenEmpty() {
		assertThrows(NoSuchElementException.class, () -> list.min());
	}
	
	@Test
	public void maxThrowsWhenEmpty() {
		assertThrows(NoSuchElementException.class, () -> list.max());
	}
	
	@Test
	public void medianThrowsWhenEmpty() {
		assertThrows(NoSuchElementException.class, () -> list.median());
	}
}
