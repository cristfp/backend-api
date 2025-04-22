package com.qima.api.controller;


import com.qima.api.products.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Product> create(@RequestBody DataCreateProducts data){

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(new Product(data)));
        //repository.save(new Product(data));
    }

    @GetMapping
    public List<DataListProduct> list(){
        return repository.findAll().stream().map(DataListProduct::new).toList();

    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
      return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
              .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    @Transactional
    public void upadte(@RequestBody DataUpdateProducts data){
        var product = repository.getReferenceById(data.id());
        product.updateData(data);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return repository.findById(id)
                .map(recordFound -> {
                recordFound.setName(product.getName());
                recordFound.setDescription(product.getDescription());
                recordFound.setPrice(product.getPrice());
                recordFound.setCategoryPath(product.getCategoryPath());
                recordFound.setCategories(product.getCategories());
                recordFound.setAvailable(product.getAvailable());
                recordFound.setObs(product.getObs());
                Product updated = repository.save(recordFound);
                return  ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build()).getBody();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void exclude(@PathVariable Long id){
        repository.deleteById(id);
    }
}
