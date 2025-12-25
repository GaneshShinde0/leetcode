with cte as (
    select voter, 1.0 / count(*) as value
    from Votes
    group by voter
),
cte2 as (
    select candidate, sum(value) as total
    from Votes V
            join cte on V.voter = cte.voter
    group by candidate
    having candidate is not null
)
select candidate
from cte2
where total = (select max(total) from cte2)
order by candidate;