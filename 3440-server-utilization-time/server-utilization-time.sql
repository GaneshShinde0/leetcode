/* Write your T-SQL query statement below */
-- SELECT s1.server_id, s1.status_time as start_time, s2.status_time as end_time FROM Servers s1 left join servers s2 on s1.server_id = s2.server_id 
-- WHERE s1.session_status = 'start' AND s2.session_status = 'stop' AND s1.status_time<s2.status_time
-- ORDER BY s1.status_time ASC
DECLARE @StartTime date;
Set @StartTime = '1970-01-01'
SELECT (SUM(CASE WHEN session_status='stop' THEN CAST(DATEDIFF(SECOND,@StartTime,status_time) AS BIGINT) ELSE 0 END) - SUM(CASE WHEN session_status='start' THEN CAST(DATEDIFF(SECOND,@StartTime,status_time) AS BIGINT) ELSE 0 END))/86400 as total_uptime_days
FROM Servers
