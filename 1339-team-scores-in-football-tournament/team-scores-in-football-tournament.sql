/* Write your T-SQL query statement below */

-- SELECT t.team_id, team_name, SUM(
--     CASE WHEN m.host_goals>m.guest_goals THEN 3
--     WHEN m.host_goals=m.guest_goals THEN 1
--     WHEN m2.host_goals<m2.guest_goals THEN 3
--     WHEN m2.host_goals=m2.guest_goals THEN 1
--     ELSE 0 END
--     ) as num_points
-- FROM Teams t FULL OUTER join MATCHES m on t.team_id = m.host_team
-- FULL OUTER JOIN MATCHES m2 on t.team_id=m2.guest_team
-- GROUP BY t.team_id, team_name
-- ORDER BY num_points DESC

/*
WITH ALL_MATCHES AS (
    SELECT host_team as team_id, case 
        when host_goals>guest_goals then 3
        WHEN host_goals=guest_goals then 1
        ELSE 0 END as points
    FROM matches
    UNION ALL
    SELECT guest_team as team_id, case 
        when host_goals<guest_goals then 3
        WHEN host_goals=guest_goals then 1
        ELSE 0 END as points
    FROM matches
)
SELECT t.team_id, t.team_name, COALESCE(SUM(points),0) as num_points 
FROM Teams t LEFT JOIN all_matches a
on t.team_id = a.team_id
GROUP BY t.team_id, t.team_name
ORDER BY num_points DESC, TEAM_ID ASC

*/

/* Write your T-SQL query statement below */
SELECT team_id, team_name, 
SUM( 
    CASE WHEN team_id = host_team AND host_goals > guest_goals THEN 3 
         WHEN team_id = guest_team AND guest_goals > host_goals THEN 3 
         WHEN host_goals = guest_goals THEN 1 
         ELSE 0 
    END           
) AS num_points
FROM Teams t 
LEFT JOIN Matches m ON t.team_id = m.host_team OR t.team_id = m.guest_team 

GROUP BY team_id, team_name 

ORDER BY num_points DESC, team_id 