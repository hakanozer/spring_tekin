package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    // eski stil ve maliyeti yüksek olan injecte işlemidir.
    //@Autowired ProductService ppService;

    // yeni stil ve maliyeti az olan bir injecte işlemidir.
    final ProductService pService;
    public ProductRestController(ProductService pService) {
        this.pService = pService;
    }


    @PostMapping("/save")
    public ResponseEntity save( @Valid @RequestBody Product product) {
        return pService.save(product);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return pService.list();
    }


}
