package assign03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;
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
	
	/*
	 * Add tests for: containsAll, toArray; 
	 */

	@Test
	public void newListEmpty() {
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}

	@Test
	public void comparatorReverseOrder() {
		SortedArrayList<Integer> reversed = new SortedArrayList<>(Comparator.reverseOrder());
		reversed.insert(2);
		reversed.insert(4);
		reversed.insert(6);
		assertEquals(6, reversed.min());
		assertEquals(2, reversed.max());
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

	@Test
	public void medianOddSize() {
		list.insert(6);
		list.insert(8);
		list.insert(9);

		assertEquals(8, list.median());

	}

	@Test
	public void medianEvenSize() {
		list.insert(6);
		list.insert(3);
		list.insert(8);
		list.insert(9);

		assertEquals(8, list.median());
	}

	@Test
	public void insertKeepsListSorted() {
		list.insert(5);
		list.insert(4);
		list.insert(6);
		list.insert(7);

		assertEquals(7, list.max());
		assertEquals(6, list.median());
		assertEquals(4, list.min());
	}

	@Test
	public void sizeIncreasesWithEachInsert() {
		assertEquals(0, list.size());
		list.insert(3);
		assertEquals(1, list.size());
		list.insert(9);
		assertEquals(2, list.size());
	}

	@Test
	public void containsFindsExistingElement() {
		list.insert(10);
		list.insert(40);
		assertTrue(list.contains(10));
	}

	@Test
	public void containsReturnFalseForNonExistingElement() {
		list.insert(7);
		assertFalse(list.contains(32));
	}

	@Test
	public void containsReturnFalseForEmptyList() {
		assertFalse(list.contains(30));
	}

	@Test
	public void containsReturnFalseForNull() {
		list.insert(5);
		assertFalse(list.contains(null));
	}

	@Test
	public void countEntriesCountsDuplicates() {
		list.insert(7);
		list.insert(7);
		list.insert(2);
		assertEquals(2, list.countEntries(7));
	}
	
	@Test
	public void containsAllSmallCollection() {
		list.insert(3);
		list.insert(1);
		list.insert(2);
		list.insert(5);
		
		List<Integer> coll = List.of(3, 1, 2, 5);
		assertTrue(list.containsAll(coll));
	}
	
	@Test
	public void containsAllLargeCollection() {
		List<Integer> coll = List.of(3, 1, 2, 5, 7, 2, 10, 40, 6, 8, 9, 14);
		list.insertAll(coll);
		assertTrue(list.containsAll(coll));
	}
	
	@Test
	public void containsAllFalse() {
		list.insert(3);
		list.insert(1);
		list.insert(5);
		
		List<Integer> coll = List.of(3, 1, 2, 5);
		assertFalse(list.containsAll(coll));
	}
	
	@Test
	public void insertAllExpandsArray() {
		List<Integer> coll = List.of(3, -1, 2, 5, 7, 2, 10, 0, 6, 8, 9, 14, 67, -56, 43, 23, 92);
		list.insertAll(coll);
		assertEquals(17, list.size());
	}
	
	@Test
	public void insertAllIsSorted() {
		List<Integer> coll = List.of(3, -1, 2, 5, 7, 2, 10, 0, 6, 8, 9, 14, 67, -56, 43, 23, 92);
		list.insertAll(coll);
		assertEquals(-56, list.min());
		assertEquals(7, list.median());
		assertEquals(92, list.max());
	}
	
	@Test
	public void isEmptyTrue() {
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void isEmptyFalse() {
		list.insert(3);
		list.insert(1);
		list.insert(5);
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void clear() {
		List<Integer> coll = List.of(3, -1, 2, 5, 7, 2, 10, 0, 6, 8, 9, 14, 67, -56, 43, 23, 92);
		list.insertAll(coll);
		list.clear();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void toArray() {
		List<Integer> coll = List.of(3, -1, 2, 5, 7, 2, 10, 0, 6, 8, 9, 14, 67, -56, 43, 23, 92);
		list.insertAll(coll);
		Object[] array = list.toArray();
		assertEquals(17, array.length);
	}
}