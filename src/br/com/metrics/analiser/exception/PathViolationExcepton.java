package br.com.metrics.analiser.exception;

public class PathViolationExcepton extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PathViolationExcepton(String msg){
		super(msg);
	}
	
	public PathViolationExcepton(String msg, Throwable cause){
		super(msg,cause);
	}

}
