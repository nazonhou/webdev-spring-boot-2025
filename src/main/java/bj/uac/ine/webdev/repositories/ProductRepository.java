package bj.uac.ine.webdev.repositories;

import bj.uac.ine.webdev.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
