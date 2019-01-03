package dut.myshop.exception;

public class ProductNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
		super();
		
	}

	public ProductNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public ProductNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public ProductNotFoundException(String arg0) {
		super(arg0);
		
	}

	public ProductNotFoundException(Throwable arg0) {
		super(arg0);
		
	}
	
}
