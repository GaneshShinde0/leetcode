/* Write your T-SQL query statement below */
SELECT session_id, user_id, DATEDIFF(MINUTE, MIN(event_timestamp),MAX(event_timestamp)) as session_duration_minutes, SUM(CASE WHEN event_type = 'scroll' THEN 1 ELSE 0 END) as scroll_count
FROM app_events WHERE session_id NOT IN (Select distinct session_id FROM app_events WHERE event_type = 'purchase')
GROUP BY session_id, user_id
HAVING 
SUM(CASE WHEN event_type = 'scroll' THEN 1 ELSE 0 END)>=5
AND  DATEDIFF(MINUTE, MIN(event_timestamp),MAX(event_timestamp))>30
AND (SUM(CASE WHEN event_type = 'click' THEN 1.0 ELSE 0 END)/
SUM(CASE WHEN event_type = 'scroll' THEN 1 ELSE 0 END))<0.2
ORDER BY 4 DESC, 1 ASC