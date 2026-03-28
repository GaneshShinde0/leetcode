# Write your MySQL query statement below

SELECT City, peak_calling_hour, number_of_calls FROM (SELECT City, HOUR(call_time) as peak_calling_hour, count(*) as number_of_calls, DENSE_RANK() over(PARTITION BY city ORDER BY count(*) DESC ) as rnk
FROM Calls GROUP BY City,HOUR(call_time)
) src where rnk =  1 ORDER BY peak_calling_hour DESC,city DESC