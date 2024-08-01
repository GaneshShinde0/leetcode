with cte as(
select
DENSE_RANK() over (order by Salary desc) as "r",
salary
from employee)

select
max(case when r=2 then Salary else null end) as "SecondHighestSalary"
from cte
