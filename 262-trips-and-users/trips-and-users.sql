WITH cte AS (
    SELECT request_at AS [Day], status
    FROM trips t
    INNER JOIN users u ON u.users_id = t.client_id  
    INNER JOIN users d ON d.users_id = t.driver_id  
    WHERE u.banned = 'NO' AND d.banned = 'NO'
)
SELECT [Day],
       CAST(1.0 * SUM(CASE WHEN status <> 'completed' THEN 1 ELSE 0 END) / COUNT(*) AS DECIMAL(10,2)) 
       AS [Cancellation Rate]
FROM cte
WHERE [Day] BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY [Day];