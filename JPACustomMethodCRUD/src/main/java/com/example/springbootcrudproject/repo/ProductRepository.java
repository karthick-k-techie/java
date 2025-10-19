package com.example.springbootcrudproject.repo;


import com.example.springbootcrudproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product getProductByName(String name);

    Product getProductByPrice(Double price);

    Product getProductByIdAndName(UUID id, String name);

    @Query("select p from Product p")
    List<Product> getAllProductsUsingJPQL();


    @Query("select p from Product p where p.name =:n")
    List<Product> getAllProductsUsingJPQLQueryParam(@Param("n") String name);

    //@Query("select sum(p.price) as sum from Product p where p.name =:n")
//    @Query("select count(p.price) as count from Product p where p.name =:n")
    @Query("select sum(case when p.name = :n then p.price else 0.0 end ) as sumOfProducts,\n" +
            "\t sum(case when p.name = :n then p.price else 0.0 end ) as sumOfProducts2\n from Product p ")
    Map<String ,Double> getAllProductsPriceUsingJPQLQueryParam(@Param("n") String name);
    @Query(value ="select * from Product ", nativeQuery = true)
    List<Product> getAllProductsUsingNative();





}
