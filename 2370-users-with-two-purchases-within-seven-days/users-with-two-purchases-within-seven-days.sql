/* Write your T-SQL query statement below */
SELECT distinct p1.user_id
FROM purchases as p1
JOIN purchases as p2
ON p1.user_id = p2.user_id
AND p1.purchase_id>p2.purchase_id
AND ABS(datediff(day,p1.purchase_date,p2.purchase_date))<=7
ORDER by p1.user_id