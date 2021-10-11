package com.edubridge.springboot.project.onlineshopping.service;

import java.util.List;

import com.edubridge.springboot.project.onlineshopping.entities.Cart;

public interface CartService {

	public Cart saveCart(Cart cart);
	public List<Cart> getAllCart();
	public Cart getCartByid(int product_id);
	public Cart updateCart(int product_id, Cart cart);
	public void deleteCart(int product_id);
	public void deleteCartByid(int id);
	
}
