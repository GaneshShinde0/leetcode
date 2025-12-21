/* Write your T-SQL query statement below */
select customer_id,product_id,product_name FROM (
select o.customer_id,p.product_id,p.product_name,
RANK() OVER(PARTITION BY o.customer_id ORDER BY COUNT(*) DESC) as rnk 
from products p inner join orders o 
on o.product_id=p.product_id
GROUP BY o.customer_id, p.product_id, p.product_name
) SRC
WHERE rnk = 1;