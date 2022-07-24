package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductRestController {


    final ProductService pService;
    final CacheManager cacheManager;
    public ProductRestController(ProductService pService, CacheManager cacheManager) {
        this.pService = pService;
        this.cacheManager = cacheManager;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {
        cacheManager.getCache("product").clear();
        return pService.save(product);
    }

    @Cacheable("product")
    @GetMapping("/list")
    public ResponseEntity list() {
        return pService.list();
    }


}
