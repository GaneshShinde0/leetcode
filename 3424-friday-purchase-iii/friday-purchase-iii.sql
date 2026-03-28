
WITH NovemberDates AS (
    -- Start at the 1st of November
    SELECT DATEFROMPARTS(2023, 11, 1) AS purchase_date
    UNION ALL
    -- Automatically stop at the last day of that same month
    SELECT DATEADD(DAY, 1, purchase_date)
    FROM NovemberDates
    WHERE purchase_date < EOMONTH(DATEFROMPARTS(2023, 11, 1))
),
Memberships AS(
    SELECT 'Premium' as membership
    UNION 
    SELECT 'VIP'
),
NovemberDatesAndMemberShip as(
    SELECT * FROM NovemberDates, Memberships
)
SELECT 
    -- Standard formula for week of month (1-7 = Week 1, 8-14 = Week 2, etc.)
    (DAY(ndm.purchase_date)) / 7 + 1 AS week_of_month, 
    ndm.membership, 
    SUM(CASE WHEN u.membership IS NOT NULL THEN p.amount_spend ELSE 0 END) AS total_amount
FROM NovemberDatesAndMemberShip ndm
Left JOIN Purchases p ON ndm.purchase_date = p.purchase_date
LEFT JOIN Users u on p.user_id = u.user_id AND ndm.membership = u.membership
WHERE DATENAME(weekday, ndm.purchase_date) = 'Friday'
GROUP BY ndm.purchase_date, ndm.membership
ORDER BY week_of_month, 2;