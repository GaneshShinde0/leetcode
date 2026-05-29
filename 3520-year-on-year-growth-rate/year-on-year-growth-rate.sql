WITH CTE AS (
    SELECT YEAR(transaction_date) as year, product_id, sum(spend) as curr_year_spend FROM user_transactions GROUP BY YEAR(transaction_date), PRODUCT_ID
),
CTE2 as (
    SELECT *, lag(curr_year_spend) OVER (partition by product_id ORDER BY year asc) as prev_year_spend FROM CTE
)
SELECT *, ROUND((curr_year_spend-prev_year_spend)/prev_year_spend*100.00,2) as yoy_rate FROM CTE2 ORDER BY product_id, year