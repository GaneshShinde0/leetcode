/* Write your T-SQL query statement below */

SELECT *, goal_for-goal_against as goal_diff FROM (SELECT team_name, COUNT(*) as matches_played, 
 SUM(
 IIF(home_team_id = t.team_id and home_team_goals>away_team_goals,3,
 IIF(away_team_id = t.team_id and home_team_goals<away_team_goals,3,
 IIF(home_team_goals=away_team_goals,1,0)))) as points,
 SUM(IIF(home_team_id=t.team_id, home_team_goals, away_team_goals)) as goal_for, 
 SUM(IIF(home_team_id=t.team_id, away_team_goals, home_team_goals)) as goal_against
FROM Teams t 
JOIN Matches m ON t.team_id = m.home_team_id or t.team_id = m.away_team_id
GROUP BY team_name ) as SRC
ORDER BY 3 DESC, 6 DESC, 1 ASC