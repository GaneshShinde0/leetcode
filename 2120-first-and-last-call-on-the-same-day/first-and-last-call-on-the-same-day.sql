/* Write your T-SQL query statement below */
WITH CTE AS (
SELECT caller_id as u1, recipient_id as u2 ,call_time FROM Calls
UNION ALL
SELECT recipient_id as u1, caller_id as u2 ,call_time FROM Calls
),
USER_MAX_MIN as (SELECT  u1 as user_id, MIN(call_time) as first_call, MAX(call_time) as last_call, cast(call_time as date) as day FROM CTE GROUP BY u1,cast(call_time as date))
select distinct user_id --,u.*, c1.*, c2.* 
from USER_MAX_MIN u 
left join cte c1 on u.first_call = c1.call_time 
left join cte c2 on u.last_call = c2.call_time
WHERE c1.u2 = c2.u2 AND ISNULL(user_id,0) <> ISNULL(c2.u2,0)  --AND ISNULL(user_id,0) <> ISNULL(c1.u2,0)