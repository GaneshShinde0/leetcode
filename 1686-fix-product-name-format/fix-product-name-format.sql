# Write your MySQL query statement below
SELECT lower(TRIM(product_name)) as product_name, SUBSTRING(sale_date,1,7) as sale_Date, COUNT(*) as total from Sales 
GROUP BY lower(TRIM(product_name)), SUBSTRING(sale_date,1,7) ORDER BY product_name asc, sale_date asc