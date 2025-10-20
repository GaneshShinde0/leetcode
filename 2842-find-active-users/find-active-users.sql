/* Write your T-SQL query statement below */
WITH CTE AS(
    SELECT user_id,created_at, row_number() OVER (ORDER BY (SELECT NULL)) as rn FROM Users
)
SELECT DISTINCT u1.user_id FROM CTE u1 left join CTE u2 on u1.user_id = u2.user_id WHERE --u1.amount<>u2.amount AND 
ABS(DATEDIFF(DAy,u2.created_at,u1.created_at))<8 and u1.rn<>u2.rn
