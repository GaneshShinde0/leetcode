/* Write your T-SQL query statement below */

with cte as(
    select p.project_id, candidate_id, 
        sum(case when proficiency > importance then 10
                 when proficiency = importance then 0
                 else -5
            end) + 100 as score,
        count(*) as cnt_skill
    from Projects p
    left join Candidates c
    on p.skill = c.skill
    group by  p.project_id, candidate_id
),
tmp as(
    select project_id, candidate_id, score,
        row_number()over(partition by project_id order by score desc, candidate_id asc) as rn
    from cte
    where CONCAT(project_id, cnt_skill) in (
        select CONCAT(project_id, count(*))
        from Projects p1
        group by project_id
        having p1.project_id=cte.project_id
    )
)

select project_id, candidate_id, score
from tmp
where rn = 1
order by 1