package com.project.icedoutcopy.models;

import com.project.icedoutcopy.models.BaseEntity;
import com.project.icedoutcopy.models.Cart;
import com.project.icedoutcopy.models.Product;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cart_items")
public class CartItem extends BaseEntity {

    private Cart cart;
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id", nullable = false)
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        updateTotalPrice();
    }

    @Column(nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updateTotalPrice();
    }

    @Column(nullable = false)
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    // Helper method to update total price based on quantity and product price
    private void updateTotalPrice() {
        if (product != null) {
            this.totalPrice = product.getPrice().multiply(new BigDecimal(this.quantity));
        }
    }

    // Default constructor
    public CartItem() {
    }
}
