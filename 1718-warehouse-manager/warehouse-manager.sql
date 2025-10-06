/* Write your T-SQL query statement below */
SELECT name as warehouse_name,SUM(width*length*height*units) as volume from 
Warehouse w left join products p on w.product_id=p.product_id
GROUP BY name