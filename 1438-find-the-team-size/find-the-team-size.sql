/* Write your T-SQL query statement below */
SELECT employee_id,team_size FROM Employee e left join (SELECT team_id,COUNT(*) as team_size from Employee GROUP by team_id)as src on e.team_id=src.team_id