package homework3;

import java.util.Vector;

/**
An list whose entries stores in a vector.
@author Liang Dong
@version 1.0
*/
public class VectorList<T> implements ListInterface<T> {
	
	private final Vector<T> list;
    private static final int DEFAULT_CAPACITY = 10;
    private boolean initialized = false;
    private static final int MAX_CAPACITY = 100000;
    
    
    /**
     * Creates an empty list having a given initial capacity.
     *
     * @param desiredCapacity The integer capacity desired.
     */
	public VectorList(int capacity) {
		if(capacity < MAX_CAPACITY) {
			Vector<T> temp = new Vector<>(capacity);
			list = temp;
			initialized = true;
		}
		else {
			throw new IllegalStateException("Attempt to create a list " +
                     "whose capacity exceeds " +
                     "allowed maximum.");
		}
	}
	
    /** Creates an empty list whose initial capacity is 10. */

	public VectorList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Add an entry to the back of the list.
	 * @param newEntry The object to be added.
	 * @return true if succeeded
	 * @throw ListIsFullException if list is full.
	 */
	public boolean addToEnd(T newEntry) {
		checkInitialization();
		if(list.size() <= MAX_CAPACITY) {
			list.add(newEntry);
			return true;
		}
		else {
			throw new ListIsFullException();
		}
	}
	
	/**
	 * Add an entry to the specific location.
	 * @param newEntry The object to be added
	 * @param location index of the location
	 * @return true if succeeded
	 * @throw ListIsFullException if list is full.
	 * @throw GivenLocationOutOfBoundsException is location is greater than (the size of the list + 1).
	 */
	public boolean add(T newEntry, int location) {
		checkInitialization();
		if(list.size() <= MAX_CAPACITY) {
			if(location > list.size() || location < 0) {
				throw new GivenLocationOutOfBoundsException();
			}
			else {
				list.add(location, newEntry);
				return true;
			}
		}
		else {
			throw new ListIsFullException();
		}
	}
	
	/**
	 * remove an entry at the specific location.
	 * @param location index of the location.
	 * @return the removed object
	 * @throw EmptyListException if list is empty
	 * @throw GivenLocationOutOfBoundsException is location is greater than the size of the list
	 */
	public T removeByLocation(int location) {
		checkInitialization();
		if(isEmpty()) {
			throw new EmptyListException();
		}
		
		else {
			if(list.size() <= location || location < 0) {
				throw new GivenLocationOutOfBoundsException();
			}
			else {
				T temp = list.remove(location);
				return temp;
			}
		}

	}
	
	/**
	 * remove an entry that is that same as the given one.
	 * @param newEntry The entry to be removed.
	 * @return true if succeeded
	 * @throw EmptyListException if list is empty
	 */
	public boolean removeByValue(T newEntry) {
		checkInitialization();
		if(isEmpty()) {
			throw new EmptyListException();
		}
		
		else {
			boolean temp = list.remove(newEntry);
			return temp;
		}
	}
	
	/**
	 * remove all entries in the list.
	 * @return true if succeeded
	 */
	public boolean removeALl() {
		checkInitialization();
		list.clear();
		if(list.size() == 0)
			return true;
		else
			return false;
	}


	/**
	 * replace an entry with the given entry.
	 * @param location the location of the entry to be replaced
	 * @param newEntry The entry to be added
	 * @return true if succeeded
	 * @throw EmptyListException if list is empty
	 * @throw GivenLocationOutOfBoundsException is location is greater than the size of the list
	 */
	public boolean replace(int location, T newEntry) {
		checkInitialization();
		if(isEmpty()) {
			throw new EmptyListException();
		}
		else {
			if(list.size() <= location || location < 0) {
				throw new GivenLocationOutOfBoundsException();
			}
			else {
				list.set(location, newEntry);
				return true;
			}
		}
	}
	
	/**
	 * replace an entry with the given entry.
	 * @param oldEntry the object to be replaced.
	 * @param newEntry The entry to be added
	 * @return true if succeeded.
	 * @throw EmptyListException if list is empty.
	 */
	public boolean replace(T oldEntry, T newEntry) {
		checkInitialization();
		if(isEmpty()) {
			throw new EmptyListException();
		}
		else {
			int indexOfOldEntry = list.indexOf(oldEntry);
			if(indexOfOldEntry == -1) {
				return false;
			}
			list.set(indexOfOldEntry, newEntry);
			return true;
		}
	}
	
	
	/**
	 *look at an entry.
	 * @param location the location of the entry
	 * @return the entry at the given location.
	 * @throw EmptyListException if the list is empty.
	 * @throw GivenLocationOutOfBoundsException is location is greater than (the size of the list + 1).
	 */
	public T look(int location) {
		checkInitialization();
		if(isEmpty()) {
			throw new EmptyListException();
		}
		if(list.size() <= location || location < 0) {
			throw new GivenLocationOutOfBoundsException();
		}
		else {
			T temp = list.elementAt(location);
			return temp;
		}
	}

	
	/**
	 * look at all entries.
	 * @return an array of all entries.
	 * @throw EmptyListException if the list is empty.
	 */
	public T[] lookAll() {
		checkInitialization();
		if(isEmpty()) {
			throw new EmptyListException();
		}
		else {
			@SuppressWarnings("unchecked")
			T[] array = (T[]) new Object[list.size()];
			for(int i = 0; i < list.size(); i++) {
				array[i] = list.elementAt(i);
			}
			return array;
		}
	}
	
	/**
	 * check the existence of a given entry.
	 * @param entry The entry to be checked.
	 * @return : true if exists.
	 * @throw EmptyListException if the list is empty.
	 */
	public boolean checkExistence(T entry) {
		checkInitialization();
		if(isEmpty()) {
			throw new EmptyListException();
		}
		return list.contains(entry);
		
	}
	
	/**
	 * check if the list is empty.
	 * @return true if empty.
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * counts the size of the list
	 * @return the size of the list.
	 */
	public int currentSize() {
		return list.size();
	}
	
	/**
	 *  Throws an exception if this object is not initialized.
     */
    private void checkInitialization()
    {
        if (!initialized)
             throw new SecurityException("VectorList object is not initialized " +
                                        "properly.");
   }
}
