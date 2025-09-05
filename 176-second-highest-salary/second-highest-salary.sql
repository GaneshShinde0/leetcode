/* Write your T-SQL query statement below */
SELECT MAX(SALARY) as SecondHighestSalary from employee WHERE salary< (select max(salary) from employee);