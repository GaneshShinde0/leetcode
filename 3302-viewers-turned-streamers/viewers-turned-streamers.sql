/* Write your T-SQL query statement below */
WITH CTE AS (
    SELECT user_id, session_start, session_end,session_type, RANK() OVER(PARTITION BY user_id ORDER BY SESSION_START ASC) as RNK FROM Sessions
)
SELECT user_id, COUNT(*) as sessions_count FROM Sessions where user_id in (SELECT user_id from  CTE where session_type='Viewer' AND RNK=1) AND session_type='Streamer'
GROUP BY user_id
ORDER BY 2 DESC, 1 DESC