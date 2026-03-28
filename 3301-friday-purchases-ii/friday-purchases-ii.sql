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
