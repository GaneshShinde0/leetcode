/*
Fails Few Test Cases
WITH SRC as(SELECT u.seller_id,COUNT(DISTINCT o.item_id) num_items  FROM Users u 
 join Items i on u.favorite_brand = i.item_brand
 join Orders o on u.seller_id = o.seller_id
WHERE i.item_id != o.item_id
GROUP BY u.seller_id)
SELECT * FROM SRC where num_items = (SELECT MAX(num_items) FROM src)
ORDER by seller_id ASC
*/
/* Write your T-SQL query statement below */
/*
select seller_id, num_items 
from ( 
select o.seller_id,  count(distinct i.item_id) as num_items, RANK() OVER(ORDER BY COUNT(DISTINCT i.item_id) DESC) AS rk
from orders o 
join Users u on o.seller_id = u.seller_id 
join Items i on o.item_id = i.item_id and i.item_brand <> u.favorite_brand
group by o.seller_id
) a
where rk = 1
*/
WITH SRC as(SELECT o.seller_id,COUNT(DISTINCT o.item_id) num_items  FROM Users u 
 join Orders o on u.seller_id = o.seller_id
join Items i on o.item_id = i.item_id and i.item_brand <> u.favorite_brand
GROUP BY o.seller_id)
SELECT * FROM SRC where num_items = (SELECT MAX(num_items) FROM src)
ORDER by seller_id ASC