package com.edubridge.springboot.project.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edubridge.springboot.project.onlineshopping.entities.Cart;
import com.edubridge.springboot.project.onlineshopping.service.CartService;


@Controller
public class CartViewController {

	@Autowired
	CartService cartService;
	
	@RequestMapping("/cart")
	public String viewIndexCartPage(Model model) {
		List<Cart>cartList=cartService.getAllCart();
		model.addAttribute("CartList",cartList);
		return "indexcart";
	}
	@RequestMapping("/new")
	public String viewNewCartPage(Model model) {
		Cart cart = new Cart();
		model.addAttribute("cart",cart);
		return "new_cart";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	//@PostMapping("/save")
	public String saveCart(@ModelAttribute("cart")Cart cart) {
		cartService.saveCart(cart);
		return "redirect:/cart";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCartPage(@PathVariable(name="id")int id) {
		ModelAndView mav=new ModelAndView("edit_cart");
		Cart cart=cartService.getCartByid(id);
		mav.addObject("cart", cart);
		return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteCart(@PathVariable(name="id")int id) {
		cartService.deleteCart(id);
		return "redirect:/cart";
	}	
	
}
