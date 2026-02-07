/* Write your T-SQL query statement below */
WITH CTE AS (SELECT user_id, action_date,action, RANK() OVER(PARTITION BY user_id order by action_date asc) as rnk FROM activity)
SELECT user_id, action, COUNT(*) as streak_length, MIN(action_date) as start_date, max(action_date) as end_date FROM CTE GROUP BY user_id, action, DATEADD(DAY, -rnk,action_date)
HAVING COUNT(*)>=5
ORDER BY 3 DESC, 1 ASC