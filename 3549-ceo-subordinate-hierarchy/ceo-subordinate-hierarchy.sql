/* Write your T-SQL query statement below */
WITH CTE AS (
    SELECT 
    employee_id,
    employee_name as subordinate_name,
    0 as hierarchy_level,
    salary 
    FROM Employees
    WHERE Manager_id is NULL

    UNION ALL

    SELECT e.employee_id, e.employee_name, c.hierarchy_level+1 AS hierarchy_level, e.salary 
    FROM Employees as e INNER JOIN CTE AS c ON e.manager_id = c.employee_id
)

SELECT c.employee_id as subordinate_id,
        subordinate_name as subordinate_name,
        hierarchy_level,
        salary - (SELECT salary  from Employees where manager_id is NULL) As salary_difference
FROM CTE c
WHERE hierarchy_level>0
ORDER BY hierarchy_level, subordinate_id