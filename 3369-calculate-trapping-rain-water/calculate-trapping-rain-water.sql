/* Write your T-SQL query statement below */
with cte as(
    select *, 
    max(height) over(order by id) lft ,-- left scan
        max(height) over(order by id desc) ryt -- Right scan
        from heights
)
select    sum(iif(lft<ryt,lft,ryt)-height)total_trapped_water 
from cte