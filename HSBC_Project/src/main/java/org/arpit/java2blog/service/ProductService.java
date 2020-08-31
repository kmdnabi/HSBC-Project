package org.arpit.java2blog.service;

import java.util.List;

import org.arpit.java2blog.bean.Product;
import org.arpit.java2blog.repo.Repository;

public class ProductService {

	Repository repository = new Repository();

	public ProductService() {
	}

	public List<Product> getAllProducts() {

		return repository.getAllProducts();
	}

	/*
	 * public void addProduct(Product product) {
	 * 
	 * repository.addProduct(product); }
	 */

	public boolean updateProduct(int id) {
		repository.updateProduct(id);
		return true;
	}

	public void placeOrder(Product product) {
		repository.placeOrder(product);

	}

	public void cancelOrder(String productModel) {
		repository.cancelOrder(productModel);
	}

	public List<Product> getProductLesserByPrice(double price) {

		return repository.getProductLesserByPrice(price);

	}

	public List<Product> getProductByCatrgory(String category) {
		// TODO Auto-generated method stub
		return repository.getProductByCatrgory(category);
	}

	public List<Product> getProductGraterByPrice(double price) {
		return repository.getProductGraterByPrice(price);
	}

	public List<Product> getProductPriceBetWeen(double from, double to) {
		return repository.getProductPriceBetWeen(from, to);
	}

	public void updateOrderAndProductTable(String productModel) {
		repository.cancelOrder(productModel);
		repository.updateInStock(productModel);

	}

	public boolean placeOrdeAndUpdateProductAndOrder(Product product) {
		boolean available = false;

		available = repository.checkAvailability(product.getProductModel());
		if (available) {
			repository.addProduct(product);
			repository.updateOutStock(product);
			return available;
		} else {
			return available;
		}

	}
}
