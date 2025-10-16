/* Write your T-SQL query statement below */
SELECT p.name, COALESCE(sum(rest),0) as rest, COALESCE(sum(paid),0) as paid, COALESCE(sum(canceled),0) as canceled, COALESCE(sum(refunded),0) as refunded 
FROM Product p left join Invoice i
ON p.product_id = i.product_id
GROUP BY p.name