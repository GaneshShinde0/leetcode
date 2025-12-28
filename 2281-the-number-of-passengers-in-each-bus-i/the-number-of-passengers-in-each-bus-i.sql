/*
WITH T as (
    SELECT passenger_id, MIN(b.arrival_time) as boarding_time 
    FROM Passengers p 
    INNER JOIN Buses b
    ON p.arrival_time<=b.arrival_time
    GROUP BY passenger_id
)

SELECT bus_id, COUNT(T.boarding_time) as passengers_cnt
FROM Buses b LEFT Join T on b.arrival_time = T.boarding_time
GROUP BY bus_id ORDER BY bus_id ASC;
*/
WITH CTE As (
    Select bus_id, arrival_time, LAG(arrival_time, 1, 0) OVER (ORDER BY arrival_time) min_time FROM buses
)
SELECT cte.bus_id, COUNT(passenger_id) as passengers_cnt
FROM CTE 
LEFT JOIN Passengers p ON
p.arrival_time>cte.min_time AND p.arrival_time<=cte.arrival_time
GROUP BY cte.bus_id
ORDER BY 1;