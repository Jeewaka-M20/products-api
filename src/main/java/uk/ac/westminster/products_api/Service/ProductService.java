package uk.ac.westminster.products_api.Service;

import org.springframework.stereotype.Service;
import uk.ac.westminster.products_api.Product.DigitalProduct;
import uk.ac.westminster.products_api.Product.PhysicalProduct;
import uk.ac.westminster.products_api.Product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public List<String> getAllSummaries() {

        List<String> summaries = new ArrayList<>();

        for (Product p : products) {
            summaries.add(p.getSummary());
        }

        return summaries;
    }
    
    private Long nextId = 1L;

    public ProductService(){
            products.add(new DigitalProduct(
                    nextId++, "Clean Code (E-Book)", 100.00,
                    "downloads/cleancode.pdf", 12.00));

            products.add(new PhysicalProduct(
                    nextId++, "MacBook", 1500.00,
                    3.5, "100.00 x 120 x 50"));

    }
//        Product digitalProduct = new DigitalProduct(nextId++,"Clean Code (E-Book)",
//                100.00,
//                "downloads/cleancode.pdf",
//                12.00);
//
//        Product physicalproduct = new PhysicalProduct(nextId++,
//                "Macbbook",
//                1500.00,
//                3.5,
//                "100.00 x 120 x50");
//
//


    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        product.setId(nextId++); // use the value, then add one
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))   // .equals, never ==
                .findFirst();
    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();   
    }


}