import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * MyArrayList class written below establishes a initial capacity and growth factor different from 
 * what Java typically does.  Iterator class and associated methods defined in this java file as well
 * 
 * Lab03 written outside of class in order to catch up and establish a foundation for future labs
 * 
 * RESOURCES USED: chatGPT, stack Overflow, GeeksForGeeks
 * 
 * @author maxrogers 
 * @param <T> generic type, allows the use of various types including Fractions
 */

public class myArrayList<F> {
	private int size;
    private Fraction[] elements;
	private static final int INITIAL_CAPACITY = 50;
    private static final double GROWTH_FACTOR = 0.2;
		
	public myArrayList() {
		elements = new Fraction[INITIAL_CAPACITY];
		size = 0;
	}
	
	/**
	 * getter for integer size
	 * @return size of myArrayList
	 */
	public int getSize() {
        return size;
    }
		
	/**
	 * method that adds an element to the end of myArrayList
	 * @param element to be added
	 * @return boolean to indicate successful execution
	 * @author maxrogers
	 */
	public boolean add(Fraction element) {
        if (size == elements.length) {
            grow();
        }
        elements[size] = element;
        size++;
        return true;
    }
	
	/**
	 * Increases the size of the ArrayList by set growth factor when necessary
	 * @author maxrogers
	 */
	private void grow() {
		int newCapacity = (int) (elements.length * (1 + GROWTH_FACTOR));
        elements = Arrays.copyOf(elements, newCapacity);		
	}
	
	/**
	 * get method to examine objects at particular indices 
	 * @param index the index that indicates which object to return
	 * @return the object at index index
	 * @author maxrogers
	 */

	public Fraction get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return elements[index];
    }
	
	/**
	 * method to test if myArrayList contains a specific element 
	 * @param element object to check for
	 * @return true if found, false if not
	 * @author maxrogers
	 */
	public boolean contains(Fraction element) {
		for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
	
	/**
	 * removes a particular object from myArrayList
	 * @param element object to be removed
	 * @return true if successful, false if not 
	 * @author maxrogers
	 */
	public boolean remove(Fraction element) {
        int index = indexOf(element);
        if (index != -1) {
            removeAtIndex(index);
            return true;
        }
        return false;
    }
	
	/**
	 * Finds the index of a particular object
	 * @param element object to be located
	 * @return index of specified object, or -1 if not found
	 * @author maxrogers
	 */
	private int indexOf(Fraction element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
	
	/**
	 * removes the object at a specified index
	 * protected classification so that it can only be implemented by the iterator
	 * @param index location of the object to be removed
	 * @author maxrogers
	 */
	protected void removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }
	
	/**
	 * adds an object to a specified index
	 * protected classification so that it can only be implemented by the iterator
	 * @param index
	 * @param element
	 * @author maxrogers
	 */
	protected void addAtIndex(int index, Fraction element) {
		if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if (size == elements.length) {
            grow();
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }
	
	
/*-------------------------------------      
    LAB02 CODE
    Iterator
-------------------------------------*/  
	

	public Iterator<Object> myArrayListIterator() {
		return new myArrayListIterator();
	}
	
	public class myArrayListIterator implements Iterator<Object> {
		private int currentIndex;

	public myArrayListIterator() {
		this.currentIndex = 0;
	}

	/**
	 * method to check if there is an element that can be called by Next
	 * @return true if myArrayList has next element, false if not 
	 * @author maxrogers
	 */
	public boolean hasNext() {
		return currentIndex < size;
	}

	/**
	 * Checks the ArrayList to see if there is an element that can be called by previous
	 * @return true if myArrayList has previous element, false if not
	 * @author Madalyn Amero
	 */
	public boolean hasPrevious() {
		return currentIndex > 0 && get(currentIndex-1) != null;
	}
	
	/**
	 * Utilizes the hasNext() method to determine the index of the next element
	 * @throws an exception if there is no next element in the ArrayList
	 * @return the index of the next element in the ArrayList
	 * @author Madalyn Amero
	 */
	public int nextIndex() {
		if (!hasNext()) {
			throw new NoSuchElementException("No next element");
		}
		return currentIndex+1;
	}

	/**
	 * method that returns the next object relative to the iterator, 
	 * and moves the iterator forward 
	 * @return object the iterator is pointing to next
	 * @author maxrogers
	 */
	public Fraction next() {
		if (!hasNext())
			throw new NoSuchElementException("No next element");
		Fraction element = get(currentIndex);
		currentIndex++;
		return element;
		}

	/**
	 * Checks the previous element and moves the iterator backward
	 * @throws an exception if there is no previous element in the ArrayList
	 * @return previous the previous Fraction element behind the iterator
	 * @author Madalyn Amero
	 */
	public Fraction previous() {
		if (!hasPrevious()) {
			throw new NoSuchElementException("No previous element");
		}
		Fraction previous = get(currentIndex-1);
		currentIndex--;
		return previous;
	}

	/**
	 * Checks the index of the previous item behind the item the iterator
	 * points to
	 * @throws an exception if there is no previous element in the ArrayList
	 * @return the index of the previous element in the ArrayList
	 * @author Madalyn Amero
	 */
	 public int previousIndex() {
		if (!hasPrevious()) {
			throw new NoSuchElementException("No previous element");
		}
    	return (currentIndex-1);
    }

	/**
	 * removes object at current index and moves the location of the iterator appropriately
	 * @author maxrogers
	 */
	public void remove() {
		if (currentIndex <= 0) {
            throw new IllegalStateException("No element to remove");
        }
        removeAtIndex(currentIndex - 1);
        currentIndex--;
    }
	
	/**
	 * adds an element an relation to the iterators location
	 * @param element to be added to myArrayList
	 * @author maxrogers
	 */
	public void add(Fraction element) {
        myArrayList.this.addAtIndex(currentIndex, element);
        currentIndex++;
    }

	/**
	 * adds object at a specified index of myArrayList
	 * @param index desired location of new object
	 * @param f object to be added to myArrayList
	 * @author maxrogers
	 */
	public void set(int index, Fraction f) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        elements[index] = f;
    }	
	}

	
}


	   	
