WITH ConsecutiveDays as(
    SELECT 
        curr.user_id, 
        curr.steps_date,
        AVG(prev.steps_count*1.0) AS rolling_avg
    FROM 
        Steps AS Curr
    JOIN 
        Steps AS Prev on curr.user_id = prev.user_id 
            AND prev.steps_date BETWEEN DATEADD(DAY,-2, curr.steps_date) AND curr.steps_date
    GROUP BY 
        curr.user_id, curr.steps_date
    HAVING 
        COUNT(prev.steps_date) = 3
)
SELECT 
    user_id,
    steps_date,
    ROUND(rolling_avg,2) AS rolling_average
FROM 
    ConsecutiveDays
ORDER BY 
    user_id, steps_date;