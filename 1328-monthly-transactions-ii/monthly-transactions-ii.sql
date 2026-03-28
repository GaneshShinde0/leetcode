/* Write your T-SQL query statement below */
SELECT Month, country, SUM(IIF(state='approved' ,1,0)) as approved_count, SUM(iif(state='approved' ,amount,0)) as approved_amount,
 SUM(IIF(state='chargeback ',1,0)) as chargeback_count, SUM(iif(state='chargeback ',amount,0)) as chargeback_amount FROM 
 (
    SELECT LEFT(cb.trans_date,7) as MONTH, Country, 'chargeback' as state, amount 
    FROM chargebacks cb  join transactions on cb.trans_id = transactions.id
    UNION ALL
    SELECT LEFT(trans_date,7) as Month, country, state, amount FROM Transactions Where state = 'approved'
 ) SRC 
 Group BY Month, COuntry
