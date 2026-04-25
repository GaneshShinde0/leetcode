/* Write your T-SQL query statement below */

WITH CTE AS(
    SELECT a.seller_id, a.item_id, i.item_brand FROM 
    (SELECT seller_id, item_id, RANK() OVER (PARTITION BY SELLER_ID ORDER BY ORDER_DATE ASC) as RNK FROM ORDERS) a
            JOIN Items i on a.item_id = i.item_id
            WHERE a.rnk = 2
)
SELECT u.user_id as seller_id,
CASE WHEN u.favorite_brand = c.item_brand THEN 'yes' ELSE 'no' END AS [2nd_item_fav_brand]
FROM USERS U LEFT JOIN CTE c on u.user_id = c.seller_id