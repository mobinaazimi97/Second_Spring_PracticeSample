package com.mftplus.spring02.model.service.impl;

import com.mftplus.spring02.model.entity.Product;
import com.mftplus.spring02.model.repository.ProductRepository;
import com.mftplus.spring02.model.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

                            // # 1 -> unavailable for test !
//    @Autowired
//    private ProductRepository productRepository;

                        // # 2 -> Inject Constructor-> available for test but immutable !
//    private final ProductRepository productRepository;
//    public ProductServiceImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
                    // # 3->  mutable repository :
//    private ProductRepository productRepository;
//    public void setProductRepository(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);

    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }
}
