package ru.gvzholud.spring1.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.gvzholud.spring1.domain.Product;
import ru.gvzholud.spring1.repositories.Repository;

import java.util.List;

@org.springframework.stereotype.Service
public class ProductService implements Service {

    private Repository repository;

    @Autowired
    public ProductService(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String getProduct(int id) {
        return repository.findById(id).toString();
    }

    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product updateProduct(Product product, int id) {
        Product previousProduct = repository.findById(id).get();
        previousProduct.setId(product.getId());
        previousProduct.setTittle(product.getTitle());
        previousProduct.setPrice(product.getPrice());
        return repository.save(previousProduct);
    }

    @Override
    public void deleteProductById(int id) {
        repository.deleteById(id);
    }

    public void deleteAllProducts() {
        repository.deleteAll();
    }

}
