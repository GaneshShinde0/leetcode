-- select a.player_id, aa.event_date, sum(a.games_played) as games_played_so_far
-- from activity as a
--      inner join activity as aa
--      on a.player_id = aa.player_id and a.event_date <= aa.event_date
-- group by a.player_id, aa.event_date

SELECT a.player_id, a.event_date,sum(games_played) over(partition by a.player_id order by event_date) as games_played_so_far from activity as a  