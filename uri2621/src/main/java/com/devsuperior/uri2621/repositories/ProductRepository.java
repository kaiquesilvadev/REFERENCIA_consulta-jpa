package com.devsuperior.uri2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2621.dto.ProductDto;
import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projections.ProductMinProjection;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(nativeQuery = true , value = "SELECT  products.name FROM products "
			+ "INNER JOIN providers ON products.id_providers = providers.id "
			+ "WHERE products.amount BETWEEN :min AND :max "
			+ "AND providers.name LIKE CONCAT(:name , '%')")
	List<ProductMinProjection> search1(Integer min , Integer max , String name);
	
	@Query("SELECT new com.devsuperior.uri2621.dto.ProductDto(p.name) "
			+ "FROM Product p "
			+ "WHERE p.amount BETWEEN :min AND :max "
			+ "AND p.provider.name LIKE CONCAT(:name , '%')")
	List<ProductDto> search2(Integer min , Integer max , String name);
}
