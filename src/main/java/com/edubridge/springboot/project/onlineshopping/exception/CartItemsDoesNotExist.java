package com.edubridge.springboot.project.onlineshopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CartItemsDoesNotExist extends RuntimeException{

	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1L;
	
	public CardItemsDoesNotExist(String exception) {
		super(exception);
	}*/
}


