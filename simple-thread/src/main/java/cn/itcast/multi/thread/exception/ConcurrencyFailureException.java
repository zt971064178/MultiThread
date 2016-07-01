package cn.itcast.multi.thread.exception;

public class ConcurrencyFailureException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ConcurrencyFailureException() {
		super() ;
	}
	
	public ConcurrencyFailureException(String message) {
		super(message) ;
	}

	public ConcurrencyFailureException(String message, InterruptedException e) {
		super(message, e) ;
	}

}
