/* Write your T-SQL query statement below */
WITH CTE AS (SELECT employee_id from Employees where manager_id in (SELECT EMPLOYEE_ID from Employees WHERE Manager_id = 1)),
CTE1 as (SELECT employee_id from Employees where manager_id in (SELECT EMPLOYEE_ID from CTE ))

SELECT distinct employee_id FROM (
SELECT employee_id FROM cte
UNION ALL 
SELECT employee_id FROM CTE1
UNION ALL
SELECT EMPLOYEE_ID from Employees WHERE Manager_id = 1
) src WHERE employee_id<>1