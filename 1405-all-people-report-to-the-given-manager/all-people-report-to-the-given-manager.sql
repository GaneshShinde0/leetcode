-- -- Initial
-- WITH CTE AS (SELECT employee_id from Employees where manager_id in (SELECT EMPLOYEE_ID from Employees WHERE Manager_id = 1)),
-- CTE1 as (SELECT employee_id from Employees where manager_id in (SELECT EMPLOYEE_ID from CTE ))

-- SELECT distinct employee_id FROM (
-- SELECT employee_id FROM cte
-- UNION ALL 
-- SELECT employee_id FROM CTE1
-- UNION ALL
-- SELECT EMPLOYEE_ID from Employees WHERE Manager_id = 1
-- ) src WHERE employee_id<>1

DECLARE @managerId INT = 1;
DECLARE @maxLevel INT = 3;  -- limit recursion depth

WITH RecursiveCTE AS (
    -- Anchor (Level 1)
    SELECT 
        employee_id, 
        manager_id, 
        1 AS Level
    FROM Employees
    WHERE manager_id = @managerId

    UNION ALL

    -- Recursive step
    SELECT 
        e.employee_id,
        e.manager_id,
        r.Level + 1
    FROM Employees e
    INNER JOIN RecursiveCTE r
        ON e.manager_id = r.employee_id
    WHERE r.Level < @maxLevel  -- limit to N levels
)
SELECT DISTINCT employee_id
FROM RecursiveCTE
WHERE employee_id <> @managerId;
