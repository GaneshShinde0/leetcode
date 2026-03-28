-- Write your PostgreSQL query statement below
WITH CTE AS(
    SELECT player_id, group_id,
    RANK() OVER(PARTITION BY group_id ORDER BY  SUM(CASE WHEN p.player_id = m.first_player THEN  m.first_score ELSE m.second_score END ) DESC, player_id asc ) as RNK
     FROM Players p 
    JOIN Matches m on m.first_player = p.player_id
     OR
    m.second_player = p.player_id
    GROUP BY group_id, player_id
)
SELECT group_id, player_id FROM CTE WHERE RNK = 1