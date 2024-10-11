package ee.devpipe.backend.controller;

import org.springframework.http.HttpStatus;
import ee.devpipe.backend.model.AppUser;
import ee.devpipe.backend.model.Product;
import ee.devpipe.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> saveProduct(@RequestBody Product product) {
        Optional<User> user = userRepository.findById(product.getUserId());
        if (user.isPresent()) {
            productRepository.save(product);
            return ResponseEntity.ok("{\"message\":\"Product saved!\"}");
        } else {
            return "User not found, product not saved!";
        }
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setUserId(updatedProduct.getUserId());
            productRepository.save(product);
            return new ResponseEntity<>("Product updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return new ResponseEntity<>("Product deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);
        }
    }
}
