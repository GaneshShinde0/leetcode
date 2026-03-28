with agg_table as (
    select
        p.employee_id,
        project_id,
        name as employee_name,
        workload as project_workload,
        avg(workload) over(partition by team) as avg_workload
    from Employees e
    join Project p on e.employee_id=p.employee_id
)

select
    employee_id,
    project_id,
    employee_name,
    project_workload
from agg_table
where project_workload > avg_workload
order by 1, 2;