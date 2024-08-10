select sell_date, count(sell_date) as num_sold, STRING_AGG(product,',') WITHIN GROUP(order by PRODUCT ASC) as products
FROM (select distinct sell_date,product from Activities) src
GROUP BY sell_Date
order by sell_date
/* 
CTE
WITH DistinctProducts AS (
    SELECT DISTINCT sell_date, Product
    FROM Activities
)
SELECT 
    sell_date,
    COUNT(*) AS num_sold,
    STRING_AGG(Product, ',') WITHIN GROUP (ORDER BY Product) AS products
FROM 
    DistinctProducts
GROUP BY 
    sell_date
ORDER BY 
    sell_date;
*/
