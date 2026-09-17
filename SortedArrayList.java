package assign03;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class SortedArrayList<E extends Comparable<? super E>> implements SortedList<E> {

	private E[] data;
	private int size;

	// Constructors
	@SuppressWarnings("unchecked")
	public SortedArrayList() {
		this.data = (E[]) new Object[50]; // Make a new array with 50 spaces
		this.size = 0;

	}

	@SuppressWarnings("unchecked")
	public SortedArrayList(Comparator<? super E> cmp) {
		this.data = (E[]) new Object[50]; // Check
		this.size = 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void clear() {
		E[] emptyArr = (E[]) new Object[50]; // Check should it be a default val or this.data.length?
		this.data = emptyArr;
	}

	@Override
	public boolean contains(E element) {
		// treat contains as insert at first; check the index that binary search
		// produces of where the object should be inserted
		int objIdx = binarySearch(element);

		// if idx obj equals element, return true
		if (this.data[objIdx].equals(element)) { // CHECK if .equals is valid
			return true;
		}

		// since idx obj =/= element, return false
		return false;
	}

	@Override
	public boolean containsAll(Collection<? extends E> items) { // Check

		for (int i = 0; i < this.data.length; i++) {
			boolean currentElementVal = contains(this.data[i]); // lllCheck if this arr contains the element
			if (!currentElementVal) {
				return false;
			}
		}

		return true;
	}

	@Override
	public int countEntries(E target) {
		int amount = 0;

		for (int i = 0; i < this.data.length; i++) {
			int idx = binarySearch(target); // Find index where of the target is
			if (this.data[i].equals(this.data[idx])) { // CHECK equals
				amount += 1;
			}
		}
		return amount;
	}

	@Override
	public void insert(E element) { // Check
		// First, check if there is enough room to add in the arr (if size == length,
		// double the arr)
		if (this.size == this.data.length) {
			resizeArr();
		}

		// Get the index of where the object should go in the arr using binarysearch
		int idx = binarySearch(element);

		// if the sorted idx is at the beginning or middle, shift every object after idx
		// + 1
		// if(idx != size+1)
		// for each :

		// set the index to the element object
		this.data[idx] = element;

		this.size += 1; // increase size of this list (NOT the backing array)

	}

	/**
	 * 
	 * Inserts the specifieieied elements into this sorted list.
	 * 
	 * @param coll - the collection of elements to insert
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void insertAll(Collection<? extends E> coll) {
		while (coll.size() > this.data.length) { // While there are too many elements to fit into this arr, increase
													// the size
			resizeArr();
		}

		E[] collArray = (E[]) coll.toArray();

		for (int i = 0; i < this.data.length; i++) { // Check change to a foreach or is this fine?
			insert(collArray[i]); // insert the item at this idx
		}
	}

	/**
	 * Determines whether this sorted list contains any elements.
	 * 
	 * @return true if this sorted list contains no elements, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public E max() throws NoSuchElementException {
		// check if arr is empty
		if (this.size == 0) {
			throw new NoSuchElementException("This SortedArrayList is empty, so there can be no maximum value");
		}
		// get the last element in the list (NOT the backing arr) (Check)
		return this.data[size - 1]; // check if idx is right
	}

	@Override
	public E median() throws NoSuchElementException {
		// check if arr is empty
		if (this.size == 0) {
			throw new NoSuchElementException("This SortedArrayList is empty, so there can be no median value");
		}

		// Get the middle object of the list
		int left = 0;
		int right = data.length - 1; // Check should I be calculating the median using the list or the backing arr?

		int mid = left + (right - left) / 2;

		return this.data[mid];
	}

	@Override
	public E min() throws NoSuchElementException {
		// check if arr is empty
		if (this.size == 0) {
			throw new NoSuchElementException("This SortedArrayList is empty, so there can be no minimum value");
		}
		// throw excp
		return this.data[0];
	}

	/**
	 * Gets the number of elements in this sorted list.
	 * 
	 * @return the number of elements in this sorted list
	 */
	@Override
	public int size() {
		return this.size; // Check
	}

	@Override
	@SuppressWarnings("unchecked")
	public Object[] toArray() {
		E[] newArr = (E[]) new Object[this.data.length];

		for (int i = 0; i < this.data.length; i++) {
			newArr[i] = this.data[i];
		}

		// The data of this arr is already sorted so we can just insert everything into
		// the new array and return it (Check)
		return newArr;
	}

	/**
	 * (Instructions): Good program design dictates that you implement the binary
	 * search only once, in a private helper method, and invoke the same helper
	 * method in the contains, countEntries, and insert methods.
	 * 
	 * @return
	 */
	private int binarySearch(E target) { // should tell you where to insert the object
		int left = 0;
		int right = data.length - 1;

		// ((Comparable<? super E>)o1).compareTo(o2);
		while (left <= right) {
			int mid = left + (right - left) / 2;

			int comparison = data[mid].compareTo(target); // Check
			//If the class was passed in with a comparator, determine which kind of comparison we would make

			if (comparison == 0) { // The target was found
				return mid; // index of where the item can be found

			} else if (comparison < 0) { // The mid is lesser than target, look at the right half
				left = mid + 1;
			} else { // The mid is greater than target, look at the left half
				right = mid - 1;
			}
		}

		// if target is already in the array, return idx it's found at
		// if it's not in there, return index where we should insert it
		return idx; // index where it can be inserted
	}

	/**
	 * It is not acceptable for the array to run out of space for new elements, nor
	 * is it acceptable to create a gigantic array. Start with a modestly-size array
	 * and double the capacity as needed.
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private void resizeArr() {
		E[] newData = (E[]) new Object[this.data.length * 2]; // Make a new array that is double the size of the current
																// one

		for (int i = 0; i < newData.length; i++) { // Put back in the original data
			newData[i] = this.data[i];
		}

		this.data = newData;
	}

	// for insert if the sorted idx is at the beginning or middle, shift every
	// object after idx + 1
	private void shiftElements() {

	}
}
