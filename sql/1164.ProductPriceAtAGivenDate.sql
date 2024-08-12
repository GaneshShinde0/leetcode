/* Write your T-SQL query statement below */
/*
Naive Approach
SELECT DISTINCT pd.product_id, new_price price from Products pd inner join  (select product_id,max(change_date) change_date from products where change_date<= '2019-08-16'  GROUP BY product_id ) src on src.product_id = pd.product_id and src.change_date = pd.change_date
UNION ALL
select DISTINCT product_id,10 price from products where change_date> '2019-08-16' and product_id not in (
    SELECT pd.product_id from Products pd inner join  (select product_id,max(change_date) change_date from products where change_date<= '2019-08-16'  GROUP BY product_id ) src on src.product_id = pd.product_id and src.change_date = pd.change_date
)
*/
/*
WITH LatestPrices AS (
    SELECT 
        product_id, 
        MAX(change_date) AS change_date
    FROM 
        Products
    WHERE 
        change_date <= '2019-08-16'
    GROUP BY 
        product_id
),
FinalPrices AS (
    SELECT 
        p.product_id, 
        p.new_price AS price
    FROM 
        Products p
    JOIN 
        LatestPrices lp 
    ON 
        p.product_id = lp.product_id 
        AND p.change_date = lp.change_date
    UNION ALL
    SELECT 
        product_id, 
        10 AS price
    FROM 
        Products
    WHERE 
        change_date > '2019-08-16'
        AND product_id NOT IN (SELECT product_id FROM LatestPrices)
)
SELECT 
    DISTINCT product_id, 
    price
FROM 
    FinalPrices;
*/

WITH ProductChanges AS (
    SELECT
        product_id,
        new_price AS price,
        change_date,
        ROW_NUMBER() OVER (PARTITION BY product_id ORDER BY 
            CASE
                WHEN change_date = '2019-08-16' THEN 1
                WHEN change_date < '2019-08-16' THEN 2
                
                ELSE 3
            END,
            change_date DESC
        ) AS row_num
    FROM
        Products
)
SELECT
    product_id,
    CASE
        WHEN change_date > '2019-08-16' THEN 10
        ELSE price
    END AS price
FROM
    ProductChanges
WHERE
    row_num = 1
ORDER BY
    product_id;
