package gift.controller;

import gift.service.ProductService;
import gift.domain.model.Product;
import gift.domain.model.ProductRequestDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public Product getProduct(@RequestParam Long id) {
        try {
            return productService.getProduct(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping("/all")
    public List<Product> getAllProduct() {
        try {
            return productService.getAllProduct();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductRequestDto productRequestDto) {
        try {
            productService.addProduct(productRequestDto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @PostMapping("/update")
    public void updateProduct(@RequestBody ProductRequestDto productRequestDto) {
        try {
            productService.updateProduct(productRequestDto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @PostMapping("/delete")
    public void deleteProduct(@RequestParam Long id) {
        try {
            productService.deleteProduct(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}