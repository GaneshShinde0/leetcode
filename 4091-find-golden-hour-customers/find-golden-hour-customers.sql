SELECT customer_id, COUNT(order_id) AS total_orders,
    round(SUM(CASE WHEN CAST(order_timestamp AS time) BETWEEN '11:00:00' AND '14:00:00' 
				  OR CAST(order_timestamp AS time) BETWEEN '18:00:00' AND '21:00:00' 
			 THEN 1 ELSE 0 END) * 100.0 / COUNT(1), 0) AS peak_hour_percentage,
    round(AVG(order_rating * 1.0), 2) AS average_rating
FROM restaurant_orders
GROUP BY customer_id
HAVING
COUNT(order_id) >= 3
AND SUM(CASE WHEN CAST(order_timestamp AS time) BETWEEN '11:00:00' AND '14:00:00' 
			  OR CAST(order_timestamp AS time) BETWEEN '18:00:00' AND '21:00:00' 
		 THEN 1 ELSE 0 END) * 100.0 / COUNT(1) >= 60
AND SUM(CASE WHEN order_rating IS NOT NULL THEN 1 ELSE 0 END) * 100.0 / COUNT(1) > 50
and AVG(order_rating) >= 4
order by average_rating desc, customer_id desc;