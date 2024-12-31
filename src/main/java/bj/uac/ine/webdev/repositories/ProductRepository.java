package bj.uac.ine.webdev.repositories;

import bj.uac.ine.webdev.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameStartingWithOrderByPriceDesc(String name);

    @Query("select p from Product p where p.name like :name% and color = :color")
    List<Product> getProductsByNameStartingWithOrderByPriceDesc(@Param("name") String name, @Param("color") String color, Sort sort);

    @Query("select p from Product p where p.name like :name% and color = :color")
    Page<Product> getProductsPageByNameStartingWithOrderByPriceDesc(@Param("name") String name, @Param("color") String color, Pageable pageable);
}
