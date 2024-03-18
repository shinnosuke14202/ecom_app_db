package ecom.mobile.app.controller;

import ecom.mobile.app.model.Product;
import ecom.mobile.app.service.serviceInterface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /////// POST ///////

    @PostMapping("/products")
    public Product SaveProduct(
            @RequestParam("product") String productString,
            @RequestParam("image") MultipartFile image
    ) throws IOException {
        return productService.saveProduct(productString, image);
    }

    /////// PUT ////////

    @PutMapping("/products/{id}")
    public Product updateProduct(
            @PathVariable("id") int id,
            @RequestParam("product") String productString,
            @RequestParam("image") MultipartFile image
    ) throws IOException {
        return productService.updateProduct(id, productString, image);
    }

    /////// GET ///////

    @GetMapping("/products")
    public List<Product> fetchAllProducts() {
        return productService.fetchAllProducts();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> fetchProductById(@PathVariable("id") int id) {
        return productService.fetchProductById(id);
    }

    @GetMapping("products/search/{keyword}")
    public List<Product> searchProducts(@PathVariable("keyword") String keyword) {
        return productService.searchProducts(keyword);
    }

    @GetMapping("products/type/{id}")
    public List<Product> fetchProductsByType(@PathVariable("id") int id) {
        return productService.fetchProductsByType(id);
    }

//    @GetMapping("/products/{categories}")
//    public List<Product> getProductsByCategories(@RequestParam("categories") List<String> categoryNames) {
//        return productService.findProductsByCategoryName(categoryNames);
//    }

    /////// DELETE ///////

    @DeleteMapping("products/{id}")
    public String deleteProductById(@PathVariable("id") int id) {
        return productService.deleteProductById(id);
    }

}
