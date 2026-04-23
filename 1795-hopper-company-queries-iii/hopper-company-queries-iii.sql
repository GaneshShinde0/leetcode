
WITH MONTHS as (
    SELECT 1 as month 
    UNION ALL
    SELECT MONTH+1 FROM MONTHS WHERE MONTH<12
),
MONTHLY_RIDES as
(SELECT 
month , 
ISNULL(SUM(ride_distance), 0) as ride_distance ,
ISNULL(SUM(ride_duration), 0) as ride_duration FROM MONTHS m  
left Join Rides r on (MONTH(r.requested_at ) = m.MONTH AND YEAR(r.requested_at )=2020)
left join AcceptedRides a on r.ride_id = a.ride_id  
GROUP BY m.MONTH)

SELECT TOP 10  month, ROUND(AVG(ride_distance*1.0) OVER (
    ORDER BY month 
    ROWS BETWEEN CURRENT ROW AND 2 FOLLOWING
),2) as average_ride_distance , 
ROUND(AVG(ride_duration*1.0) OVER (
    ORDER BY month 
    ROWS BETWEEN CURRENT ROW AND 2 FOLLOWING
),2) as average_ride_duration 
FROM MONTHLY_RIDES 