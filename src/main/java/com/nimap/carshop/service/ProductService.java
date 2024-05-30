package com.nimap.carshop.service;
import com.nimap.carshop.dto.ProductDTO;
import com.nimap.carshop.model.Product;
import com.nimap.carshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id).map(product -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setCarName(product.getCarName());
            productDTO.setCarType(product.getCarType());
            productDTO.setFueling(product.getFueling());
            productDTO.setMileage(product.getMileage());
            productDTO.setPrice(product.getPrice());
            productDTO.setCategoryId(product.getCategory().getId());
            return productDTO;
        });
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setCarName(productDetails.getCarName());
        product.setCarType(productDetails.getCarType());
        product.setFueling(productDetails.getFueling());
        product.setMileage(productDetails.getMileage());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
