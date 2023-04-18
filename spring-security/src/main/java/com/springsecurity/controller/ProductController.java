package com.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.springsecurity.dto.Product;
import com.springsecurity.entity.UserInfo;
import com.springsecurity.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

	/*
	 * @Autowired private AuthenticationManager authenticationManager;
	 */
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }
    
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Product> getAllTheProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Product getProductById(@PathVariable int id) {
        return service.getProduct(id);
    }
    

}
