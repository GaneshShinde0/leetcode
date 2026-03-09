WITH Outgoing AS (
    SELECT paid_by, SUM(amount) as total_paid
    FROM Transactions 
    GROUP BY paid_by
),
Incoming AS (
    SELECT paid_to, SUM(amount) as total_received
    FROM Transactions 
    GROUP BY paid_to
)
SELECT 
    u.user_id, 
    u.user_name,
    -- Now the negative sign applies to the pre-calculated total
    u.credit+(ISNULL(i.total_received, 0) - ISNULL(o.total_paid, 0)) as credit,
    IIF(u.credit+(ISNULL(i.total_received, 0) - ISNULL(o.total_paid, 0))<0,'Yes','No') as credit_limit_breached 
FROM Users u
LEFT JOIN Outgoing o ON u.user_id = o.paid_by
LEFT JOIN Incoming i ON u.user_id = i.paid_to