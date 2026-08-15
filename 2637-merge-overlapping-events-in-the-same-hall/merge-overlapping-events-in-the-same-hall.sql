WITH PreviousMax AS (SELECT hall_id, start_day, end_day, MAX(end_day) OVER(
    PARTITION BY hall_id ORDER BY start_day, end_day
    ROWS BETWEEN UNBOUNDED PRECEDING AND 1 PRECEDING
)as prev_max_end FROM HallEvents),
GroupFlags as (SELECT pm1.hall_id, start_day, end_day, prev_max_end,
CASE 
    WHEN prev_max_end IS null THEN 1
    WHEN start_day>prev_max_end THEN 1
    ELSE 0
END  as isNewGroup
FROM PreviousMax pm1),
AssignedGroups AS (
    SELECT 
        hall_id, 
        start_day,
        end_day,
        SUM(isNewGroup) OVER 
            (PARTITION BY hall_id ORDER BY start_day, end_day) as group_id
        FROM GroupFlags
)
SELECT hall_id, MIN(start_day) as start_day, max(end_day) as end_day FROM AssignedGroups
GROUP BY GROUP_ID, hall_id