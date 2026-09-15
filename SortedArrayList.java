package assign03;

import java.util.Comparator;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * 
 * @author VANY NGUYEN and BROOKE GRIFFIN
 * @version 09-17-2026
 */

public class SortedArrayList<E> implements SortedList<E> {
	private E[] array;
	private int size;
	private Comparator<? super E> comparator;
}