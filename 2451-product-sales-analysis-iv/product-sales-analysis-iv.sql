SELECT user_id, product_id FROM (SELECT s.user_id, p.product_id,rnk = rank() OVER(PARTITION BY s.user_id ORDER BY SUM(s.quantity*p.price) DESC) FROM Sales s left join Product p on s.product_id = p.product_id
GROUP BY s.user_id,p.product_id) a WHERE rnk = 1
 /* Write your T-SQL query statement below */
