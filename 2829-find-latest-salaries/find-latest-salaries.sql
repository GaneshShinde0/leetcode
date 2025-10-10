# Write your MySQL query statement below
SELECT emp_id,firstname, lastname,salary,department_id from salary s1 right join
(SELECT emp_id as empid,max(salary) as sal from Salary group by emp_id) src on s1.emp_id = src.empid and s1.salary= src.sal
group by emp_id,firstname, lastname,salary,department_id order by emp_id asc

