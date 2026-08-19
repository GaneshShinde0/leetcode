WITH cat_stats AS (
    SELECT  customer_id,
            category,
            SUM(amount) AS cat_amount,
            COUNT(transaction_id) AS cat_count,
            MAX(transaction_date) AS last_date
    FROM Transactions t
    JOIN Products p ON t.product_id = p.product_id
    GROUP BY customer_id, category
),
final AS (
    SELECT  customer_id,
            category,
            SUM(cat_amount) OVER (PARTITION BY customer_id) AS total_amount,
            SUM(cat_count) OVER (PARTITION BY customer_id) AS transaction_count,
            COUNT(category) OVER (PARTITION BY customer_id) AS unique_categories,
            RANK() OVER (
                PARTITION BY customer_id
                ORDER BY cat_count DESC, last_date DESC
            ) AS rnk
    FROM cat_stats
)
SELECT  customer_id,
        ROUND(total_amount, 2) AS total_amount,
        transaction_count,
        unique_categories,
        ROUND(total_amount / transaction_count, 2) AS avg_transaction_amount,
        category AS top_category,
        ROUND(transaction_count * 10 + total_amount / 100.0, 2) AS loyalty_score
FROM final
WHERE rnk = 1
ORDER BY loyalty_score DESC, customer_id ASC;