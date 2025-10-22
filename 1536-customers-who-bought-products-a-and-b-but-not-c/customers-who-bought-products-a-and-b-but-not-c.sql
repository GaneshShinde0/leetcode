/* Write your T-SQL query statement below */
SELECT customer_id,customer_name FROM Customers WHERE customer_id in (SELECT customer_id FROM Orders WHERE product_name = 'A') 
AND customer_id in (SELECT customer_id FROM Orders WHERE product_name = 'B')
AND customer_id not in (SELECT customer_id FROM Orders WHERE product_name = 'C')