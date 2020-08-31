#HSBC-Project sample requirement.
#Contents covered :

1. get the list of all the products across all the categories
URL:   http://localhost:8080/JAXRSJsonCRUDExample/rest/products/allProducts

 2. get the list of all the products by category or of a price less than or greater than    a specified price for that product
URL:  http://localhost:8080/JAXRSJsonCRUDExample/rest/products/category/mobiles

3.get the list of all the products by company or of a price less than or greater than a specified price for that company
URL: http://localhost:8080/JAXRSJsonCRUDExample/rest/products/priceBetween/5000/and/20000

4. get the discounted price of all the products by category
URL http://localhost:8080/JAXRSJsonCRUDExample/rest/products/category/mobiles

5. able to place a dummy order in a separate (database) instance. Order placement should fail if the stock = number of dummy orders 
URL: http://localhost:8080/JAXRSJsonCRUDExample/rest/products/placeOrder
Note: please send request in JSON format.

6.  able to get the available stock details across products. This should consider the dummy orders placed and return stocks accordingly. 
URL: http://localhost:8080/JAXRSJsonCRUDExample/rest/products/allProducts

7.  able to delete the dummy order(s)
URL:  http://localhost:8080/JAXRSJsonCRUDExample/rest/products/cancelOrder/LL1
 

