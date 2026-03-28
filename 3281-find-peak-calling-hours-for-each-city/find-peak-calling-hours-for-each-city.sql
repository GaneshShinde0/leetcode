# Write your MySQL query statement below
/*
SELECT City, peak_calling_hour, number_of_calls FROM (SELECT City, HOUR(call_time) as peak_calling_hour, count(*) as number_of_calls, DENSE_RANK() over(PARTITION BY city ORDER BY count(*) DESC ) as rnk
FROM Calls GROUP BY City,HOUR(call_time)
) src where rnk =  1 ORDER BY peak_calling_hour DESC,city DESC

*/
SELECT City, peak_calling_hour, number_of_calls 
FROM (
    SELECT City, HOUR(call_time) AS peak_calling_hour, COUNT(*) AS number_of_calls
    FROM Calls 
    GROUP BY City, HOUR(call_time)
) src 
WHERE number_of_calls = (
    /* This subquery finds the maximum count for the current city in src */
    SELECT COUNT(*) AS max_calls
    FROM Calls
    WHERE City = src.City
    GROUP BY HOUR(call_time)
    ORDER BY max_calls DESC
    LIMIT 1
) 
ORDER BY peak_calling_hour DESC, City DESC;