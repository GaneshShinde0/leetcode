/* Write your T-SQL query statement below */
SELECT DISTINCT p.session_id from Playback p left join ads a on p.customer_id = a.customer_id 
AND (a.timestamp>=start_time AND a.timestamp<=end_time) WHERE a.customer_id is null