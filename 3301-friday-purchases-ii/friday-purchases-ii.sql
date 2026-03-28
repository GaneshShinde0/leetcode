/*
-- Initial
WITH NovemberDates AS( -- Generate November Column
    SELECT CAST('2023-11-01' as DATE) as purchase_date
    UNION ALL
    SELECT DATEADD(DAY, 1, purchase_date) as purchase_date FROM NovemberDates
    WHERE Purchase_date<'2023-11-30'
)
SELECT (DAY(CAST(nd.purchase_date as datetime))/7+1) as week_of_month, nd.purchase_date, COALESCE(SUM(amount_spend),0) as total_amount FROM Purchases p
RIGHT JOIN NovemberDates nd on p.purchase_date = nd.purchase_Date
WHERE
MONTH(CAST(nd.purchase_date as datetime)) = '11' AND YEAR(CAST(nd.purchase_date as datetime)) = 2023  
GROUP BY nd.purchase_date HAVING DAY(CAST(nd.purchase_date as datetime))%7=3
*/
WITH NovemberDates AS (
    -- Start at the 1st of November
    SELECT DATEFROMPARTS(2023, 11, 1) AS purchase_date
    UNION ALL
    -- Automatically stop at the last day of that same month
    SELECT DATEADD(DAY, 1, purchase_date)
    FROM NovemberDates
    WHERE purchase_date < EOMONTH(DATEFROMPARTS(2023, 11, 1))
)
SELECT 
    -- Standard formula for week of month (1-7 = Week 1, 8-14 = Week 2, etc.)
    (DAY(nd.purchase_date)) / 7 + 1 AS week_of_month, 
    nd.purchase_date, 
    SUM(ISNULL(p.amount_spend, 0)) AS total_amount
FROM NovemberDates nd
LEFT JOIN Purchases p ON nd.purchase_date = p.purchase_date
WHERE DATENAME(weekday, nd.purchase_date) = 'Friday'
GROUP BY nd.purchase_date
ORDER BY week_of_month;