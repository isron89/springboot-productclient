package com.example.productservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.model.productModel;
import com.example.productservice.repository.productRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class productController {

    @Autowired
    productRepository productRepository;

    @GetMapping("/")
    public String index() {
        return "Welcome to Mandiri Product Service";
    }

    @GetMapping("/products")
    public ResponseEntity<List<productModel>> getAllProducts() {
        try {
            List<productModel> products = new ArrayList<productModel>();
            productRepository.findAll().forEach(products::add);
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<productModel> getProductById(@PathVariable("id") long id) {
        try {
            Optional<productModel> productData = productRepository.findById(id);

            return productData.isPresent() ? new ResponseEntity<>(productData.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            if (productData.isPresent() && productData.get().getId() == id) {
//                return new ResponseEntity<>(productData.get(), HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

