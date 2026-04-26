/* Write your T-SQL query statement below */
With MonthlyIncome as (
    SELECT t.account_id,  DATEADD(MONTH, DATEDIFF(MONTH, 0, t.day), 0) AS income_month, SUM(t.amount) as monthly_income,
        a.max_income
    FROM Transactions t LEFT JOIN Accounts a ON a.account_id = t.account_id 
    WHERE t.type = 'Creditor' 
    GROUP BY t.account_id, DATEADD(MONTH, DATEDIFF(MONTH, 0, t.day), 0), a.max_income
    HAVING sum(t.amount)>a.max_income
) 
SELECT Income1.account_id FROM MOnthlyIncome Income1, MonthlyIncome Income2 
WHERE Income1.account_id = Income2.account_id AND DATEDIFF(MONTH,Income1.income_month, Income2.income_month)=1
GROUP BY Income1.account_id
ORDER BY Income1.account_id