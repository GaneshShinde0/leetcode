/* Write your T-SQL query statement below */
/*
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
*/
/* Write your T-SQL query statement below */
with periods as (
    select product_id, product_name, report_year
    from Product
    cross join (Values(2018), (2019), (2020)) as V(report_year)
)

select product_id,
       product_name,
       cast(report_year as varchar) as report_year,
       total_days_in_report_period * average_daily_sales as total_amount
from (
    select p.product_id,
           p.product_name,
           s.average_daily_sales,
           p.report_year,
           datediff(day,
                    IIF(s.period_start > datefromparts(report_year, 1, 1), s.period_start, datefromparts(report_year, 1, 1)),
                    IIF(s.period_end < datefromparts(report_year, 12, 31), s.period_end, datefromparts(report_year, 12, 31))
            ) + 1 as total_days_in_report_period
    from periods p
    join Sales s on p.product_id = s.product_id and p.report_year between year(period_start) and year(period_end)
) t
