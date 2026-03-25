/* Write your T-SQL query statement below */
Declare @ProductCount int;
SELECT @ProductCount = COUNT(*) FROM Product;

SELECT customer_id FROM Customer GROUP BY customer_id having count(distinct product_key)=@ProductCount;