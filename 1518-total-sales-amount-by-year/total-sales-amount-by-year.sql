/* Write your T-SQL query statement below */
DECLARE @max_date DATE = (SELECT MAX(period_end) FROM Sales);
WITH RECURSIVE_CTE AS(
    SELECT MIN(PERIOD_START) as date FROM Sales
    UNION ALL
    SELECT DATEADD(DAY, 1, date) FROM RECURSIVE_CTE WHERE DATE<=@max_date
)

SELECT s.product_id, p.product_name, left(cte.date,4) as report_year, SUM(s.average_daily_sales) as total_amount
FROM Sales s
JOIN Product p on p.product_id = s.product_id
JOIN RECURSIVE_CTE cte ON s.period_start<=cte.date and s.period_end>=cte.date
GROUP BY s.product_id, p.product_name, left(cte.date,4)
ORDER BY 1, 3
OPTION (MAXRECURSION 0);
