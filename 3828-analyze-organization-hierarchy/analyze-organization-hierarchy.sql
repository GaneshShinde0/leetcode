WITH Hierarchy as (
    SELECT employee_id, employee_name, manager_id, salary, 1 as level FROM employees where manager_id is null
    UNION ALL
    select e.employee_id, e.employee_name, e.manager_id, e.salary, h.level+1 FROM employees e JOIN Hierarchy h on e.manager_id = h.employee_id
),
Subordinates as(
    SELECT manager_id, employee_id as subordinate_id FROM employees WHERE manager_id is not null
    UNION ALL
    SELECT s.manager_id, e.employee_id FROM subordinates s join employees e on e.manager_id = s.subordinate_id
),
ManagerStats as (
    SELECT s.manager_id, COUNT(*) as team_size, SUM(e.salary) as team_Salary from subordinates s join employees e on s.subordinate_id = e.employee_id GROUP BY s.manager_id
),
FinalResult as (
    SELECT h.employee_id, h.employee_name, h.level, COALESCE(ms.team_size,0) as team_size, h.salary + COALESCE(ms.team_salary,0) as budget FROM Hierarchy h left join ManagerStats ms on h.employee_id = ms.manager_id
)
SELECT * FROM FinalResult order by level asc, budget desc, employee_name asc