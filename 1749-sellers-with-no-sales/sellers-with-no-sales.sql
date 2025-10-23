# Write your MySQL query statement below
SELECT seller_name from Seller WHERE Seller_id not in (SELECT DISTINCT Seller_id from Orders where year(sale_date) = '2020')
ORDER BY seller_name ASC