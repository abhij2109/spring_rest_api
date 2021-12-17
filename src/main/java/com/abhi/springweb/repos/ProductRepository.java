
package com.abhi.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.springweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
