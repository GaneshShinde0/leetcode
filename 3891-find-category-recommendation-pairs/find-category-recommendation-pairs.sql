WITH cat1 AS (
    SELECT user_id, category FROM ProductPurchases p JOIN ProductInfo p1 on p.product_id = p1.product_id
), CTE2 AS (
    SELECT cat1.category as category1, cat2.category as category2, COUNT(DISTINCT cat1.user_id) as customer_count
    FROM cat1 JOIN cat1 as cat2 ON cat1.category<cat2.category AND cat1.user_id = cat2.user_id
    GROUP BY cat1.category, cat2.category HAVING(COUNT(DISTINCT cat1.user_id))>2
)
SELECT category1, category2, customer_count from CTE2 m 
ORDER BY customer_count desc, category1, category2