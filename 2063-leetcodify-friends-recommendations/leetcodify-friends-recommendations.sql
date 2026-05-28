/* Write your T-SQL query statement below */
WITH Listen as (SELECT DISTINCT user_id, song_id, day From Listens),
CURR_FRIENDS as(
    SELECT CONCAT(user1_id,'-',user2_id) friends FROM Friendship
    UNION ALL 
    SELECT CONCAT(user2_id,'-',user1_id) FROM Friendship
)
SELECT distinct l1.user_id, l2.user_id recommended_id From Listen l1 inner join Listen l2 on l1.song_id = l2.song_id and l1.day = l2.day WHERE l1.user_id<>l2.user_id and (CONCAT(l1.user_id,'-',l2.user_id) NOT IN 
(SELECT friends from CURR_FRIENDS))
GROUP BY  l1.user_id, l2.user_id,l1.day  HAVING COUNT(*)>=3
ORDER BY 1 desc
