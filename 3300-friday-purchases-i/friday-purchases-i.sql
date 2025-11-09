/* Write your T-SQL query statement below */
SELECT datepart(week,purchase_date)%datepart(month,purchase_date)+1 as week_of_month,purchase_date , sum(amount_spend) as total_amount FROM Purchases 
GROUP BY datepart(week,purchase_date)%datepart(month,purchase_date),purchase_date having datename(dw,purchase_date) = 'Friday'