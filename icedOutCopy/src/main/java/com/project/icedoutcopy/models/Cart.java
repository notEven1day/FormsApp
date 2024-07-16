package com.project.icedoutcopy.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="carts")
public class Cart extends BaseEntity {

    private User user;
    private List<CartItem> cartItems;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    // Default constructor
    public Cart() {}
}
