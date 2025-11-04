/* Write your T-SQL query statement below */

WITH CTE AS (SELECT COUNT(*) as count, activity From activities a right join Friends f on a.name = f.activity GROUP BY activity)
SELECT activity from CTE WHERE count not in (select max(count) from cte UNION ALL SELECT min(count) FROM CTE)