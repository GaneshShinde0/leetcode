/* Write your T-SQL query statement below */
WITH CTE AS (SELECT v.user_id,visit_date, transaction_date, SUM(CASE WHEN TRANSACTION_DATE IS NULL THEN 0 ELSE 1 END) as COUNT From Visits v left join Transactions t on v.user_id = t.user_id and v.visit_date = t.transaction_date
GROUP BY v.user_id,visit_date, transaction_date), 
CTE2 AS (SELECT COUNT as transactions_count, count(*) as visits_count FROM CTE GROUP BY COUNT),
CTE3 AS (
    SELECT 0 as transactions_count, (SELECT MAX(transactions_count) FROM CTE2) as max_val
    UNION ALL 
    SELECT transactions_count+1, max_val from CTE3 WHERE transactions_count<max_val
)
SELECT CTE3.transactions_count, ISNULL(CTE2.visits_count,0) as visits_count  FROM CTE3
LEFT JOIN CTE2 ON CTE3.transactions_count = CTE2.transactions_count
ORDER BY 1
