WITH CTE AS
(SELECT user1_id, user2_id FROM Friendship
UNION ALL
SELECT user2_id, user1_id FROM Friendship)
SELECT DISTINCT user2_id as user_id ,l.page_id, count(*) as friends_likes from CTE c left join likes l on c.user1_id = l.user_id 
WHERE   NOT EXISTS (
    SELECT 1 FROM Likes l2 WHERE l2.user_id=c.user2_id AND l2.page_id = l.page_id
)
GROUP BY user2_id, page_id 
ORDER BY 1 ASC