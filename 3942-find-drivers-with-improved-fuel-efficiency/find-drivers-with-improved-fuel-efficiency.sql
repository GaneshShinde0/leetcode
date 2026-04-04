# Write your MySQL query statement below
SELECT driver_id, driver_name, ROUND(first_half_avg,2) as first_half_avg , ROUND(second_half_avg,2) as second_half_avg, 
ROUND(second_half_avg-first_half_avg,2) as efficiency_improvement from (SELECT d.driver_id, d.driver_name, 
SUM(CASE 
WHEN MONTH(trip_date)>=0 and MONTH(trip_date)<=6 THEN distance_km/fuel_consumed 
ELSE 0 
END)/SUM(CASE 
WHEN MONTH(trip_date)>=0 and MONTH(trip_date)<=6 THEN 1
ELSE 0 
END) as first_half_avg,
SUM(CASE 
WHEN MONTH(trip_date)>=7 and MONTH(trip_date)<=12 THEN distance_km/fuel_consumed 
ELSE 0 
END)/SUM(CASE 
WHEN MONTH(trip_date)>=7 and MONTH(trip_date)<=12 THEN 1
ELSE 0 
END) as second_half_avg FROM 
DRIVERS d left join trips t on d.driver_id = t.driver_id 
GROUP BY d.driver_id,d.driver_name) src
WHERE second_half_avg-first_half_avg>0
ORDER BY ROUND(second_half_avg-first_half_avg,2)  DESC, 2 asc