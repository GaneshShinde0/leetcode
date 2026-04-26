
with cte as(
    select student_id,department_id,
    rank() over (partition by department_id order by mark desc) as rn,
    count(*) over ( partition by department_id) as cnt
    from Students
)
select student_id,department_id,
case when cnt>1 then round((rn-1.0)/(cnt-1.0)*100,2) else 0.00 end as percentage

from cte