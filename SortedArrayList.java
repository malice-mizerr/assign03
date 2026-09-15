package assign03;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class SortedArrayList<E> implements SortedList<E> {

	private E[] data;

	// Constructors
	@SuppressWarnings("unchecked")
	public SortedArrayList() {
		this.data = (E[]) new Object[10]; // Make a new array with 10 spaces
	}

	public SortedArrayList(Comparator<? super E> cmp) {

	}

	@Override
	public void clear() {
		E[] emptyArr = new E[this.data.length];
		this.data = emptyArr;
	}

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public boolean containsAll(Collection<? extends E> items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int countEntries(E target) {
		// TODO Auto-generated method stub
		int amount = 0;
		for (int i = 0; i < data.length; i++) {
			E currentElement = data[i];
			if (currentElement.equals(target)) {
				amount++;
			}
		}
		return amount;
	}

	@Override
	public void insert(E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertAll(Collection<? extends E> coll) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		
		if(this.data.length == 0) {
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

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * (Instructions): Good program design dictates that you implement the binary
	 * search only once, in a private helper method, and invoke the same helper
	 * method in the contains, countEntries, and insert methods.
	 * 
	 * @return
	 */
	private int binarySearch(E target) {
		int left = 0;
		int right = data.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (data[mid].equals(target)) {
				// for countEntries, amount++;
				// for contains, return true;
			}

			if (data[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		// return false or -1;

	}

	/**
	 * It is not acceptable for the array to run out of space for new
	 * elements, nor is it acceptable to create a gigantic array. Start with a
	 * modestly-size array and double the capacity as needed.
	 * 
	 * @return
	 */
	private E[] resizeArr() {
		E[] newData = new E[data.length * 2]; //Make a new array that is double the size of the current one
		
		for(int i = 0; i < newData.length; i++){ //Put back in the original data
			newData[i] = this.data[i]; 
		}
		
		this.data = newData;
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
