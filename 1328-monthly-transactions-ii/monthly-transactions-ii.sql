/* Write your T-SQL query statement below */
SELECT 
    Month, 
    country, 
    SUM(IIF(state = 'approved', 1, 0)) AS approved_count, 
    SUM(IIF(state = 'approved', amount, 0)) AS approved_amount, 
    SUM(IIF(state = 'chargeback', 1, 0)) AS chargeback_count, 
    SUM(IIF(state = 'chargeback', amount, 0)) AS chargeback_amount 
FROM (
    SELECT 
        LEFT(cb.trans_date, 7) AS Month, 
        country, 
        'chargeback' AS state, 
        amount 
    FROM chargebacks cb 
    JOIN transactions ON cb.trans_id = transactions.id 
    
    UNION ALL 
    
    SELECT 
        LEFT(trans_date, 7) AS Month, 
        country, 
        state, 
        amount 
    FROM Transactions 
    --Where state = 'approved' this one or Having both work the same.
) SRC 
GROUP BY 
    Month, 
    country 
HAVING 
    SUM(IIF(state = 'approved', 1, 0)) > 0 
    OR SUM(IIF(state = 'chargeback', 1, 0)) > 0;