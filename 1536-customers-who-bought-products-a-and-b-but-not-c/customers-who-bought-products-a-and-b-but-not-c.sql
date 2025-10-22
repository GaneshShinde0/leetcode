-- /* Write your T-SQL query statement below */
-- SELECT customer_id,customer_name FROM Customers WHERE customer_id IN (SELECT customer_id FROM Orders WHERE product_name = 'A') 
-- AND customer_id in (SELECT customer_id FROM Orders WHERE product_name = 'B')
-- AND customer_id not in (SELECT customer_id FROM Orders WHERE product_name = 'C')


SELECT c.customer_id, c.customer_name
FROM Customers c
JOIN Orders o ON o.customer_id = c.customer_id
GROUP BY c.customer_id, c.customer_name
HAVING SUM(CASE WHEN o.product_name = 'A' THEN 1 ELSE 0 END) > 0
   AND SUM(CASE WHEN o.product_name = 'B' THEN 1 ELSE 0 END) > 0
   AND SUM(CASE WHEN o.product_name = 'C' THEN 1 ELSE 0 END) = 0
ORDER BY c.customer_id;