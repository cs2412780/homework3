package homework3;

public class GivenLocationOutOfBoundsException extends ArrayIndexOutOfBoundsException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public GivenLocationOutOfBoundsException() {
		super("Given location is out of list.");
	}
}
