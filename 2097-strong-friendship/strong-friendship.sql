WITH CTE AS (
    SELECT user1_id, user2_id FROM Friendship
    UNION
    SELECT user2_id, user1_id FROM Friendship
)

SELECT fr.user1_id, fr.user2_id, COUNT(cte2.user2_id) as common_friend
FROM Friendship fr
JOIN CTE cte1 ON fr.user1_id = cte1.user1_id  -- All Friends Of User 1
JOIN CTE cte2 ON fr.user2_id = cte2.user2_id  -- All Friends Of User 2
    AND cte1.user2_id = cte2.user1_id -- Common Friends.
GROUP BY fr.user1_id, fr.user2_id
HAVING count(cte2.user2_id)>=3