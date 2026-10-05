package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/products") //mapping endpoint
    public class ProductController{

        @GetMapping("{id}") //passing the mapping to localhost
        public Product getByID(@PathVariable long id){
            return new Product(id,"Laptop",999.99);
        }
    }

