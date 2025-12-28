WITH T as (
    SELECT passenger_id, MIN(b.arrival_time) as boarding_time 
    FROM Passengers p 
    INNER JOIN Buses b
    ON p.arrival_time<=b.arrival_time
    GROUP BY passenger_id
)

SELECT bus_id, COUNT(T.boarding_time) as passengers_cnt
FROM Buses b LEFT Join T on b.arrival_time = T.boarding_time
GROUP BY bus_id ORDER BY bus_id ASC