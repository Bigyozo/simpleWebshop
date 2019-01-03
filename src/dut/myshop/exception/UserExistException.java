package dut.myshop.exception;

public class UserExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserExistException() {
		super();
		
	}

	public UserExistException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public UserExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public UserExistException(String arg0) {
		super(arg0);
		
	}

	public UserExistException(Throwable arg0) {
		super(arg0);
		
	}
	
}
