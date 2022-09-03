package ru.gvzholud.spring1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gvzholud.spring1.domain.Product;

public interface Repository extends JpaRepository<Product,Integer> {
}
