with cte as(
    select employee_id ,
    sum(DATEDIFF(MINUTE,in_time,out_time)+1) as minutes
from logs
    group by employee_id 
)
--  select * from cte
select Employees.employee_id 
from Employees 
left join cte
ON Employees.employee_id=cte.employee_id
where needed_hours*60>ISNULL(MINUTES,0)