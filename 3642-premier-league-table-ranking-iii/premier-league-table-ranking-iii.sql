/* Write your T-SQL query statement below */
SELECT season_id, team_id, team_name, wins*3+draws*1 as points, goals_for -goals_against as goal_difference,  ROW_NUMBER() OVER(PARTITION BY SEASON_ID ORDER BY wins*3+draws*1 desc,( goals_for -goals_against) desc, team_name asc ) as position
FROM SeasonStats
ORDER BY season_id asc, position asc, team_name asc