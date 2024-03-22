package ecom.mobile.app.controller;

import ecom.mobile.app.model.Cart;
import ecom.mobile.app.service.serviceInterface.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/add-cart")
    public Cart addCart(@RequestBody Cart cart){
        return cartService.addCart(cart);
    }

    @GetMapping("/carts/{user_id}")
    public List<Cart> getCartsByUserId(@PathVariable("user_id") int user_id){
        return cartService.getCartsByUserId(user_id);
    }

    @PostMapping("/cart/update/{cart_id}")
    public void updateCartQuantity(@PathVariable("cart_id") int cart_id,@RequestParam("quantity") int quantity){
        cartService.updateCartQuantity(cart_id,quantity);
    }

    @DeleteMapping("/cart/delete/{cart_id}")
    public void deleteCartById(@PathVariable("cart_id") int cart_id){
        cartService.deleteCartById(cart_id);
    }

    @DeleteMapping("/cart/delete-all/{user_id}")
    public void deleteCartByUid(@PathVariable("user_id") int user_id){
        cartService.deleteCartByUserId(user_id);
    }

}
