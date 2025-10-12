SELECT a.player_id,a.device_id FROM (SELECT player_id, MIN(event_Date) as min_Date FROM Activity GROUP BY player_id) dt
JOIN Activity a ON a.player_id = dt.player_id
AND a.event_Date = dt.min_date