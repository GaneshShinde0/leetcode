/* Write your T-SQL query statement below */

--SELECT * FROM Traffic where login_date = '2019-04-01'
WITH CTE AS(
    SELECT DISTINCT ROW_NUMBER() OVER(PARTITION BY user_id order by activity_date asc) as rnk, activity_date, user_id from Traffic WHERE activity = 'login'
)
--SELECT * FROM CTE
SELECT t.activity_date  as login_date,COUNT(DISTINCT t.user_id) as user_count
FROM Traffic t inner join cte c on t.user_id = c.user_id and t.activity_date = c.activity_date
WHERE t.activity_date between DATEADD(DAY,-90, CAST('2019-06-30' as date)) and CAST('2019-06-30' as date) 
AND 
t.activity = 'login' AND c.rnk = 1
GROUP BY t.activity_date 
