package ru.gvzholud.spring1.service;

import ru.gvzholud.spring1.domain.Product;

import java.util.List;

public interface Service {

<<<<<<< HEAD
    String getProduct(int id);

=======
>>>>>>> origin/master
    Product saveProduct(Product product);

    List<Product> getAll();

    Product updateProduct(Product product, int id);

    void deleteProductById(int id);
}
