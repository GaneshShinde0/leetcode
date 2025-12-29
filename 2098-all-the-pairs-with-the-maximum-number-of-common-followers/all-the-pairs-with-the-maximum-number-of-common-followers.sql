/* Write your T-SQL query statement below */
WITH CTE as (SELECT a.user_id as user1_id, b.user_id as user2_id, COUNT(*) as cnt
FROM Relations a
JOIN Relations b
on a.follower_id = b.follower_id
AND a.user_id<b.user_id
GROUP BY a.user_id, b.user_id)

SELECT user1_id, user2_id
FROM CTE
WHERE cnt = (select max(cnt) from CTE)