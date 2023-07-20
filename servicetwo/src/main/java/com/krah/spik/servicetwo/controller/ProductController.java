package com.krah.spik.servicetwo.controller;

import com.krah.spik.servicetwo.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(1L, "00001", "Tubo Liso", 1L));
        products.add(new Product(2L, "00002", "Tubo Estructurado", 1L));
        products.add(new Product(3L, "00003", "Pieza especial", 2L));
    }

    @GetMapping
    public List<Product> getAll() {
        return products;
    }

    @GetMapping("find")
    public List<Product> getAll(@RequestParam("userId") Long userId) {
        return products.stream().filter(product -> product.getUserId().equals(userId)).toList();
    }
}
