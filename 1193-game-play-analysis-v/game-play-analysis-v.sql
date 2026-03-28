WITH Installs AS (
    SELECT player_id, MIN(event_date) AS install_dt
    FROM Activity
    GROUP BY player_id
)
SELECT 
    i.install_dt,
    COUNT(i.player_id) AS installs,
    ROUND(CAST(COUNT(a.player_id) AS FLOAT) / COUNT(i.player_id), 2) AS day1_retention
FROM Installs i
LEFT JOIN Activity a 
    ON i.player_id = a.player_id 
    AND a.event_date = DATEADD(day, 1, i.install_dt)
GROUP BY i.install_dt;