package homework3;

public class ListIsFullException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ListIsFullException() {
		super("This list is already full!");
	}

}
