WITH Intervals AS
(
    SELECT
        *,
        CEILING(1.0*minute/6) AS interval_no
    FROM Orders
)
SELECT
    interval_no,
    SUM(order_count) AS total_orders
FROM Intervals
GROUP BY interval_no
ORDER BY interval_no;