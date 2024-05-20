package com.example.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> listAll(){
		return productRepository.findAll();
	}
	
	public void save(Product product) {
		productRepository.save(product);
	}
	
	public Product get(long id) {
		return productRepository.findById(id).get();
	}
	
	public void delete(long id) {
		productRepository.deleteById(id);
	}
}
