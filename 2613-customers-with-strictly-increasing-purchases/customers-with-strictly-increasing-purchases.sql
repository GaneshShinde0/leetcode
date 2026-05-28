WITH YEARLY as 
(SELECT customer_id, year(max(order_date)) year, sum(price) price FROM orders GROUP BY year(order_date), customer_id)
SELECT y1.customer_id FROM yearly y1 left join yearly y2 on y1.customer_id = y2.customer_id
and y1.year+1 = y2.year and y1.price<y2.price
GROUP BY y1.customer_id
HAVING count(*) - count(y2.customer_id) = 1
