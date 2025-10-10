-- # Write your MySQL query statement below
-- SELECT project_id FROM Project GROUP BY project_id having count(*)= (SELECT max(count) from (SELECT count(*) as count,project_id from Project group by project_id) src)

select project_id
from(
select project_id,rank() over(order by count(distinct employee_id)desc ) rnk
from Project
group by project_id    
)t
where rnk =1 