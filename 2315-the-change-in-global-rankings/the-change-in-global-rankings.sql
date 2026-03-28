SELECT 
    a.team_id, 
    a.name,
    (ROW_NUMBER() OVER(ORDER BY points DESC, name ASC))::BIGINT - 
    (ROW_NUMBER() OVER(ORDER BY (points + points_change) DESC, name ASC))::BIGINT AS rank_diff
FROM TeamPoints a
JOIN PointsChange b ON a.team_id = b.team_id;