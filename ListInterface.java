package homework3;


/**
An interface for the ADT list.
@author Liang Dong
@version 1.0
*/
public interface ListInterface<T> {
	/**
	 * Add an entry to the back of the list.
	 * @param newEntry The object to be added.
	 * @return true if succeeded
	 * @throw ListIsFullException if list is full.
	 */
	public boolean addToEnd(T newEntry);
	
	/**
	 * Add an entry to the specific location.
	 * @param newEntry The object to be added
	 * @param location index of the location
	 * @return true if succeeded
	 * @throw GivenLocationOutOfBoundsException is location is greater than (the size of the list + 1).
	 * @throw ListIsFullException if list is full
	 */
	public boolean add(T newEntry, int location);
	
	/**
	 * remove an entry at the specific location.
	 * @param location index of the location.
	 * @return the removed object
	 * @throw GivenLocationOutOfBoundsException is location is greater than (the size of the list + 1).
	 * @throw EmptyListException if the list is empty.
	 */
	public T removeByLocation(int location);
	
	/**
	 * remove an entry that is that same as the given one.
	 * @param newEntry The entry to be removed.
	 * @return true if succeeded
	 * @throw EmptyListException if list is empty
	 */
	public boolean removeByValue(T newEntry);
	
	/**
	 * remove all entries in the list.
	 * @return true if succeeded
	 */
	public boolean removeALl();


	/**
	 * replace an entry with the given entry.
	 * @param location the location of the entry to be replaced
	 * @param newEntry The entry to be added
	 * @return true if succeeded
	 * @throw EmptyListException if the list is empty.
	 * @throw GivenLocationOutOfBoundsException is location is greater than (the size of the list + 1).
	 */
	public boolean replaceByLocation(int location, T newEntry);
	
	/**
	 * replace an entry with the given entry.
	 * @param oldEntry the object to be replaced.
	 * @param newEntry The entry to be added
	 * @return true if succeeded
	 * @throw EmptyListException if the list is empty.
	 */
	public boolean replaceByValue(T oldEntry, T newEntry);
	
	
	/**
	 *look at an entry.
	 * @param location the location of the entry
	 * @return the entry at the given location.
	 * @throw EmptyListException if the list is empty.
	 * @throw GivenLocationOutOfBoundsException is location is greater than (the size of the list + 1).
	 */
	public T look(int location);

	
	/**
	 * look at all entries.
	 * @return an array of all entries.
	 * @throw EmptyListException if the list is empty.
	 */
	public T[] lookAll();
	
	/**
	 * check the existence of a given entry.
	 * @param entry The entry to be checked.
	 * @return : true if exists.
	 * @throw EmptyListException if the list is empty.
	 */
	public boolean checkExistence(T entry);
	
	/**
	 * counts the size of the list
	 * @return the size of the list.
	 */
	public int currentSize();
	
	/**
	 * check if the list is empty.
	 * @return true if empty.
	 */
	public boolean isEmpty();
}
