package assign03;

import java.util.Comparator;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * A generic sorted list backed by an array from smallest to largest.
 * 
 * @author VANY NGUYEN and BROOKE GRIFFIN
 * @version 09-17-2026
 */

public class SortedArrayList<E> implements SortedList<E> {
	private E[] array;
	private int size;
	private Comparator<? super E> comparator;

	/**
	 * Constructs an empty sorted list using natural ordering
	 */
	@SuppressWarnings("unchecked")
	public SortedArrayList() {
		array = (E[]) new Object[10];
		size = 0;
		comparator = null;
	}

	/**
	 * Constructs an empty sorted list using the specified comparator
	 * 
	 * @param comparator - the comparator defining element order
	 */
	@SuppressWarnings("unchecked")
	public SortedArrayList(Comparator<? super E> comparator) {
		array = (E[]) new Object[10];
		size = 0;
		this.comparator = comparator;
	}

	/**
	 * Compares two elements using the comparator or natural ordering
	 * 
	 * @param o1 - first element to be compared
	 * @param o2 - second element to be compared
	 * @return a negative integer if o1 is less than o2, a positive integer if o1 is
	 *         greater than o2, or 0 if o1 is equal to o2
	 */
	@SuppressWarnings("unchecked")
	private int compare(E o1, E o2) {
		if (comparator != null) {
			return comparator.compare(o1, o2);
		} else {
			return ((Comparable<? super E>) o1).compareTo(o2);
		}
	}

	/**
	 * Finds the position of the specified target in this sorted list via iterative
	 * binary search.
	 * 
	 * @param target - element to be searched for
	 * @return the index of the first element in the array that is greater than or
	 *         equal to target, or return size if no such element exists
	 */
	@SuppressWarnings("unchecked")
	private int binarySearch(E target) {
		int low = 0;
		int high = size;

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (compare(array[mid], target) < 0) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	/**
	 * Doubles the capacity of the backing array when full.
	 */
	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		if (size == array.length) {
			E[] newArray = (E[]) new Object[array.length * 2];

			for (int i = 0; i < size; i++) {
				newArray[i] = array[i];
			}

		}
	}

	/**
	 * Removes all of the elements from this sorted list.
	 */
	@Override
	public void clear() {
		size = 0;
	}

	/**
	 * Determines whether the specified element exists in this sorted list.
	 * 
	 * @param element - the element whose existence is being checked
	 * @return true if the element exists in this sorted list, false otherwise
	 */
	@Override
	public boolean contains(E element) {
		if (element == null) {
			return false;
		}

		int index = binarySearch(element);

		if (index < size && compare(array[index], element) == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Determines whether all of the specified elements exist in this sorted list.
	 * 
	 * @param coll - the collection of elements to be checked for containment in
	 *             this sorted list
	 * @return true if this sorted list contains every element in the specified
	 *         collection; otherwise, returns false
	 */
	public boolean containsAll(Collection<? extends E> items) {
		for (E e : items) {
			if (!contains(e)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Determines the number of elements in this sorted list that are equal to the
	 * specified target.
	 * 
	 * @param target - the target whose existence is being counted
	 * @return the number of elements in this sorted list that are equal to the
	 *         specified target
	 */
	int countEntries(E target);

	/**
	 * Inserts the specified element into this sorted list.
	 * 
	 * @param element - the element to insert
	 */
	void insert(E element);

	/**
	 * Inserts the specified elements into this sorted list.
	 * 
	 * @param coll - the collection of elements to insert
	 */
	public void insertAll(Collection<? extends E> coll);

	/**
	 * Determines whether this sorted list contains any elements.
	 * 
	 * @return true if this sorted list contains no elements, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Gets the largest element in this sorted list.
	 * 
	 * @return the largest element in this sorted list
	 * @throws NoSuchElementException if this sorted list is empty
	 */
	E max() throws NoSuchElementException;

	/**
	 * Gets the median element in this sorted list. If this sorted list contains an
	 * even number of elements, gets the larger of two middle elements.
	 * 
	 * @return the median element in this sorted list
	 * @throws NoSuchElementException if this sorted list is empty
	 */
	E median() throws NoSuchElementException;

	/**
	 * Gets the smallest element in this sorted list.
	 * 
	 * @return the smallest element in this sorted list
	 * @throws NoSuchElementException if this sorted list is empty
	 */
	E min() throws NoSuchElementException;

	/**
	 * Gets the number of elements in this sorted list.
	 * 
	 * @return the number of elements in this sorted list
	 */
	int size();

	/**
	 * Generates an array containing all of elements in this sorted list, in order.
	 * 
	 * @return an array containing all of elements in this sorted list
	 */
	Object[] toArray();

}
