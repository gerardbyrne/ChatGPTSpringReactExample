package gerry.shoppingcart.Controller;

import gerry.shoppingcart.Model.Product;
import gerry.shoppingcart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/products")
// http://localhost:8080/api/products
public class ProductController {

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    private final ProductService productService;

    // http://localhost:8080/api/products/searchname
    @GetMapping("/searchname")
    public List<Product> searchProductsByName(@RequestParam(value = "name") String name) {
        return productService.findByName(name);
    }

    // http://localhost:8080/api/products/searchdescription
    @GetMapping("/searchdescription")
    public List<Product> searchProductsByDescription(@RequestParam(value = "description") String description) {
        return productService.findByDescription(description);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
