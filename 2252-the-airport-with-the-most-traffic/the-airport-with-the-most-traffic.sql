/* Write your T-SQL query statement below */

WITH CTE as(
    SELECT departure_airport as airport_id, flights_count FROM Flights
    UNION ALL
    SELECT arrival_airport as airport_id, flights_count FROM Flights
),
--SELECT airport_id,sum(flights_count) as sum from CTE GROUP by airport_id having sum(flights_count) = MAX(sum) order by SUM(flights_count) DESC
CTE2 as (
    SELECT DISTINCT airport_id, sum(flights_count) over(PARTITION BY airport_id) as sum from CTE 
)
SELECT airport_id FROM CTE2 WHERE sum = (SELECT MAX(SUM) FROM CTE2);
--GROUP by airport_id having sum(flights_count) = MAX(sum) order by SUM(flights_count) DESC

-- SELECT t1.departure_airport as airport_id, SUM(t1.flights_count+t2.flights_count) as count FROM Flights t1
-- left join Flights t2 on t1.departure_airport = t2.arrival_airport
-- GROUP by t1.departure_airport
-- ORDER BY  t1.flights_count+t2.flights_count DESC