package org.arpit.java2blog.repo;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.arpit.java2blog.bean.Product;
import org.arpit.java2blog.db.DBIManager;

public class Repository {
	Connection dbConnection = null;
	DBIManager dbm = new DBIManager();
	Statement statement = null;

	PreparedStatement psmt = null;
	List<Product> products = new ArrayList<Product>();

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		try {
			dbConnection = dbm.getConnectionObject();
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM product");
			System.out.println(rs.getFetchSize());

			while (rs.next()) {
				System.out.println("came inside");
				Product product = new Product();
				product.setCategory(rs.getString("category"));
				product.setCompeny(rs.getString("compeny"));
				product.setProductModel(rs.getString("product_no"));
				product.setColor(rs.getString("color"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setDiscount(rs.getDouble("discount"));
				product.setIn_stack_count(rs.getInt("in_stack_count"));
				System.out.println("list prepared");
				products.add(product);
			}

		} catch (Exception e) {
			System.out.println("no products");
			e.printStackTrace();
		}

		return products;
	}

	public void addProduct(Product product) {
		dbConnection = dbm.getConnectionObject();
		try {
			Statement preparedStatement = dbConnection.createStatement();
			String placeOrder = "INSERT INTO ordertbl (`product_no`,`compeny`) VALUES ('" + product.getProductModel()
					+ "','" + product.getCompeny() + "')";

			preparedStatement.execute(placeOrder);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateProduct(int id) {

	}

	public void placeOrder(Product product) {
		dbConnection = dbm.getConnectionObject();
		try {
			Statement preparedStatement = dbConnection.createStatement();
			String placeOrder = "INSERT INTO ordertbl (`product_no`,`compeny`) VALUES ('" + product.getProductModel()
					+ "','" + product.getCompeny() + "')";

			preparedStatement.execute(placeOrder);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cancelOrder(String productModel) {
		dbConnection = dbm.getConnectionObject();
		try {
			Statement preparedStatement = dbConnection.createStatement();
			String cancelOrder = "DELETE FROM ordertbl WHERE  `product_no`='" + productModel + "'";

			preparedStatement.execute(cancelOrder);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateInStock(String productModel) {

		dbConnection = dbm.getConnectionObject();
		try {
			Statement preparedStatement = dbConnection.createStatement();
			String placeOrder = "UPDATE product SET in_stack_count=in_stack_count+1 WHERE  product_no='" + productModel
					+ "'";

			preparedStatement.execute(placeOrder);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//

	}

	public List<Product> getProductLesserByPrice(double price) {
		List<Product> products = new ArrayList<Product>();
		try {
			dbConnection = dbm.getConnectionObject();
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM product p WHERE p.price<" + price);

			while (rs.next()) {

				Product product = new Product();
				product.setCategory(rs.getString("category"));
				product.setCompeny(rs.getString("compeny"));
				product.setProductModel(rs.getString("product_no"));
				product.setColor(rs.getString("color"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setDiscount(rs.getDouble("discount"));
				product.setIn_stack_count(rs.getInt("in_stack_count"));

				products.add(product);
			}
			System.out.println("list prepared");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return products;

		// TODO Auto-generated method stub

	}

	public List<Product> getProductByCatrgory(String catogery) {
		List<Product> products = new ArrayList<Product>();
		try {
			dbConnection = dbm.getConnectionObject();
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM product p WHERE p.category='" + catogery + "'");

			while (rs.next()) {

				Product product = new Product();
				product.setCategory(rs.getString("category"));
				product.setCompeny(rs.getString("compeny"));
				product.setProductModel(rs.getString("product_no"));
				product.setColor(rs.getString("color"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setDiscount(rs.getDouble("discount"));
				product.setIn_stack_count(rs.getInt("in_stack_count"));

				products.add(product);
			}
			System.out.println("list prepared");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return products;

		// TODO Auto-generated method stub

	}

	public List<Product> getProductGraterByPrice(double price) {
		List<Product> products = new ArrayList<Product>();
		try {
			dbConnection = dbm.getConnectionObject();
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM product p WHERE p.price>" + price);

			while (rs.next()) {

				Product product = new Product();
				product.setCategory(rs.getString("category"));
				product.setCompeny(rs.getString("compeny"));
				product.setProductModel(rs.getString("product_no"));
				product.setColor(rs.getString("color"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setDiscount(rs.getDouble("discount"));
				product.setIn_stack_count(rs.getInt("in_stack_count"));

				products.add(product);
			}
			System.out.println("list prepared");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return products;

		// TODO Auto-generated method stub

	}

	public List<Product> getProductPriceBetWeen(double from, double to) {
		List<Product> products = new ArrayList<Product>();
		try {
			dbConnection = dbm.getConnectionObject();
			statement = dbConnection.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM product p WHERE p.price>" + from + " AND p.price <" + to + "");

			while (rs.next()) {

				Product product = new Product();
				product.setCategory(rs.getString("category"));
				product.setCompeny(rs.getString("compeny"));
				product.setProductModel(rs.getString("product_no"));
				product.setColor(rs.getString("color"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setDiscount(rs.getDouble("discount"));
				product.setIn_stack_count(rs.getInt("in_stack_count"));

				products.add(product);
			}
			System.out.println("list prepared");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return products;

		// TODO Auto-generated method stub

	}

	public void updateOutStock(Product product) {

		dbConnection = dbm.getConnectionObject();
		try {
			Statement preparedStatement = dbConnection.createStatement();
			String placeOrder = "UPDATE product SET in_stack_count=in_stack_count-1 WHERE  product_no='"
					+ product.getProductModel() + "'";

			preparedStatement.execute(placeOrder);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//

	}

	public boolean checkAvailability(String productModel) {
		boolean available = false;
		dbConnection = dbm.getConnectionObject();
		try {
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM product p WHERE product_no='" + productModel + "'");
			int size = 0;
			if (rs != null) {
				rs.beforeFirst();
				rs.last();
				size = rs.getInt("in_stack_count");
			}

			System.out.println("size:" + size);
			if (size > 0) {
				available = true;
			} else {
				available = false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//
		return available;
	}

}
