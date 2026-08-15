WITH PreviousData AS (
    SELECT 
        customer_id, transaction_date, amount,
        LAG(transaction_date) OVER (PARTITION BY customer_id ORDER BY transaction_date) as prev_date,
        count(transaction_id) OVER (PARTITION BY customer_id ORDER BY transaction_date) AS transaction_counts
    FROM Transactions
),
StreakStarts AS (
    SELECT customer_id, transaction_date,
        CASE 
            WHEN DATEDIFF(DAY, PREV_DATE, transaction_date)=1 THEN 0
            ELSE 1
        END as is_start
    FROM PreviousData    
),
GroupedStreaks AS(
    SELECT customer_id, transaction_date,
        SUM(is_start) OVER (PARTITION BY customer_id ORDER BY transaction_date) AS streak_id
    FROM StreakStarts
),
StreakLengths AS (
    SELECT customer_id, COUNT(streak_id) as count FROM GroupedStreaks GROUP BY 
    customer_id,streak_id
)
SELECT customer_id FROM StreakLengths WHERE count=(select max(count) FROM StreakLengths) ORDER BY customer_id asc