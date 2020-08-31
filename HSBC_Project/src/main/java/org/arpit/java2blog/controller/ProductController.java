package org.arpit.java2blog.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.arpit.java2blog.bean.Product;
import org.arpit.java2blog.service.ProductService;

@Path("/products")
public class ProductController {

	ProductService productService = new ProductService();

	@GET
	@Path("/allProducts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts() {

		List<Product> listOfproducts = productService.getAllProducts();
		System.out.println("fetched all products");
		return listOfproducts;
	}

	@GET
	@Path("/lessThan/{price}/{amount}")

	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductLesserByPrice(@PathParam("price") double price, @PathParam("amount") double amount) {
		// price=50&amount=2

		System.out.println(price + "," + amount);
		return productService.getProductLesserByPrice(price);
	}

	@GET

	@Path("/priceBetween/{fromPrice}/and/{toPrice}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductPriceBetWeen(@PathParam("fromPrice") double fromPrice,
			@PathParam("toPrice") double toPrice) {
		System.out.println(fromPrice + " fromPrice , toPrice" + toPrice);
		return productService.getProductPriceBetWeen(fromPrice, toPrice);
	}

	@GET
	@Path("/graterThan/{price}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductGraterByPrice(@PathParam("price") double price) {
		return productService.getProductGraterByPrice(price);
	}

	@GET
	@Path("/category/{category}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductByCatogery(@PathParam("category") String category) {
		category = "s";
		return productService.getProductByCatrgory(category);
	}

	@POST
	@Path("/placeOrder")
	@Produces(MediaType.APPLICATION_JSON)
	public String placeOrder(Product product) {
		// productService.placeOrder(product);
		boolean avilable = false;
		avilable = productService.placeOrdeAndUpdateProductAndOrder(product);
		if (avilable) {
			System.out.println("Order Placed");
			return "orderPlaced";
		} else {
			System.out.println("Sorry, out of stack");
			return "Sorry, out of stack";
		}

	}

	@DELETE
	@Path("/cancelOrder/{productid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String cancelOrder(@PathParam("productid") String productModel) {

		productService.cancelOrder(productModel);
		productService.updateOrderAndProductTable(productModel);
		// productService.updateProduct(id);
		return "Order successfully cancelled";

	}

	/*
	 * @DELETE
	 * 
	 * @Path("/{id}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public void
	 * deleteCountry(@PathParam("id") int id) { countryService.deleteCountry(id);
	 * 
	 * }
	 */

}
