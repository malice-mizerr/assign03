package assign03;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class SortedArrayList<E extends Comparable<? super E>> implements SortedList<E> {

	private E[] data;

	// Constructors
	@SuppressWarnings("unchecked")
	public SortedArrayList() {
		this.data = (E[]) new Object[10]; // Make a new array with 10 spaces

	}

	@SuppressWarnings("unchecked")
	public SortedArrayList(Comparator<? super E> cmp) {
		this.data = (E[]) new Object[10];
	}

	@Override
	@SuppressWarnings("unchecked")
	public void clear() {
		E[] emptyArr = (E[]) new Object[this.data.length];
		this.data = emptyArr;
	}

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		if (binarySearch(element)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<? extends E> items) {
		for(int i = 0; i < this.data.length; i ++) {
			
		}
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int countEntries(E target) {
		// TODO Auto-generated method stub
		int amount = 0;
		if (binarySearch(target)) {
			amount++;
		}
		return amount;
	}

	@Override
	public void insert(E element) {
		// TODO Auto-generated method stub
		int originalIdx = this.data.length;
		if (this.data[this.data.length - 1].equals(null)) { // If the last element in this arr is empty, put the new
															// item there
			this.data[this.data.length - 1] = element;
		} else { // If it was already occupied, increase this arr size and put the new element at
					// the end
			resizeArr();
			this.data[originalIdx] = element;
		}

	}

	/**
	 * Inserts the specified elements into this sorted list.
	 * 
	 * @param coll - the collection of elements to insert
	 */
	@Override
	public void insertAll(Collection<? extends E> coll) {
		while (coll.size() > this.data.length) { // While there are too many elements to fit into this arr, increase the// size
			resizeArr();
		}
		
		E[] collArray = (E[]) coll.toArray();

		for (int i = 0; i < this.data.length; i++) {
			this.data[i] = collArray[i];
		}

		/*
		 * We need to sort the objects after inserting them
		 */
		
//		(this.data[i], this.data[i+1]) -> 
//		{ if( this.data[i].compareTo(this.data[i+1]) ) {
//			return -1; }
//		if(a.getMass() > b.getMass()) {
//			return 1;
//		}
//		return 0; }
	}

	/**
	 * Determines whether this sorted list contains any elements.
	 * 
	 * @return true if this sorted list contains no elements, false otherwise
	 */
	@Override
	public boolean isEmpty() {

		if (this.data.length == 0) {
			return true;
		}
		return false;
	}

	@Override
	public E max() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E median() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E min() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the number of elements in this sorted list.
	 * 
	 * @return the number of elements in this sorted list
	 */
	@Override
	public int size() {
		return this.data.length;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method 
		E[] newArr = (E[]) new Object[this.data.length];
		
		for(int i = 0; i < this.data.length; i++) {
			newArr[i] = this.data[i];
		}
		
		/*
		 * Sort newArr
		 */
		return newArr;
	}

	/**
	 * (Instructions): Good program design dictates that you implement the binary
	 * search only once, in a private helper method, and invoke the same helper
	 * method in the contains, countEntries, and insert methods.
	 * 
	 * @return
	 */
	private boolean binarySearch(E target) {
		int left = 0;
		int right = data.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			int comparison = data[mid].compareTo(target);

			if (comparison == 0) { // The target was found
				return true;
				// for countEntries, amount++;
				// for contains, return true;
			} else if (comparison < 0) { // The mid is lesser than target, look at the right half
				left = mid + 1;
			} else { // The mid is greater than target, look at the left half
				right = mid - 1;
			}
		}

		return false;
		// return false or -1;

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

	private void sortElements() {

	}

	/*
	 * private void loopFramework(){
	 * 
	 * for(int i = 0; i < array.length; i++){ // }
	 */

	/*
	 * if (cmp != null){ use comparator} else { treat as comparable do this in a
	 * helper
	 * 
	 * 
	 * Lambda Expression (a, b) -> { if( a.getMass() < b.getMass()) return -1; if(
	 * a.getMass() > b.getMass()) return 1; return 0;
	 * 
	 * 
	 */
}
