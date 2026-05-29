/* Write your T-SQL query statement below */
WITH CTE AS (SELECT flight_id, count(*) as total FROM Passengers GROUP BY flight_id)
SELECT f.flight_id, CASE WHEN c.total>f.capacity THEN f.capacity ELSE COALESCE(c.total,0) END as booked_cnt,
CASE WHEN c.total>f.capacity THEN c.total-f.capacity ELSE 0 END as waitlist_cnt
FROM Flights f left join CTE c on f.flight_id = c.flight_id 
ORDER BY 1 ASC