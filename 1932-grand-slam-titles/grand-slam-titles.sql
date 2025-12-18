
-- Union ALL Way 
/*
with cte as (
select wimbledon as player_id
from  Championships
union all 
select FR_open
from Championships
union all 
select US_open
from Championships
union all 
select AU_open
from Championships
)*/

-- Unpivot
WITH CTE as (
    SELECT player_id 
    FROM championships
    UNPIVOT(
        player_id for pid in(WiMbledon, fr_open, us_open,au_open)
    ) AS SRC
)

select p.player_id,p.player_name ,count(*) as grand_slams_count
from cte c inner join players p 
on p.player_id = c.player_id 
group by p.player_id ,p.player_name