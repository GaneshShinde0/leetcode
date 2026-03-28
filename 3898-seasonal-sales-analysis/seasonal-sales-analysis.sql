/* Write your T-SQL query statement below */
WITH CTE AS (
SELECT 
CASE 
WHEN MONTH(SALE_DATE) IN (12,1,2) THEN 'Winter'
WHEN MONTH(SALE_DATE) IN (3,4,5) THEN 'Spring'
WHEN MONTH(SALE_DATE) IN (6,7,8) THEN 'Summer'
WHEN MONTH(SALE_DATE) IN (9,10,11) THEN 'Fall'
END as Season, category, quantity, quantity*price revenue, p.PRODUCT_ID
FROM Sales s LEFT JOIN products p on s.product_id = p.product_id
),
CTE2 AS(
SELECT Season, category, SUM(quantity) total_quantity, SUM(revenue) as total_revenue , 
RANK() OVER(PARTITION BY Season ORDER BY SUM(quantity) desc, SUM(revenue) desc) as rnk FROM CTE
GROUP BY Season, category
)
SELECT Season,category, total_quantity, total_revenue FROM CTE2 WHERE RNK = 1;