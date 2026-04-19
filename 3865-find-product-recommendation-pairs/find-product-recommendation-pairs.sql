/* Write your T-SQL query statement below */
WITH filter_first as (
    SELECT product_id, count(user_id) total_bought
    FROM ProductPurchases
    GROUP BY product_id
    HAVING count(user_id)>=3
), main_process AS(
    SELECT p.product_id as product1_id, p1.product_id as product2_id, count(distinct p.user_id) customer_count 
    FROM ProductPurchases p INNER JOIN ProductPurchases p1 on p.product_id <p1.product_id AND p.user_id = p1.user_id
    AND EXISTS (SELECT 1 FROM filter_first C where P.product_id = C.product_id)
    AND EXISTS ( SELECT 1 FROM filter_first C WHERE P1.PRODUCT_ID = c.product_id)
	GROUP BY P.product_id, P1.product_id
    HAVING COUNT(DISTINCT p.user_id)>=3
)
SELECT product1_id, product2_id,
(SELECT category from ProductInfo p WHERE p.product_id = M.product1_id ) as product1_category,
(SELECT category from ProductInfo p WHERE p.product_id = M.product2_id ) as product2_category, customer_count FROM main_process M
ORDER BY customer_count DESC, product1_id, product2_id