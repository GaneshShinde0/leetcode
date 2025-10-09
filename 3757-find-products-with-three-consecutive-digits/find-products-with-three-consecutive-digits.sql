SELECT product_id , name 
FROM Products
WHERE name like '%[0-9][0-9][0-9]%' and name not like '%[0-9][0-9][0-9][0-9]%'
order by product_id