package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class is the class to deal with member each in the object that array without knowing structure of the array. 
 * And It can skips null elements in the array.
 * @author Pimwalun Witchawanitchanun
 * @param <T> is a type parameter, which is a placeholder for the name of a class or Interface.
 */
public class ArrayIterator<T> implements Iterator<T> {
	/** attribute for the array we want to iterate over */
	private T[] array;
	private int cursor;
	private boolean test;

	/**
	 * Initialize a new array iterator with the array to process.
	 * @param array is the array to iterate over
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
		this.cursor = cursor;
		this.test = false;
	}

	/**
	 * Returns true if next() can return another non-null array element, false if no more elements.
	 * @return true if next() can return another non-null array element, false if no more elements.
	 */
	@Override
	public boolean hasNext() {
		for (int i = cursor; i < array.length; i++) {
			if (array[i] != null) {
				cursor = i;
				return true;
			}
		}
		return false;
	}

	/**
	 * Return the next non-null element from array, if any.
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException if there are no more elements to return.
	 */
	@Override
	public T next() {
		if (hasNext()) {
			T next = array[cursor];
			cursor++;
			test = true;
			return next;
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Remove most recent element returned by next() from the array by setting it to null. This method may only be called once after a call to next(). 
	 * If this method is called without calling next(). or called more than once after calling next(), it throws IllegalStateException.
	 * @throws NoSuchElementException if there are no more elements to return.
	 */
	@Override
	public void remove() {
		if (test) {
			array[cursor - 1] = null;
			test = false;
		} else {
			throw new IllegalStateException();
		}
	}
}
