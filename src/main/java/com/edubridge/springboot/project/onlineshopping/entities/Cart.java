package com.edubridge.springboot.project.onlineshopping.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prodt_id")
	private Integer productId;
	
	@Column(name="cust_id")
	private Integer customerId;
	
	@Column(name="prodt_name")
	private String productName;
	
	@Column(name="prodt_price")
	private Integer productPrice;
	
	@Column(name="prodt_quantity")
	private Integer quantity;
	
	@Column(name="prodt_amount")
	private Integer amount;

	public Cart() {}

public Integer getCustomerId() {
	return customerId;
}
public void setCustomerId(Integer customerId) {
	this.customerId = customerId;
}
public Integer getProductId() {
	return productId;
}
public void setProductId(Integer productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public Integer getProductPrice() {
	return productPrice;
}
public void setProductPrice(Integer productPrice) {
	this.productPrice = productPrice;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public Integer getAmount() {
	return amount;
}
public void setAmount(Integer amount) {
	this.amount = amount;
}

@Override
public int hashCode() {
	return Objects.hash(amount, customerId, productId, productName, productPrice, quantity);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cart other = (Cart) obj;
	return Objects.equals(amount, other.amount) && Objects.equals(customerId, other.customerId)
			&& Objects.equals(productId, other.productId) && Objects.equals(productName, other.productName)
			&& Objects.equals(productPrice, other.productPrice) && Objects.equals(quantity, other.quantity);
}

@Override
public String toString() {
	return "Cart [customerId=" + customerId + ", productId=" + productId + ", productName=" + productName
			+ ", productPrice=" + productPrice + ", quantity=" + quantity + ", amount=" + amount + "]";
}



}