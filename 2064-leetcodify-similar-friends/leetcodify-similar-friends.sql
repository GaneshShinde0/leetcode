
WITH UniqueListens AS (
    SELECT DISTINCT user_id, song_id, day 
    FROM Listens
)
SELECT DISTINCT 
    l1.user_id as user1_id,
    l2.user_id AS user2_id 
FROM UniqueListens l1 
INNER JOIN UniqueListens l2 
    ON l1.song_id = l2.song_id 
    AND l1.day = l2.day 
    AND l1.user_id <> l2.user_id
INNER JOIN Friendship f
    ON (
        (f.user1_id = l1.user_id AND f.user2_id = l2.user_id)
)
AND l1.user_id<l2.user_id
GROUP BY l1.user_id, l2.user_id, l1.day  
HAVING COUNT(*) >= 3;