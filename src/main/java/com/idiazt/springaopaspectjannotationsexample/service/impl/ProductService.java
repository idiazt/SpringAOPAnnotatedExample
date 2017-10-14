package com.idiazt.springaopaspectjannotationsexample.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.idiazt.springaopaspectjannotationsexample.dao.ProductDAO;
import com.idiazt.springaopaspectjannotationsexample.entities.Product;
import com.idiazt.springaopaspectjannotationsexample.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Override
	public Product persist(Product product) {
		return ProductDAO.getInstance().persist(product);
	}

	@Override
	public Collection<Product> list() {
		return ProductDAO.getInstance().list();
	}

	@Override
	public Product findById(Long id) {
		return ProductDAO.getInstance().findById(id);
	}

	@Override
	public boolean delete(Long id) {
		return ProductDAO.getInstance().delete(id);
	}

}
