package com.edubridge.springboot.project.onlineshopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.springboot.project.onlineshopping.entities.Cart;
import com.edubridge.springboot.project.onlineshopping.exception.RecordNotFoundException;
import com.edubridge.springboot.project.onlineshopping.repository.CartRepository;
import com.edubridge.springboot.project.onlineshopping.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepo;
	
	@Override
	public Cart saveCart(Cart cart) {
		
		return cartRepo.save(cart);
	}

	@Override
	public List<Cart> getAllCart() {
		return cartRepo.findAll();
	}

	@Override
	public Cart getCartByid(int product_id) {
		return cartRepo.findById(product_id)
				.orElseThrow(() -> new RecordNotFoundException("Cart with "+product_id+" not found"));
	}

	@Override
	public Cart updateCart(int product_id, Cart cart) {
		Cart d1=getCartByid(product_id);
		//d1.setProductId(cart.getProductId());
		d1.setCustomerId(cart.getCustomerId());
		d1.setProductName(cart.getProductName());
		d1.setProductPrice(cart.getProductPrice());
		d1.setQuantity(cart.getQuantity());
		
		/*double amount = 0;
	        for (Cart cart :cart){
	            amount += (cartList.getProductId().getProductPrice()* cartList.getQuantity());
	        }*/
		d1.setAmount(cart.getAmount());
		return cartRepo.save(d1);
		//return cartRepo.findById(product_id).get();
	}

	@Override
	public void deleteCart(int product_id) {
		// TODO Auto-generated method stub
		cartRepo.deleteById(product_id);
				//.orElseThrow(() -> new CartItemsDoesNotExist("Cart with "+product_id+" not found"));
	
	}

	@Override
	public void deleteCartByid(int id) {
		// TODO Auto-generated method stub
		
	}
	/*public CartDto listCartItems(Cart cart) {
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);
        List<CartItem> cartItems = new ArrayList<>();
        for (Cart cart:cartList){
            CartItemDto cartItemDto = getDtoFromCart(cart);
            cartItems.add(cartItemDto);
        }
        double totalCost = 0;
        for (CartItemDto cartItemDto :cartItems){
            totalCost += (cartItemDto.getProduct().getPrice()* cartItemDto.getQuantity());
        }
        CartDto cartDto = new CartDto(cartItems,totalCost);
        return cartDto;
    }*/

	
}
