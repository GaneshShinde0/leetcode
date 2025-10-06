/* Write your T-SQL query statement below */
SELECT id,name from students where department_id not in (select distinct id from departments);