package com.edubridge.springboot.project.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.springboot.project.onlineshopping.entities.Cart;
import com.edubridge.springboot.project.onlineshopping.exception.InvalidInputException;
import com.edubridge.springboot.project.onlineshopping.service.CartService;

@RestController
public class CartController {

	@Autowired
	CartService cartService;
	
	@PostMapping("/cart/save")
	public Cart saveCart(@RequestBody Cart cart) {
		return cartService.saveCart(cart);
	}
	@GetMapping("/cart/carts")
	public List<Cart>getAllCart(){
		return cartService.getAllCart();
	}

	@GetMapping("/cart/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable int id) {
		//return cartService.getCartByid(id);
		/*try {
			Cart cart=cartService.getCartByid(id);
			return new ResponseEntity<Cart>(cart,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
		}*/
		if(id<=0) {
			throw new InvalidInputException(id+" is not a valid Product ID");
		}
		Cart cart = cartService.getCartByid(id);
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}

	@DeleteMapping("/cart/{id}")
	public String deleteCart(@PathVariable int id) {
		/*if(id >= 50) {
			throw new CartItemsDoesNotExist(id+ "  cart items not found" );
		}
		if(id <= 0) {
			throw new CartItemsDoesNotExist(id+ "  it is not a valid  product Id" );
		}*/
		cartService.deleteCart(id);
		return "Deleted Successfully";
	}
	
	@PutMapping("/cart/{id}")
	public ResponseEntity<Cart>updateCart(@PathVariable (value="id")int productId,@RequestBody Cart cart){
		if(productId<=0) {
			throw new InvalidInputException(productId+"is not a valid Product Id");
		}
		Cart updatedCart=cartService.updateCart(productId,cart);
		return ResponseEntity.ok(updatedCart);
	}
}