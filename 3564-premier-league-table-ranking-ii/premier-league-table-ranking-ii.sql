/* Write your T-SQL query statement below */
with cta as(
    select*,
    3*wins+draws points
    from TeamStats 
),
cte as(
    select *,
count(*) over()rnk,
rank() over(order by points desc) position 
from cta)
select team_name,points,position ,
case when position < rnk/3.0 +1 then 'Tier 1'
when position < 2*(rnk/3.0) +1 then 'Tier 2'
else 'Tier 3'
end tier
from cte
order by 2 desc,1