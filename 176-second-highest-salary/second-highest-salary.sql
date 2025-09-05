/* Write your T-SQL query statement below */
--SELECT MAX(SALARY) as SecondHighestSalary from employee WHERE salary< (select max(salary) from employee);
/*
SELECT ISNULL((SELECT DISTINCT SALARY FROM EMPLOYEE ORDER BY SALARY DESC
OFFSET 1 ROWS FETCH NEXT 1 ROWS ONLY),NULL) AS SecondHighestSalary;
*/
/*
SELECT TOP 1 lead(salary) over (order by salary desc) as SecondHighestSalary
FROM (Select DISTINCT SALARY FROM EMPLOYEE) a
ORDER By SALARY DESC
*/
/*
SELECT DISTINCT SALARY as SecondHighestSalary FROM
(SELECT Salary, dense_rank() over (order by salary desc) as rank from employee) a
right join (select 1 as rank union select 2 as rank) b
on a.rank = b.rank
where b.rank = 2;
*/

SELECT max(a.salary) as SecondHighestSalary from Employee a
RIGHT join EMPLOYEE B
on a.salary<b.salary;