/* Write your T-SQL query statement below */
SELECT product_id, sum(quantity) as total_quantity from sales GROUP BY product_id order by product_id asc