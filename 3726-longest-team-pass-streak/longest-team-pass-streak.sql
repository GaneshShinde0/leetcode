# Write your MySQL query statement below

with passes_enriched as (
    select player_pass_from.team_name,
    case when player_pass_from.team_name = player_pass_to.team_name then 'C' else 'I' end as pass_type,
    Passes.time_stamp
    from Passes,
    Teams player_pass_from,
    Teams player_pass_to
    where Passes.pass_from = player_pass_from.player_id
    and Passes.pass_to = player_pass_to.player_id
),
passes_lag as (
    select team_name,
    time_stamp,
    pass_type,
    lag(pass_type) over (partition by team_name order by time_stamp) as prev_pass_type
    from passes_enriched
),
passes_streaks as (
    select team_name,
    time_stamp,
    pass_type,
    prev_pass_type,
    sum(case when pass_type <> coalesce(prev_pass_type, 'X') then 1 else 0 end) over (order by team_name, time_stamp asc) as pass_group
    from passes_lag
), 
passes_streaks_agg as (
    select team_name, pass_group, count(*) as pass_streak_len
    from passes_streaks
    where pass_type <> 'I'
    group by team_name, pass_group
)
select team_name, max(pass_streak_len) as longest_streak
from passes_streaks_agg
group by team_name
order by 1