WITH CTE AS (SELECT customer_id, order_id, order_Date,rank() OVER(PARTITION BY customer_id ORDER BY order_date desc) as RNK 
FROM Orders)
SELECT c.name as customer_name, c.customer_id, o.order_id, o.order_date FROM CTE o left join Customers c on o.customer_id = c.customer_id
WHERE rnk<=3 ORDER BY c.name ASC,c.customer_id ASC, ORDER_DATE desc