package com.qaracter.exceptions;

public class ItemInUseException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3636183793526248647L;

	public ItemInUseException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
	
	public ItemInUseException(String errorMessage) {
        super(errorMessage);
    }


}
