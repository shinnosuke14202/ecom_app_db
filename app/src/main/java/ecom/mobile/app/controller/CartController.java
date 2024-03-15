package ecom.mobile.app.controller;

import ecom.mobile.app.service.serviceInterface.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CartController {
    @Autowired
    CartService cartService;
}
