/* Write your T-SQL query statement below */
with cte as(select distinct sub_id from Submissions s where parent_id is null)
select cte.sub_id as post_id, count(distinct s.sub_id) as number_of_comments
from cte left join Submissions s on cte.sub_id=s.parent_id
group by cte.sub_id


