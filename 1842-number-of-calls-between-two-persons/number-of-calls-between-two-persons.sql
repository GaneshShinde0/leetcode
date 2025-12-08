SELECT 
    CASE WHEN from_id<to_id THEN from_id ELSE to_id END as person1,
    CASE WHEN from_id>to_id THEN from_id ELSE to_id END as person2,
    COUNT(*) as call_count,
    SUM(duration) as total_duration
FROM Calls
GROUP BY
    CASE WHEN from_id<to_id THEN from_id ELSE to_id END,
    CASE WHEN from_id>to_id THEN from_id ELSE to_id END