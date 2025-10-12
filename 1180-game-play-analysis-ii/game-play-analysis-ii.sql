-- SELECT a.player_id,a.device_id FROM (SELECT player_id, MIN(event_Date) as min_Date FROM Activity GROUP BY player_id) dt
-- JOIN Activity a ON a.player_id = dt.player_id
-- AND a.event_Date = dt.min_date

WITH Players AS
(SELECT player_id, event_date as first_login, device_id, ROW_NUMBER() OVER(partition by player_id ORDER BY event_Date) as player_index FROM Activity)

SELECT player_id,device_id FROM players where player_index = 1;