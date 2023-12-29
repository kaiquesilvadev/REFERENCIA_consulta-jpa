package com.devsuperior.uri2621.dto;

import com.devsuperior.uri2621.projections.ProductMinProjection;

public class ProductDto {

	private String name;

	public ProductDto() {
	}
	
	public ProductDto(String name) {
		super();
		this.name = name;
	}

	public ProductDto(ProductMinProjection projection) {
		this.name = projection.getName();
	}

	@Override
	public String toString() {
		return "productDto [name=" + name + "]";
	}
}
